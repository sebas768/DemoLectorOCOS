package com.pronaca.osoc.lecturaxml.sftp.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
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
	public RespuestaSFTP downloadFile(String nameFile, String sistema, String usuarioSftp, String passwordSftp,
			String servidorSftp, int puertoSftp, String pathSftp, String pathDownload) {
		String fileNameDownload = sistema + "_" + nameFile;
		ChannelSftp channelSftp = createChannelSftp(usuarioSftp, passwordSftp, servidorSftp, 15000, puertoSftp, 15000);
		RespuestaSFTP respuesta = new RespuestaSFTP();
		OutputStream outputStream;
		try {
			channelSftp.cd(pathSftp);
			File file = new File(pathDownload + fileNameDownload);
			outputStream = new FileOutputStream(file);
			this.mkdirs(pathDownload + fileNameDownload);
			channelSftp.get(nameFile, outputStream);
			// file.createNewFile();
			respuesta.setNombreArchivo(fileNameDownload);
			respuesta.setTaminioArchivo(file.length());
			respuesta.setFechaArchivo(new Date().getTime());
			respuesta.setFileDownload(file);
		} catch (SftpException | IOException ex) {
			logger.error("Error download file", ex);
		} finally {
			disconnectChannelSftp(channelSftp);
		}

		return respuesta;
	}

	private ChannelSftp createChannelSftp(String username, String password, String host, Integer sessionTimeout,
			int port, Integer channelTimeout) {
		try {
			JSch jSch = new JSch();
			Session session = jSch.getSession(username, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect(sessionTimeout);
			Channel channel = session.openChannel("sftp");
			channel.connect(channelTimeout);
			return (ChannelSftp) channel;
		} catch (JSchException ex) {
			logger.error("Create ChannelSftp error", ex);
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
