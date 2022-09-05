package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrdenH;

public interface CabeceraOrdenHRepository extends JpaRepository<CabeceraOrdenH, Long> {

	List<CabeceraOrdenH> findByNumeroOrden(String numeroOrden);
	
	List<CabeceraOrdenH> findByCodigo(Long codigo);
			
}
