package com.pronaca.osoc.lecturaxml.view.service;

/**
 * 
 * @author bayteq
 *
 */
public interface IParametroGeneralService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public String getString(String codigo) throws Exception;

	/**
	 * 
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public Integer getInteger(String pk) throws Exception;

	/**
	 * 
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public Double getDouble(String pk) throws Exception;

}
