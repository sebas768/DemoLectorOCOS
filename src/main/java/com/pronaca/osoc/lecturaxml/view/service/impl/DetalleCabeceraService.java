package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.util.FechaUtil;
import com.pronaca.osoc.lecturaxml.view.repositories.DetalleCabeceraRepository;
import com.pronaca.osoc.lecturaxml.view.service.IDetalleCabeceraService;

@Service
public class DetalleCabeceraService implements IDetalleCabeceraService {

	@Autowired 
	private DetalleCabeceraRepository detalleCabeceraRepository;

	@Override
	public List<DetalleCabecera> findByCabeceraOrden(CabeceraOrden cabeceraOrden)  throws Exception {
		try {
			List<DetalleCabecera> detalleList = detalleCabeceraRepository.findByCabeceraOrden(cabeceraOrden);
			if (detalleList != null && !detalleList.isEmpty()) {
				return detalleList;
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
			DetalleCabecera detalleCabecera = detalleCabeceraRepository.findById(id).orElse(null);
			if (detalleCabecera != null) {
				detalleCabeceraRepository.delete(detalleCabecera);
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
	public String save(DetalleCabecera detalleCabecera) throws Exception{
		try {
			detalleCabecera.setFecha1(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFecha1()));
			detalleCabecera.setFecha2(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFecha2()));
			detalleCabecera.setFecha3(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFecha3()));
			detalleCabecera.setFecha4(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFecha4()));
			detalleCabecera.setFecha5(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFecha5()));
			detalleCabecera.setFechaPlanificadaRecepcion(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFechaPlanificadaRecepcion()));
			detalleCabecera.setFechaRealRecepcion(FechaUtil.ajustarFormatoOcos(detalleCabecera.getFechaRealRecepcion()));
			detalleCabecera.setFacturado(detalleCabecera.getFacturado().toLowerCase());
			detalleCabecera.setLiberado(detalleCabecera.getLiberado().toLowerCase());
			detalleCabecera.setEntregaMercaderiaReq(detalleCabecera.getEntregaMercaderiaReq().toLowerCase());
			detalleCabecera.setBienesFacturadosRecib(detalleCabecera.getBienesFacturadosRecib().toLowerCase());
			detalleCabecera.setEstadoRevision(EstadoEnum.PENDIENTE_REVISION);
			detalleCabeceraRepository.save(detalleCabecera);
			return "OK";
		} catch (Exception e) {
			throw e;
		}
	}

}
