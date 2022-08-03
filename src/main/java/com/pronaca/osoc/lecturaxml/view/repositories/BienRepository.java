package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;

public interface BienRepository extends JpaRepository<Bien, Long> {
	
	List<Bien> findByDetalleCabecera(DetalleCabecera detalleCabecera);
	
	List<Bien> findByNumeroOrden(String numeroOrden);

}
