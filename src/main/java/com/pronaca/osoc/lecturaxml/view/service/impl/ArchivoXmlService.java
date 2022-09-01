package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.sql.Blob;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.ArchivoXml;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.util.FileXmlUtil;
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
			FileXmlUtil ob = new FileXmlUtil();
			ArchivoXml xml = new ArchivoXml(); 
			xml.setNombreArchivo(resp.getNombreArchivo());
			xml.setFechaArchivo(new Date (resp.getFechaArchivo()));
			xml.setFechaCarga(new GregorianCalendar());
			xml.setPesoArchivo(ob.convertSize(resp.getTaminioArchivo()));
			xml.setEstadoCarga(status.toString()); 
			Blob fileBlob = ob.fileToBlob(resp);
			if (fileBlob != null) {
				xml.setContentBlob(fileBlob); 
			}
			archivoXmlRepository.save(xml);
			System.out.println(" | Save file xml as BLOB"); 
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
