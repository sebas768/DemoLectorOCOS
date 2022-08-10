package com.pronaca.osoc.lecturaxml.loaderxml;

public interface ILoaderXml {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String getUsuarioSFTP() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String getPasswordSFTP() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract int getPuertoSFTP() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String getServidorSFTP() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String getPathSFTP() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String loadXml() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String deleteXml() throws Exception;

}
