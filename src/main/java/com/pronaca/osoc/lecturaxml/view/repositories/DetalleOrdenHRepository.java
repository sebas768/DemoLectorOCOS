package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabeceraH;

public interface DetalleOrdenHRepository extends JpaRepository<DetalleCabeceraH, Long> {
	
	List<DetalleCabeceraH> findByCabCodigo(Long cabCodigo);
		
}
