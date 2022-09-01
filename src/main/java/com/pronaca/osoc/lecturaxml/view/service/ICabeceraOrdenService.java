package com.pronaca.osoc.lecturaxml.view.service;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.dto.CabeceraOrdenDTO;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * 
 * @author bayteq
 *
 */
public interface ICabeceraOrdenService {

	/**
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws Exception
	 */
	public String updateStatus(String codigo, EstadoEnum estado) throws Exception;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public CabeceraOrdenDTO getByNumeroOrden(String numeroOrden) throws Exception;
	
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
	public List<CabeceraOrden> searchByParameters(String fechaInicio, String fechaFin, String codigo, String codProveedor, String rucProveedor, String codEmpresa, EstadoEnum estado) throws Exception;
		
	/**
	 * 
	 * @param numeroOrden
	 * @return
	 * @throws Exception
	 */
	public CabeceraOrden findByNumeroOrden(String numeroOrden) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String delete(Long id) throws Exception;
	
	/**
	 * 
	 * @param cabeceraOrden
	 * @return
	 * @throws Exception
	 */
	public CabeceraOrden save(CabeceraOrden cabeceraOrden) throws Exception;
}
