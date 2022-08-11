package com.pronaca.osoc.lecturaxml.sftp;

import java.util.Date;
import java.util.List;

import com.jcraft.jsch.ChannelSftp;
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
	 * 
	 * @param nameFile
	 * @param pathSftp
	 * @param pathDownload
	 * @param channelSftp
	 * @return
	 * @throws Exception
	 */
	RespuestaSFTP downloadListFiles(String nameFile, String pathSftp, String pathDownload, ChannelSftp channelSftp) throws Exception;
	
	/**
	 * 
	 * @param usuarioSftp
	 * @param passwordSftp
	 * @param servidorSftp
	 * @param puertoSftp
	 * @return
	 * @throws Exception
	 */
	ChannelSftp createChannel(String usuarioSftp, String passwordSftp, String servidorSftp, int puertoSftp)throws Exception;
	
	/**
	 * 
	 * @param channelSftp
	 * @throws Exception
	 */
	void disconnectChannel(ChannelSftp channelSftp)throws Exception;
	
	/**
	 * 
	 * @param nameFile
	 * @param usuarioSftp
	 * @param passwordSftp
	 * @param servidorSftp
	 * @param puertoSftp
	 * @param pathSftp
	 * @return
	 * @throws Exception
	 */
	void deleteFile(Date date, String nameFile, String usuarioSftp, String passwordSftp, String servidorSftp,
			int puertoSftp, String pathSftp) throws Exception;
	
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
