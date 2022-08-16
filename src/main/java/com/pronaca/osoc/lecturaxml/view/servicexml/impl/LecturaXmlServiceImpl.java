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
import com.pronaca.osoc.lecturaxml.model.xml.ModelOcos;
import com.pronaca.osoc.lecturaxml.view.service.IArchivoXmlService;
import com.pronaca.osoc.lecturaxml.view.service.IBienService;
import com.pronaca.osoc.lecturaxml.view.service.ICabeceraOrdenService;
import com.pronaca.osoc.lecturaxml.view.service.IDetalleCabeceraService;
import com.pronaca.osoc.lecturaxml.view.service.IDimensionService;
import com.pronaca.osoc.lecturaxml.view.servicexml.ILecturaXmlService;

@Service
public class LecturaXmlServiceImpl extends ServiceXmlGeneric<ModelOcos, Long>
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

	@Override
	public void loadParameterCarga() {

	}

	@Override
	public Boolean validateOperationLoader(ModelOcos o, OperacionCRUDEnum operacion)
			throws ValidaEntityException, NotFundEntityException {
		return super.validateOperationLoader(o, operacion);
	}

	@Override
	@Transactional
	public Boolean cargarData(ModelOcos ocos) throws Exception {
		System.out.println(" | Persistencia Xml - Jpa");
		CabeceraOrden cabecera = ocos.getCabecera();
		cabeceraOrdenService.save(cabecera);
		List<DetalleCabecera> detalle = ocos.getDetallesCabecera();  
		if(detalle!=null && !detalle.isEmpty()) {
			detalle.stream().forEach(det -> { 
				try {
					det.setCabeceraOrden(cabeceraOrdenService.findByNumeroOrden(ocos.getCabecera().getNumeroOrden()));
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
		} return true;
	}
	
	@Override
	@Transactional
	public void cargarXml(RespuestaSFTP resp) throws Exception {
		archivoXmlService.save(resp, EstadoEnum.CARGADO); 
	}
	

}
