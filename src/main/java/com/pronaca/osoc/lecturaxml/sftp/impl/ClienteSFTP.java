package com.pronaca.osoc.lecturaxml.sftp.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.sftp.IClienteSFTP;

@Service
public class ClienteSFTP implements IClienteSFTP {

	private Logger logger = LoggerFactory.getLogger(ClienteSFTP.class);

	@Override
	public synchronized RespuestaSFTP downloadFile(String nameFile, String usuarioSftp, String passwordSftp, String servidorSftp,
			int puertoSftp, String pathSftp, String pathDownload) throws Exception {
		System.out.println("File Name Download: "+nameFile); 
		synchronized (this) {
			ChannelSftp channelSftp = createChannelSftp(usuarioSftp, passwordSftp, servidorSftp, 15000, puertoSftp, 15000);
			System.out.println(usuarioSftp +" - "+ passwordSftp+" - "+ servidorSftp+" - "+  puertoSftp);
			System.out.println(channelSftp==null?"Nulo":"True");
			RespuestaSFTP respuesta = new RespuestaSFTP(); 
			OutputStream outputStream;
			try {
				if (channelSftp != null) { 
					channelSftp.cd(pathSftp);
					File file = new File(pathDownload + nameFile);
					outputStream = new FileOutputStream(file);
					this.mkdirs(pathDownload + nameFile);
					channelSftp.get(nameFile, outputStream);
					respuesta.setNombreArchivo(nameFile);
					respuesta.setTaminioArchivo(file.length());
					respuesta.setFechaArchivo(new Date().getTime());
					respuesta.setFileDownload(file);
				} else
					throw new Exception("No existe conección al SFTP");
	
			} catch (SftpException | IOException ex) {
				logger.error("Error download file", ex);
			} finally {
				disconnectChannelSftp(channelSftp);
			}
	
			return respuesta;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getNameFiles(String usuarioSftp, String passwordSftp, String servidorSftp, int puertoSftp,
			String pathSftp) throws Exception {
		ChannelSftp channelSftp = createChannelSftp(usuarioSftp, passwordSftp, servidorSftp, 15000, puertoSftp, 15000);
		List<String> nameFiles = new ArrayList<>();
		try {
			if (channelSftp != null) {
				channelSftp.cd(pathSftp);
				channelSftp.ls(pathSftp).parallelStream().forEach(c -> {
					LsEntry entry = (LsEntry) c;
					// System.out.println(String.format("%1s ----> %2s", entry.getLongname(),
					// entry.getFilename()));
					if (entry.getLongname().contains("-rw-r--r--"))
						nameFiles.add(entry.getFilename());
				});
			} else
				throw new Exception("No existe conección al SFTP");

		} catch (SftpException ex) {
			logger.error("Error download file", ex);
		} finally {
			disconnectChannelSftp(channelSftp);
		}

		return nameFiles;
	}

	private synchronized ChannelSftp createChannelSftp(String username, String password, String host, Integer sessionTimeout,
			int port, Integer channelTimeout) {
		try {
			
			synchronized (this) {
				JSch jSch = new JSch();
				Session session = jSch.getSession(username, host, port);
				session.setConfig("StrictHostKeyChecking", "no");
				session.setPassword(password);
				session.connect(sessionTimeout);
				Channel channel = session.openChannel("sftp");
				channel.connect(channelTimeout);
				return (ChannelSftp) channel;
			}  
			
		} catch (JSchException ex) {
			logger.error("Create ChannelSftp error", ex);
			ex.printStackTrace();
		}
		return null;
	}

	private void disconnectChannelSftp(ChannelSftp channelSftp) {
		try {
			if (channelSftp == null)
				return;
			if (channelSftp.isConnected())
				channelSftp.disconnect();
			if (channelSftp.getSession() != null)
				channelSftp.getSession().disconnect();
		} catch (Exception ex) {
			logger.error("SFTP disconnect error", ex);
		}
	}

	private void mkdirs(String path) {
		File f = new File(path);
		String fs = f.getParent();
		f = new File(fs);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

}
