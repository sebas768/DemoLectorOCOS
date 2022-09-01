package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.entities.Dimension;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.util.FechaUtil;
import com.pronaca.osoc.lecturaxml.view.repositories.DimensionRepository;
import com.pronaca.osoc.lecturaxml.view.service.IDimensionService;

@Service
public class DimensionService implements IDimensionService {

	@Autowired 
	private DimensionRepository dimensionRepository;

	@Override
	public List<Dimension> findByNumeroOrden(String numeroOrden)  throws Exception {
		try {
			List<Dimension> dimensionList = dimensionRepository.findByNumeroOrden(numeroOrden);
			if (dimensionList != null && !dimensionList.isEmpty()) {
				return dimensionList;
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
			Dimension dimension = dimensionRepository.findById(id).orElse(null);
			if (dimension != null) {
				dimensionRepository.delete(dimension);
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
	public String save(Dimension dimension) throws Exception{
		try {
			dimension.setFecha1(FechaUtil.ajustarFormatoOcos(dimension.getFecha1()));
			dimension.setFecha2(FechaUtil.ajustarFormatoOcos(dimension.getFecha2()));
			dimension.setFecha3(FechaUtil.ajustarFormatoOcos(dimension.getFecha3()));
			dimension.setFecha4(FechaUtil.ajustarFormatoOcos(dimension.getFecha4()));
			dimension.setFecha5(FechaUtil.ajustarFormatoOcos(dimension.getFecha5()));
			dimension.setEstadoRevision(EstadoEnum.PENDIENTE_REVISION);
			dimensionRepository.save(dimension);
			return "OK";
		} catch (Exception e) {
			throw e;
		}
	}

}
