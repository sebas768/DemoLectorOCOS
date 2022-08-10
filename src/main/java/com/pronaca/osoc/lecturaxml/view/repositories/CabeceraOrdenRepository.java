package com.pronaca.osoc.lecturaxml.view.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

public interface CabeceraOrdenRepository extends JpaRepository<CabeceraOrden, Long> {

	List<CabeceraOrden> findByNumeroOrden(String numeroOrden);
	
	@Query("select c from CabeceraOrden c where (to_date(c.fechaProceso,'dd/MM/yyyy') between to_date(:fechaInicio,'dd/MM/yyyy') and to_date(:fechaFin,'dd/MM/yyyy')) and ((UPPER(c.numeroOrden) like conc(concat('%',UPPER(:orden)),'%')) or :orden='') and ((UPPER(c.proveedor) like concat(concat('%',UPPER(:codProveedor)),'%')) or :codProveedor='') and ((UPPER(c.identPropietario) like concat(concat('%',UPPER(:rucProveedor)),'%')) or :rucProveedor='') and ((UPPER(c.compania) like concat(concat('%',UPPER(:codEmpresa)),'%')) or :codEmpresa='') and (c.estadoRevision=:estado or :estado='TODOS') ")
	List<CabeceraOrden> findByParametros(String fechaInicio, String fechaFin, String orden, String codProveedor, String rucProveedor, String codEmpresa, EstadoEnum estado);
	
	@Query("select c from CabeceraOrden c ")
	List<CabeceraOrden> findAll();
}
