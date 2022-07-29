package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.view.repositories.CabeceraOrdenRepository;
import com.pronaca.osoc.lecturaxml.view.service.ICebeceraOrdenService;

@Service
public class CabeceraOrdenService implements ICebeceraOrdenService {

	@Autowired
	private CabeceraOrdenRepository cabeceraOrdenRepository;

	@Override
	@Transactional
	public String updateStatus(String codigo) throws Exception {
		try {
			CabeceraOrden orden = new CabeceraOrden();
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findByNumeroOrden(codigo);
			if (ocos != null && !ocos.isEmpty()) {
				orden = ocos.get(0);
				orden.setEstadoRevision(EstadoEnum.PROCESADA);
				cabeceraOrdenRepository.save(orden);
				return "OK";
			}else {
				return "FAILED";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<CabeceraOrden> getOrderByCode(String codigo) throws Exception {
		try {
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findByNumeroOrden(codigo);
			if (ocos != null && !ocos.isEmpty()) {
				return ocos;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<CabeceraOrden> getAll() throws Exception {
		try {
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findAll();
			if (ocos != null && !ocos.isEmpty()) {
				return ocos;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	
	@Override
	public List<CabeceraOrden> searchByParameters(String fechaInicio, String fechaFin, String codigo, String codProveedor, String empresa, EstadoEnum estado) throws Exception {
		try {
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findByParametros(fechaInicio, fechaFin, codigo, codProveedor, empresa, estado);
			if (ocos != null && !ocos.isEmpty()) {
				return ocos;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}


}
