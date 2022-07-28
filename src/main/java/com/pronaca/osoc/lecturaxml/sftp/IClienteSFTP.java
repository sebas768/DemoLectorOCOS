package com.pronaca.osoc.lecturaxml.sftp;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;

public interface IClienteSFTP {

	/**
	 * 
	 * @param nameFile
	 * @param usuarioSftp
	 * @param passwordSftp
	 * @param servidorSftp
	 * @param puertoSftp
	 * @param pathSftp
	 * @param pathDownload
	 * @return
	 * @throws Exception
	 */
	RespuestaSFTP downloadFile(String nameFile, String usuarioSftp, String passwordSftp, String servidorSftp,
			int puertoSftp, String pathSftp, String pathDownload) throws Exception;

	/**
	 * Obtiene el listado de nombres
	 * 
	 * @param sistema
	 * @param usuarioSftp
	 * @param passwordSftp
	 * @param servidorSftp
	 * @param puertoSftp
	 * @param pathSftp
	 * @return
	 * @throws Exception 
	 */
	List<String> getNameFiles(String usuarioSftp, String passwordSftp, String servidorSftp, int puertoSftp,
			String pathSftp) throws Exception;
}
