package com.pronaca.osoc.lecturaxml.view.service;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.entities.Bien;

/**
 * 
 * @author bayteq
 *
 */
public interface IBienService {

	/**
	 * 
	 * @param numeroOrden
	 * @return 
	 * @throws Exception
	 */
	public List<Bien> findByNumeroOrden(String numeroOrden) throws Exception;
	
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
	public String save(Bien bien) throws Exception;
	
}
