package com.pronaca.osoc.lecturaxml.view.service;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.ArchivoXml;
import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.entities.Dimension;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * 
 * @author bayteq
 *
 */
public interface IDetalleCabeceraService {

	/** 
	 * 
	 * @param numeroOrden
	 * @return
	 * @throws Exception
	 */
	public List<DetalleCabecera> findByCabeceraOrden(CabeceraOrden cabeceraOrden) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String delete(Long id) throws Exception;
	
	/**
	 * 
	 * @param detalleCabecera
	 * @return
	 * @throws Exception
	 */
	public String save(DetalleCabecera detalleCabecera) throws Exception;
	
}
