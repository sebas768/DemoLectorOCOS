package com.pronaca.osoc.lecturaxml.view.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronaca.osoc.lecturaxml.model.entities.Bien;

public interface BienRepository extends JpaRepository<Bien, Long> {

}
