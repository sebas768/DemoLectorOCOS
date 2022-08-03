package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;

public interface DetalleCabeceraRepository extends JpaRepository<DetalleCabecera, Long> {
	
	List<DetalleCabecera> findByCabeceraOrden(CabeceraOrden cabeceraOrden);
		
}
