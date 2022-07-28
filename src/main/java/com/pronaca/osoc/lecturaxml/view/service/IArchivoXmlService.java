package com.pronaca.osoc.lecturaxml.view.service;

import java.util.List;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.ArchivoXml;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * 
 * @author bayteq
 *
 */
public interface IArchivoXmlService {

	/**
	 * 
	 * @param nameFile
	 * @return
	 * @throws Exception
	 */
	public List<ArchivoXml> getByNameFile(String nameFile) throws Exception;
	
	/**
	 * 
	 * @param nameFile
	 * @return
	 * @throws Exception 
	 */
	public Boolean fileExist(String nameFile) throws Exception;
	
	
	/**
	 * 
	 * @param nameFile
	 * @return
	 * @throws Exception
	 */
	public String delete(String nameFile) throws Exception;
	
	/**
	 * 
	 * @param resp
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public String save(RespuestaSFTP resp, EstadoEnum status) throws Exception;
	
}
