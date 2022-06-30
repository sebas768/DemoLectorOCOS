package com.pronaca.osoc.lecturaxml.loaderxml.impl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Table;
import javax.xml.stream.XMLStreamException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pronaca.osoc.lecturaxml.anotacions.LoaderAnotation;
import com.pronaca.osoc.lecturaxml.anotacions.Sistema;
import com.pronaca.osoc.lecturaxml.exceptions.DAOException;
import com.pronaca.osoc.lecturaxml.exceptions.NotFundEntityException;
import com.pronaca.osoc.lecturaxml.exceptions.ValidaEntityException;
import com.pronaca.osoc.lecturaxml.loaderxml.ILeerXmlStream;
import com.pronaca.osoc.lecturaxml.loaderxml.ILoaderGeneric;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.CargaError;
import com.pronaca.osoc.lecturaxml.model.entities.CargaIdb;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.model.generic.CargaIDBGeneric;
import com.pronaca.osoc.lecturaxml.sftp.IClienteSFTP;
import com.pronaca.osoc.lecturaxml.util.Constantes;
import com.pronaca.osoc.lecturaxml.util.FechaUtil;
import com.pronaca.osoc.lecturaxml.view.dao.ICargaDAO;
import com.pronaca.osoc.lecturaxml.view.service.IParametroGeneralService;
import com.pronaca.osoc.lecturaxml.view.servicexml.IServiceXmlGeneric;

public abstract class LoaderGenericImpl<T extends Serializable, Pk extends Serializable>
		implements ILoaderGeneric<T, Pk> {

	@Autowired
	private ICargaDAO iCargaDAO;
	@Autowired
	private IParametroGeneralService generalService;
	@Autowired
	private IClienteSFTP clienteSFTP;

	@Autowired
	private ILeerXmlStream<T, Pk> iLeerXmlStream;

	public abstract IServiceXmlGeneric<T, Pk> getDAO();

	protected String nombreArchivoXmlFtp;
	protected List<T> registros;
	protected Class<T> entity;
	protected CargaIdb cargaIDB = new CargaIdb();
	protected Boolean cargaTableActiva = false;
	protected Boolean isUpdateEstatus = false;
	protected EstadoEnum estadoInactivo = null;
	protected String columnEstatus = null;
	protected String queryFilter = null;
	protected String sp = null;
	protected String dataSourceName = null;
	protected String[] conditions = {};

	@Override
	public String getPasswordSFTP() throws Exception {
		return generalService.getString(Constantes.PK_PASSWORD_FTP);
	}

	@Override
	public String getPathSFTP() throws Exception {
		return generalService.getString(Constantes.PK_PATH_SFTP);
	}

	@Override
	public int getPuertoSFTP() throws Exception {
		return generalService.getInteger(Constantes.PK_PUERTO_SFTP);
	}

	@Override
	public String getServidorSFTP() throws Exception {
		return generalService.getString(Constantes.PK_SERVIDOR_SFTP);
	}

	@Override
	public String getUsuarioSFTP() throws Exception {
		return generalService.getString(Constantes.PK_USUARIO_FTP);
	}

	public String getPathDownload() throws Exception {
		return generalService.getString(Constantes.PK_RUTA_DESCARGAR);
	}

	public LoaderGenericImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) type;
			this.entity = (Class<T>) paramType.getActualTypeArguments()[0];
		} else {
			throw new IllegalArgumentException("Could not guess entity class by reflection");
		}

		Annotation anotation = this.entity.getAnnotation(LoaderAnotation.class);
		if (anotation instanceof LoaderAnotation) {
			LoaderAnotation anotacion = (LoaderAnotation) anotation;
			nombreArchivoXmlFtp = anotacion.fileXML();
			isUpdateEstatus = anotacion.isUpdateEstatus();
			estadoInactivo = anotacion.valueInactive();
			columnEstatus = anotacion.columnEstatus();
			conditions = anotacion.conditionsUpdate();
			sp = anotacion.procedureQuerry();
		}
	}

	@Override
	public String loadJob() throws Exception {
		loadStream();
		return uploadData();
	}

	@Override
	public String loadView() throws Exception {
		return loadJob();
	}

	public void getLeerXmlStream() throws Exception {
		try {
			RespuestaSFTP resp = clienteSFTP.downloadFile(nombreArchivoXmlFtp, cargaIDB.getSistema(), getUsuarioSFTP(),
					getPasswordSFTP(), getServidorSFTP(), getPuertoSFTP(), getPathSFTP(), getPathDownload());
			if (resp.getFileDownload() != null) {
				registros = iLeerXmlStream.obtenerDatos(resp, entity);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void loadStream() throws Exception {
		try {
			cargaIDB = new CargaIdb();
			Sistema sistema = null;
			Annotation anotation = entity.getAnnotation(Table.class);
			anotation = entity.getAnnotation(Table.class);
			if (anotation instanceof Table) {
				Table anotacion = (Table) anotation;
				cargaIDB.setNombreTabla(anotacion.name());
			}
			anotation = entity.getSuperclass().getAnnotation(Sistema.class);
			if (anotation instanceof Sistema) {
				sistema = (Sistema) anotation;
				cargaIDB.setSistema(sistema.sistema());
				cargaTableActiva = sistema.activoCarga();
				cargaTableActiva = sistema.activoCarga();
				dataSourceName = sistema.dataSourceName();
			}
			System.out
					.println("---------------INICIA " + cargaIDB.getNombreTabla() + "(" + cargaIDB.getSistema() + ")");
			if (cargaTableActiva) {
				getDAO().loadParameterCarga();
				getLeerXmlStream();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	protected String uploadData() throws Exception {
		long tiempoInicio = System.currentTimeMillis();
		StringBuilder retorno = new StringBuilder();
		if (cargaTableActiva)
			try {
				try {
					final int i = 0;
					int contadorNuevos = 0;
					int contadorEditados = 0;
					int contadorErrores = 0;
					String estado = Constantes.ESTADO_EXITO;
					int numeroRegistrosInactivados = 0;
					if (registros != null && !registros.isEmpty()) {
						cargaIDB.setEstado(estado);
						cargaIDB.setFechaInicio(Calendar.getInstance().getTime());
						// cargaIDB.setTamanoArchivo(leeXmlStream.getTamanoArchivo() + " KB");
						// cargaIDB.setFechaArchivo(leeXmlStream.getFechaArchivo());
						iCargaDAO.crearCarga(cargaIDB);

						if (!registros.isEmpty())
							if (isUpdateEstatus) {
								numeroRegistrosInactivados = getDAO().actualizarEntidades(estadoInactivo, columnEstatus,
										conditions);
							}
						registros.parallelStream().forEach(xml -> {
							try {
								if (xml != null) {
									CargaIDBGeneric<Pk> persistentGeneric = (CargaIDBGeneric<Pk>) xml;
									// Verifica si el entity es valido
									Boolean isValidEntity = persistentGeneric.isValidEntiti();
									if (isValidEntity) {
										// Obtenemos la primary key
										Pk key = persistentGeneric.getPk();
										try {
											try {
												getDAO().findById(key);
												getDAO().update(xml);
												// contadorEditados++;
											} catch (DAOException e) {
												try {
													getDAO().create(xml);
													// contadorNuevos++;
												} catch (Exception e2) {
													// contadorErrores++;
												}
											}
										} catch (ValidaEntityException e) {

											CargaError carErroresCargar = new CargaError();

											iCargaDAO.crearError(carErroresCargar);
										} catch (NotFundEntityException e) {
											// contadorErrores++;
										} catch (Exception e) {
											CargaError carErroresCargar = new CargaError();
											carErroresCargar.setCargaIdb(cargaIDB);
											iCargaDAO.crearError(carErroresCargar);
										}

									} else {
										// contadorErrores++;
									}
								} else {
									// contadorErrores++;
								}
								// i++;
							} catch (Exception e) {
								// TODO: handle exception
							}
						});

						// Registrar en tabla IDB resultados de
						// procesamiento
						retorno.append("Estadísitca de procesamiento " + nombreArchivoXmlFtp + ": ");
						retorno.append(" Nuevos = ");
						retorno.append(contadorNuevos);
						retorno.append(", Actualizados = ");
						retorno.append(contadorEditados);
						retorno.append(", No procesados = ");
						retorno.append(contadorErrores);
						retorno.append(", Inactivados = ");
						retorno.append(numeroRegistrosInactivados);
						retorno.append(", Tiempo de procesamiento = ");
						retorno.append(FechaUtil.getTiempoDuracion(tiempoInicio));
						cargaIDB.setEstado(estado);
						cargaIDB.setFechaFin(Calendar.getInstance().getTime());
						cargaIDB.setResultado(retorno.toString());
						if (cargaIDB.getResultado().length() > 500) {
							cargaIDB.setResultado(cargaIDB.getResultado().substring(0, 500));
						}
						if (iCargaDAO.buscar(cargaIDB.getCodigo()) != null) {
							iCargaDAO.actualizarCarga(cargaIDB);
						}
						// EN CASO DE ENVIAR U EMAIL, LOGICA AQUI
					}
				} catch (XMLStreamException xmlstre) {
					retorno.append("Error al procesar xml ");
					// retorno.append(leeXmlStream.getRutaArchivo());
					retorno.append(" ");
					retorno.append(xmlstre.getMessage());
					throw xmlstre;
				} catch (Exception e) {
					retorno.append("Error al transferir valores desde XML a JPA ");
					// retorno.append(leeXmlStream.getRutaArchivo());
					retorno.append(" ");
					retorno.append(e.getMessage());
					throw e;
				}
			} catch (Exception e) {
				System.out.println("ERROR LOADER " + cargaIDB.getSistema() + " " + entity.getSimpleName() + ": "
						+ e.getMessage() + " " + e.getLocalizedMessage());
				throw e;
			} finally {
				// leeXmlStream = null;
				System.gc();
			}
		System.out.println("---------------FINALIZA " + cargaIDB.getNombreTabla() + "(" + cargaIDB.getSistema() + ")");
		return retorno.toString();
	}
}
