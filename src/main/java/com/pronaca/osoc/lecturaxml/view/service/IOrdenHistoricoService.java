package com.pronaca.osoc.lecturaxml.view.service;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.dto.CabeceraOrdenDTO;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrdenH;

/**
 * 
 * @author bayteq
 *
 */
public interface IOrdenHistoricoService {

	/**
	 * 
	 * @param numeroOrden
	 * @return
	 * @throws Exception
	 */
	public List<CabeceraOrdenH> findByNumeroOrden(String numeroOrden) throws Exception;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public CabeceraOrdenDTO findByCodigo(Long codigo) throws Exception;
	
}
