package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.entities.Dimension;

public interface DimensionRepository extends JpaRepository<Dimension, Long> {

	List<Dimension> findByDetalleCabecera(DetalleCabecera detalleCabecera);
	
	List<Dimension> findByNumeroOrden(String numeroOrden);
	
}
