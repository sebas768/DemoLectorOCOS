package com.pronaca.osoc.lecturaxml.model.dto;

import java.io.Serializable;
import java.io.File;
import java.io.InputStream;

public class RespuestaSFTP implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2513506782694494679L;
	private Long fechaArchivo;
	private Long taminioArchivo;
	private File fileDownload;
	private String nombreArchivo;

	public Long getFechaArchivo() {
		return fechaArchivo;
	}

	public void setFechaArchivo(Long fechaArchivo) {
		this.fechaArchivo = fechaArchivo;
	}

	public Long getTaminioArchivo() {
		return taminioArchivo;
	}

	public void setTaminioArchivo(Long taminioArchivo) {
		this.taminioArchivo = taminioArchivo;
	}

	public File getFileDownload() {
		return fileDownload;
	}

	public void setFileDownload(File fileDownload) {
		this.fileDownload = fileDownload;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public String toString() {
		return nombreArchivo + ", " + fechaArchivo.toString();
	}
}
