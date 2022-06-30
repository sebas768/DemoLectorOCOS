package com.pronaca.osoc.lecturaxml.sftp;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;

public interface IClienteSFTP {


	RespuestaSFTP downloadFile(String nameFile, String sistema, String usuarioSftp, String passwordSftp,
			String servidorSftp, int puertoSftp, String pathSftp, String pathDownload);
}
