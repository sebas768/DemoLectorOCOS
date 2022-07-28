package com.pronaca.osoc.lecturaxml.loaderxml;

import java.io.Serializable;
import java.util.List;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;

public interface ILeerXmlStream<T, Pk extends Serializable> {
	
	/**
	 * 
	 * @param respuestaFTP
	 * @param entidad
	 * @return
	 * @throws Exception
	 */
	List<T> obtenerDatos(RespuestaSFTP respuestaFTP, Class<T> entidad) throws Exception;

}
