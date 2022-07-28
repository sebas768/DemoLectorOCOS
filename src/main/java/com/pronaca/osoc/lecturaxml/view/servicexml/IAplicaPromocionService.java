package com.pronaca.osoc.lecturaxml.view.servicexml;

import java.util.Date;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.xml.Transaccion;

public interface IAplicaPromocionService  extends IServiceXmlGeneric<Transaccion, Long>{

	
	void cargar(Transaccion t) throws Exception;
	
	void cargarXml(RespuestaSFTP resp) throws Exception;
	
}
