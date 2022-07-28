package com.pronaca.osoc.lecturaxml.view.service;

import java.util.Date;
import java.util.List;

import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;

/**
 * 
 * @author bayteq
 *
 */
public interface ICebeceraOrdenService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public String updateStatus(String codigo) throws Exception;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public List<CabeceraOrden> getOrderByCode(String codigo) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CabeceraOrden> getAll() throws Exception;
	
	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @param orden
	 * @param codProveedor
	 * @param empresa
	 * @param estado
	 * @return
	 * @throws Exception
	 */
	public List<CabeceraOrden> searchByParameters(String fechaInicio, String fechaFin, String codigo, String codProveedor, String empresa, String estado) throws Exception;
	
}
