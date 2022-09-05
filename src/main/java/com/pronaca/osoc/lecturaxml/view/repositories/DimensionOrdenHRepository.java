package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.DimensionOrdenH;

public interface DimensionOrdenHRepository extends JpaRepository<DimensionOrdenH, Long> {

	List<DimensionOrdenH> findByDetCodigo(Long detCodigo);
		
}
