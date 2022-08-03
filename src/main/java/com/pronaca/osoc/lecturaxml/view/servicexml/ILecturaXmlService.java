package com.pronaca.osoc.lecturaxml.view.servicexml;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.xml.Transaccion;

public interface ILecturaXmlService  extends IServiceXmlGeneric<Transaccion, Long>{

	/**
	 * 
	 * @param t
	 * @throws Exception
	 */
	void cargar(Transaccion t) throws Exception;
	
	/**
	 * 
	 * @param resp
	 * @throws Exception
	 */
	void cargarXml(RespuestaSFTP resp) throws Exception;
	
}
