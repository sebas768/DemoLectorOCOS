package com.pronaca.osoc.lecturaxml.view.servicexml.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.exceptions.NotFundEntityException;
import com.pronaca.osoc.lecturaxml.exceptions.ValidaEntityException;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.entities.Dimension;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.model.enums.OperacionCRUDEnum;
import com.pronaca.osoc.lecturaxml.model.xml.Transaccion;
import com.pronaca.osoc.lecturaxml.view.service.IArchivoXmlService;
import com.pronaca.osoc.lecturaxml.view.service.IBienService;
import com.pronaca.osoc.lecturaxml.view.service.ICabeceraOrdenService;
import com.pronaca.osoc.lecturaxml.view.service.IDetalleCabeceraService;
import com.pronaca.osoc.lecturaxml.view.service.IDimensionService;
import com.pronaca.osoc.lecturaxml.view.servicexml.ILecturaXmlService;

@Service
public class LecturaXmlServiceImpl extends ServiceXmlGeneric<Transaccion, Long>
		implements ILecturaXmlService {

	private static final long serialVersionUID = -8838186957518713588L;

	@Autowired
	private IArchivoXmlService archivoXmlService;
	
	@Autowired
	private ICabeceraOrdenService cabeceraOrdenService;
	
	@Autowired
	private IDetalleCabeceraService detalleCabeceraService;
	
	@Autowired
	private IBienService bienService;
	
	@Autowired
	private IDimensionService dimensionService;
	
	/*@Autowired
	private DimensionRepository dimensionRepository;
	
	@Autowired
	private BienRepository bienRepository;
	
	@Autowired
	private DetalleCabeceraRepository detalleCabeceraRepository;

	@Autowired
	private CabeceraOrdenRepository cabeceraOrdenRepository;
	
	@Autowired
	private ArchivoXmlRepository archivoXmlRepository;*/


	@Override
	public void loadParameterCarga() {

	}

	@Override
	public Boolean validateOperationLoader(Transaccion o, OperacionCRUDEnum operacion)
			throws ValidaEntityException, NotFundEntityException {
		return super.validateOperationLoader(o, operacion);
	}

	/*@Override
	@Transactional
	public void cargar(Transaccion ocos) throws Exception {
		CabeceraOrden cabecera = ocos.getCabecera();
		cabecera.setFechaProceso(FechaUtil.ajustarFormatoOcos(cabecera.getFechaProceso()));
		cabecera.setFechaOrden(FechaUtil.ajustarFormatoOcos(cabecera.getFechaOrden()));
		cabecera.setFechaPlanificadaRecepcion(FechaUtil.ajustarFormatoOcos(cabecera.getFechaPlanificadaRecepcion()));
		cabecera.setFechaRealRecepcion(FechaUtil.ajustarFormatoOcos(cabecera.getFechaRealRecepcion()));
		cabecera.setFecha1(FechaUtil.ajustarFormatoOcos(cabecera.getFecha1()));
		cabecera.setFecha2(FechaUtil.ajustarFormatoOcos(cabecera.getFecha2()));
		cabecera.setFecha3(FechaUtil.ajustarFormatoOcos(cabecera.getFecha3()));
		cabecera.setFecha4(FechaUtil.ajustarFormatoOcos(cabecera.getFecha4())); 
		cabecera.setFecha5(FechaUtil.ajustarFormatoOcos(cabecera.getFecha5()));
		cabecera.setFacturado(cabecera.getFacturado().toLowerCase());
		cabecera.setLiberado(cabecera.getLiberado().toLowerCase());
		cabecera.setEstadoRecupDatos(cabecera.getEstadoRecupDatos().toLowerCase());
		cabecera.setBienesFacturadosRecib(cabecera.getBienesFacturadosRecib().toLowerCase());
		cabeceraOrdenRepository.save(cabecera);
		List<DetalleCabecera> detalle = ocos.getDetallesCabecera();
		if(detalle!=null && !detalle.isEmpty()) {
			detalle.stream().forEach(det -> {
				det.setCabeceraOrden(cabecera);
				detalleCabeceraRepository.save(det);
				List<Bien> bienes = det.getBien();
				if(bienes!=null && !bienes.isEmpty()) {
					bienes.stream().forEach(b -> {
						b.setDetalleCabecera(det);
						bienRepository.save(b); 
					});  
				}
				List<Dimension> dimensiones = det.getDimension(); 
				if(dimensiones!=null && !dimensiones.isEmpty()) {
					dimensiones.stream().forEach(d -> {
						d.setDetalleCabecera(det);
						dimensionRepository.save(d); 
					});
				}
			});
		}

	}*/

	@Override
	@Transactional
	public void cargar(Transaccion ocos) throws Exception {
		System.out.println(" | Persistencia Xml -Jpa");
		CabeceraOrden cabecera = ocos.getCabecera();
		cabeceraOrdenService.getByNumeroOrden("380050794");
		cabeceraOrdenService.save(cabecera);
		List<DetalleCabecera> detalle = ocos.getDetallesCabecera();
		if(detalle!=null && !detalle.isEmpty()) {
			detalle.stream().forEach(det -> { 
				try {
					det.setCabeceraOrden(cabecera);
					detalleCabeceraService.save(det); 
				} catch (Exception e) {
					e.printStackTrace();
				}
				List<Bien> bienes = det.getBien();
				if(bienes!=null && !bienes.isEmpty()) {
					bienes.stream().forEach(b -> { 
						b.setDetalleCabecera(det);
						try { 
							bienService.save(b);
						} catch (Exception e) {
							e.printStackTrace();
						} 
					});  
				}
				List<Dimension> dimensiones = det.getDimension(); 
				if(dimensiones!=null && !dimensiones.isEmpty()) {
					dimensiones.stream().forEach(d -> {
						d.setDetalleCabecera(det);
						try {
							dimensionService.save(d);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				}
			});
		}
	}
	
	@Override
	@Transactional
	public void cargarXml(RespuestaSFTP resp) throws Exception {
		archivoXmlService.save(resp, EstadoEnum.CARGADO); 
	}
	

}
