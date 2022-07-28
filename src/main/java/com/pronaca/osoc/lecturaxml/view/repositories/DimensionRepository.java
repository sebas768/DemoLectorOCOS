package com.pronaca.osoc.lecturaxml.view.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.Dimension;

public interface DimensionRepository extends JpaRepository<Dimension, Long> {

}
