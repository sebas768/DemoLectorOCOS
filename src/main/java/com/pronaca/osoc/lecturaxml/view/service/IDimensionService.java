package com.pronaca.osoc.lecturaxml.view.service;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.entities.Dimension;

/**
 * 
 * @author bayteq
 *
 */
public interface IDimensionService {

	/**
	 * 
	 * @param numeroOrden
	 * @return 
	 * @throws Exception
	 */
	public List<Dimension> findByNumeroOrden(String numeroOrden) throws Exception;
	
	/**
	 *  
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String delete(Long id) throws Exception;
	
	/**
	 * 
	 * @param bien
	 * @return
	 * @throws Exception
	 */
	public String save(Dimension dimension) throws Exception;
	
}
