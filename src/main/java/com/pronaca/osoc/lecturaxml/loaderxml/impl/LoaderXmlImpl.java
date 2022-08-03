package com.pronaca.osoc.lecturaxml.loaderxml.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.loaderxml.ILeerXmlStream;
import com.pronaca.osoc.lecturaxml.loaderxml.ILoaderXml;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.xml.Transaccion;
import com.pronaca.osoc.lecturaxml.sftp.IClienteSFTP;
import com.pronaca.osoc.lecturaxml.util.Constantes;
import com.pronaca.osoc.lecturaxml.view.service.IArchivoXmlService;
import com.pronaca.osoc.lecturaxml.view.service.IParametroGeneralService;
import com.pronaca.osoc.lecturaxml.view.servicexml.ILecturaXmlService;

@Service
public class LoaderXmlImpl implements ILoaderXml {

	@Autowired
	private IParametroGeneralService generalService;
	@Autowired
	private IClienteSFTP clienteSFTP;
	@Autowired
	private ILeerXmlStream<Transaccion, String> iLeerXmlStream;
	@Autowired
	private ILecturaXmlService aplicaPromocionService;
	@Autowired
	private IArchivoXmlService archivoXmlService;

	protected List<Transaccion> registros;

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

	public LoaderXmlImpl() {
	}

	@Override
	public String loadXml() throws Exception {
		System.out.println(" | Inicia LecturaXml - SFTP");
		long tiempoInicio = System.currentTimeMillis();
		List<String> nameFiles = clienteSFTP.getNameFiles(getUsuarioSFTP(), getPasswordSFTP(), getServidorSFTP(),
				getPuertoSFTP(), getPathSFTP());
		
		nameFiles.stream().forEach(file -> {
			try {
				if(!archivoXmlService.fileExist(file)) {
					loadJob(file);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		tiempoInicio = System.currentTimeMillis() - tiempoInicio;
		System.out.println(" | Finaliza LecturaXml - SFTP, Tiempo: " + tiempoInicio);
		return "OK";
	}

	private String loadJob(String nameFile) throws Exception {
		getLeerXmlStream(nameFile);
		return uploadData(nameFile); 
	} 

	public void getLeerXmlStream(String nameFile) throws Exception {
		try {
			RespuestaSFTP resp = clienteSFTP.downloadFile(nameFile, getUsuarioSFTP(), getPasswordSFTP(),
					getServidorSFTP(), getPuertoSFTP(), getPathSFTP(), getPathDownload());
			if (resp.getFileDownload() != null) {
				
				// TODO aqui llamar al servicio para guardar el archivo en blob
				aplicaPromocionService.cargarXml(resp);
				// Lectura Xml
				registros = iLeerXmlStream.obtenerDatos(resp, Transaccion.class);
				
			}
		} catch (Exception e) {
			throw e;
		}
	}

	protected String uploadData(String nameFile) throws Exception {
		long tiempoInicio = System.currentTimeMillis();
		StringBuilder retorno = new StringBuilder();

		try {
			try {
				if (registros != null && !registros.isEmpty()) {
					registros.parallelStream().forEach(xml -> {
						try {
							if (xml != null) {
								// Verifica si el entity es valido 
								Boolean isValidEntity = xml.isValidEntiti();
								if (isValidEntity) {
									aplicaPromocionService.cargar(xml); 
								}
							}
						} catch (Exception e) {
						}
					});
				}
			} catch (Exception e) {
				retorno.append("Error al transferir valores desde XML a JPA ");
				retorno.append(" ");
				retorno.append(e.getMessage());
				throw e;
			}
		} catch (Exception e) {

			throw e;
		} finally {
			System.gc();
		}
		tiempoInicio = System.currentTimeMillis() - tiempoInicio;
		System.out.println(" | Finaliza lectura " + nameFile + ", Tiempo: " + tiempoInicio);
		
		return retorno.toString();
	}
}
