package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.ParametroGeneral;

public interface ParametroGeneralRepository extends JpaRepository<ParametroGeneral, Long> {

	List<ParametroGeneral> findByCodigo(String codigo);
}
