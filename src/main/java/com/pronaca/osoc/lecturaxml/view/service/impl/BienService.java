package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.util.FechaUtil;
import com.pronaca.osoc.lecturaxml.view.repositories.BienRepository;
import com.pronaca.osoc.lecturaxml.view.service.IBienService;

@Service
public class BienService implements IBienService {

	@Autowired 
	private BienRepository bienRepository;

	@Override
	public List<Bien> findByNumeroOrden(String numeroOrden)  throws Exception {
		try {
			List<Bien> bienList = bienRepository.findByNumeroOrden(numeroOrden);
			if (bienList != null && !bienList.isEmpty()) {
				return bienList;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@Override
	public String delete(Long id)  throws Exception {
		try {
			Bien bien = bienRepository.findById(id).orElse(null);
			if (bien != null) {
				bienRepository.delete(bien);
				return "OK";
			}else {
				return "FAILED";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public String save(Bien bien) throws Exception{
		try {
			bien.setFechaEntrega(FechaUtil.ajustarFormatoOcos(bien.getFechaEntrega()));
			bien.setFecha1(FechaUtil.ajustarFormatoOcos(bien.getFecha1()));
			bien.setFecha2(FechaUtil.ajustarFormatoOcos(bien.getFecha2()));
			bien.setFecha3(FechaUtil.ajustarFormatoOcos(bien.getFecha3()));
			bien.setFecha4(FechaUtil.ajustarFormatoOcos(bien.getFecha4()));
			bien.setFecha5(FechaUtil.ajustarFormatoOcos(bien.getFecha5()));
			bien.setMetodoRecepcion(bien.getMetodoRecepcion().toLowerCase());
			bienRepository.save(bien);
			return "OK";
		} catch (Exception e) {
			throw e;
		}
	}

}
