package com.pronaca.osoc.lecturaxml.loaderxml;

public interface ILoaderXml {

	public abstract String getUsuarioSFTP() throws Exception;

	public abstract String getPasswordSFTP() throws Exception;

	public abstract int getPuertoSFTP() throws Exception;

	public abstract String getServidorSFTP() throws Exception;

	public abstract String getPathSFTP() throws Exception;

	public abstract String loadXml() throws Exception;

}
