package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.ArchivoXml;

/**
 * 
 * @author bayteq
 *
 */
public interface ArchivoXmlRepository extends JpaRepository<ArchivoXml, Long> {

	List<ArchivoXml> findByNombreArchivo(String nameFile);
	
}

