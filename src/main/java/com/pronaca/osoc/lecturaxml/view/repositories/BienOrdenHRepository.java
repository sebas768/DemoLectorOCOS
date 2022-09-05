package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pronaca.osoc.lecturaxml.model.entities.BienOrdenH;

public interface BienOrdenHRepository extends JpaRepository<BienOrdenH, Long> {
	
	List<BienOrdenH> findByDetCodigo(Long detCodigo);
	
}
