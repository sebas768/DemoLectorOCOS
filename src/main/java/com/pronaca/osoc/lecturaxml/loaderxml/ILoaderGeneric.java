package com.pronaca.osoc.lecturaxml.loaderxml;

import java.io.Serializable;

public interface ILoaderGeneric<T extends Serializable, Pk extends Serializable> {

	/**
	 * Metodo que encapsula la logica para la carga de los archivos xml
	 * 
	 * @return
	 * @throws Exception
	 */
	String loadJob() throws Exception;

	/**
	 * Métodoq ue descarga el archivo del servidor FTP
	 * 
	 * @throws Exception
	 */
	void loadStream() throws Exception;

	/**
	 * Metodo invocado desde la vista para la carga manual
	 * 
	 * @return
	 * @throws Exception
	 */
	String loadView() throws Exception;

	public abstract String getUsuarioSFTP() throws Exception;

	public abstract String getPasswordSFTP() throws Exception;

	public abstract int getPuertoSFTP() throws Exception;

	public abstract String getServidorSFTP() throws Exception;

	public abstract String getPathSFTP() throws Exception;
}
