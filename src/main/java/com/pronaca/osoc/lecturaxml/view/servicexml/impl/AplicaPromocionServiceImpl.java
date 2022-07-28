package com.pronaca.osoc.lecturaxml.view.servicexml.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.exceptions.NotFundEntityException;
import com.pronaca.osoc.lecturaxml.exceptions.ValidaEntityException;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.ArchivoXml;
import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.entities.Dimension;
import com.pronaca.osoc.lecturaxml.model.enums.OperacionCRUDEnum;
import com.pronaca.osoc.lecturaxml.model.xml.Transaccion;
import com.pronaca.osoc.lecturaxml.util.FechaUtil;
import com.pronaca.osoc.lecturaxml.view.repositories.ArchivoXmlRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.BienRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.CabeceraOrdenRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.DetalleCabeceraRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.DimensionRepository;
import com.pronaca.osoc.lecturaxml.view.servicexml.IAplicaPromocionService;

@Service
public class AplicaPromocionServiceImpl extends ServiceXmlGeneric<Transaccion, Long>
		implements IAplicaPromocionService {

	private static final long serialVersionUID = -8838186957518713588L;

	@Autowired
	private DimensionRepository dimensionRepository;
	
	@Autowired
	private BienRepository bienRepository;
	
	@Autowired
	private DetalleCabeceraRepository detalleCabeceraRepository;

	@Autowired
	private CabeceraOrdenRepository cabeceraOrdenRepository;
	
	@Autowired
	private ArchivoXmlRepository archivoXmlRepository;

	@Override
	public void loadParameterCarga() {

	}

	@Override
	public Boolean validateOperationLoader(Transaccion o, OperacionCRUDEnum operacion)
			throws ValidaEntityException, NotFundEntityException {
		return super.validateOperationLoader(o, operacion);
	}

	@Override
	@Transactional
	public void cargar(Transaccion ocos) throws Exception {
		CabeceraOrden cabecera = ocos.getCabecera();
		cabecera.setFechaProceso(FechaUtil.ajustarFormatoOcos(cabecera.getFechaProceso()));
		cabeceraOrdenRepository.save(cabecera);
		List<DetalleCabecera> detalle = ocos.getDetallesCabecera();
		if(detalle!=null && !detalle.isEmpty()) {
			detalle.parallelStream().forEach(det -> {
				det.setCabeceraOrden(cabecera);
				detalleCabeceraRepository.save(det);
				List<Bien> bien = det.getBien();
				List<Dimension> dimension = det.getDimension();
				if(bien!=null && !bien.isEmpty()) {
					
				}
				if(dimension!=null && !dimension.isEmpty()) {
					
				}
			});
		}

	}
	
	@Override
	@Transactional
	public void cargarXml(RespuestaSFTP resp) throws Exception {
		ArchivoXml xml = new ArchivoXml();
		xml.setNombreArchivo(resp.getNombreArchivo());
		xml.setFechaArchivo(new Date (resp.getFechaArchivo()));
		xml.setPesoArchivo(resp.getTaminioArchivo().toString());
		//FileXmlUtil obj = new FileXmlUtil();
		//aplicaPromocionService.cargarXml(resp);
		//obj.fileToBlob(resp);
		//xml.setContentBlob(obj.fileToBlob(resp));
		
		archivoXmlRepository.save(xml);
	}
	

}
