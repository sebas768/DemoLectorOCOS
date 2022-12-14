package com.pronaca.osoc.lecturaxml.loaderxml.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp;
import com.pronaca.osoc.lecturaxml.loaderxml.ILeerXmlStream;
import com.pronaca.osoc.lecturaxml.loaderxml.ILoaderXml;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.xml.ModelOcos;
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
	private ILecturaXmlService lecturaXmlService;
	
	@Autowired
	private IArchivoXmlService archivoXmlService;
	
	@Autowired
	private ILeerXmlStream<ModelOcos, String> iLeerXmlStream;
	
	protected List<ModelOcos> ocosData;

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

	@Override
	public String loadXml() throws Exception {
		System.out.println("==> INICIA LECTURA_XML OCOS - SFTP");
		long tiempoInicio = System.currentTimeMillis();
		List<String> nameFiles = clienteSFTP.getNameFiles(getUsuarioSFTP(), getPasswordSFTP(), getServidorSFTP(),
				getPuertoSFTP(), getPathSFTP());
		ChannelSftp channelSftp = clienteSFTP.createChannel(getUsuarioSFTP(), getPasswordSFTP(), getServidorSFTP(), getPuertoSFTP());
		nameFiles.stream().forEach(file -> {
			try {
				if (file != null) {
					if(!archivoXmlService.fileExist(file)) {
						loadJob(file, channelSftp); 
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		tiempoInicio = System.currentTimeMillis() - tiempoInicio;
		System.out.println("==> FINALIZA LECTURA_XML - OCOS - SFTP, Tiempo de ejecuci??n: " + tiempoInicio); 
		clienteSFTP.disconnectChannel(channelSftp);
		return "OK"; 
	}
	
	@Override
	public String deleteXml() throws Exception {
		long tiempoInicio = System.currentTimeMillis();
		clienteSFTP.deleteFile(new Date(), getPathDownload(), getUsuarioSFTP(), getPasswordSFTP(), getServidorSFTP(), getPuertoSFTP(), getPathSFTP());
		tiempoInicio = System.currentTimeMillis() - tiempoInicio;
		System.out.println(" --> Finaliza borrado archivos - SFTP, Tiempo de ejecuci??n: " + tiempoInicio); 
		return "OK"; 
	}

	private String loadJob(String nameFile, ChannelSftp channelSftp) throws Exception {
		return uploadData(getLeerXmlStream(nameFile, channelSftp)); 
	} 

	public RespuestaSFTP getLeerXmlStream(String nameFile) throws Exception {
		try {
			RespuestaSFTP resp = clienteSFTP.downloadFile(nameFile, getUsuarioSFTP(), getPasswordSFTP(),
					getServidorSFTP(), getPuertoSFTP(), getPathSFTP(), getPathDownload());
			if (resp.getFileDownload() != null) {
				//Lectura Xml
				ocosData = iLeerXmlStream.obtenerDatos(resp, ModelOcos.class);
				return resp;
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	public RespuestaSFTP getLeerXmlStream(String nameFile, ChannelSftp channelSftp) throws Exception {
		try {
			RespuestaSFTP resp = clienteSFTP.downloadListFiles(nameFile, getPathSFTP(), getPathDownload(), channelSftp);
			if (resp.getFileDownload() != null) {
				//Lectura Xml
				ocosData = iLeerXmlStream.obtenerDatos(resp, ModelOcos.class);
				return resp;
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}
	
	protected String uploadData(RespuestaSFTP resp) throws Exception {
		long tiempoInicio = System.currentTimeMillis();
		StringBuilder retorno = new StringBuilder();
		try {
			try {
				if (ocosData != null && !ocosData.isEmpty()) {
					ocosData.stream().forEach(xml -> {
						try {
							if (xml != null) {
								// Verifica si el entity es valido 
								Boolean isValidEntity = xml.isValidEntiti();
								Boolean isSaveXml = false;
								if (isValidEntity) {
									isSaveXml = lecturaXmlService.cargarData(xml); 
								} 
								if (isSaveXml) {
									lecturaXmlService.cargarXml(resp); 
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
			//Delete file system
			Path path = Paths.get(resp.getFileDownload().getPath());
			if (Files.deleteIfExists(path)) {
				System.out.println(" | Liberado xml");
			} 
			System.out.println(" | Finaliza lectura xml, Tiempo: " + tiempoInicio);
		}
		
		tiempoInicio = System.currentTimeMillis() - tiempoInicio;
		return retorno.toString();
	}
	
	public LoaderXmlImpl() {}
}
