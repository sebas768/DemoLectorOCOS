package com.pronaca.osoc.lecturaxml.view.servicexml;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.xml.ModelOcos;

public interface ILecturaXmlService  extends IServiceXmlGeneric<ModelOcos, Long>{

	/**
	 * 
	 * @param t
	 * @throws Exception
	 */
	Boolean cargarData(ModelOcos t) throws Exception;
	
	/**
	 * 
	 * @param resp
	 * @throws Exception
	 */
	void cargarXml(RespuestaSFTP resp) throws Exception;
	
}
