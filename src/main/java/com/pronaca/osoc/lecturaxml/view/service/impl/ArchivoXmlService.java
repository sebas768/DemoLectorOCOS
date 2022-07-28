package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.ArchivoXml;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.view.repositories.ArchivoXmlRepository;
import com.pronaca.osoc.lecturaxml.view.service.IArchivoXmlService;

@Service
public class ArchivoXmlService implements IArchivoXmlService {

	@Autowired
	private ArchivoXmlRepository archivoXmlRepository;

	@Override
	public List<ArchivoXml> getByNameFile(String nameFile)  throws Exception {
		try {
			List<ArchivoXml> xmlList = archivoXmlRepository.findByNombreArchivo(nameFile);
			if (xmlList != null && !xmlList.isEmpty()) {
				return xmlList;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public Boolean fileExist(String nameFile)  throws Exception {
		try {
			List<ArchivoXml> xmlList = archivoXmlRepository.findByNombreArchivo(nameFile);
			if (xmlList != null && !xmlList.isEmpty()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String delete(String nameFile)  throws Exception {
		try {
			List<ArchivoXml> xmlList = archivoXmlRepository.findByNombreArchivo(nameFile);
			if (xmlList != null && !xmlList.isEmpty()) {
				ArchivoXml xml = xmlList.get(0);
				archivoXmlRepository.delete(xml);
				return "OK";
			}else {
				return "FAILED";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public String save(RespuestaSFTP resp, EstadoEnum status) throws Exception{
		try {
			ArchivoXml xml = new ArchivoXml(); 
			xml.setNombreArchivo(resp.getNombreArchivo());
			xml.setFechaArchivo(new Date (resp.getFechaArchivo()));
			xml.setPesoArchivo(resp.getTaminioArchivo().toString());
			xml.setEstadoCarga(status.toString());
			//FileXmlUtil obj = new FileXmlUtil();
			//aplicaPromocionService.cargarXml(resp);
			//obj.fileToBlob(resp);
			//xml.setContentBlob(obj.fileToBlob(resp));
			archivoXmlRepository.save(xml);
			return "OK";
		} catch (Exception e) {
			throw e;
		}
	}

}
