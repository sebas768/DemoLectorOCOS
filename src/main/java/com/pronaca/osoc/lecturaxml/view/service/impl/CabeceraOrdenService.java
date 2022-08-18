package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.dto.BienDTO;
import com.pronaca.osoc.lecturaxml.model.dto.CabeceraOrdenDTO;
import com.pronaca.osoc.lecturaxml.model.dto.DetalleCabeceraDTO;
import com.pronaca.osoc.lecturaxml.model.dto.DimensionDTO;
import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.entities.Dimension;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.model.enums.TipoEnum;
import com.pronaca.osoc.lecturaxml.util.FechaUtil;
import com.pronaca.osoc.lecturaxml.view.repositories.BienRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.CabeceraOrdenRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.DetalleCabeceraRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.DimensionRepository;
import com.pronaca.osoc.lecturaxml.view.service.ICabeceraOrdenService;

@Service
public class CabeceraOrdenService implements ICabeceraOrdenService {

	@Autowired
	private CabeceraOrdenRepository cabeceraOrdenRepository;
	@Autowired
	private BienRepository bienRepository;
	@Autowired
	private DimensionRepository dimensionRepository;
	@Autowired
	private DetalleCabeceraRepository detalleCabeceraRepository;

	@Override
	@Transactional
	public String updateStatus(String codigo, EstadoEnum estado) throws Exception {
		try {
			CabeceraOrden orden = new CabeceraOrden();
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findByNumeroOrden(codigo);
			if (ocos != null && !ocos.isEmpty()) {
				orden = ocos.get(0);
				orden.setEstadoRevision(estado);
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
	public CabeceraOrdenDTO getByNumeroOrden(String numeroOrden) throws Exception {
		try {
			List<CabeceraOrden> ocosList = cabeceraOrdenRepository.findByNumeroOrden(numeroOrden);
			if (ocosList != null && !ocosList.isEmpty()) {
				CabeceraOrdenDTO ocosDto;
				List<DetalleCabeceraDTO> detalleDtoList = new ArrayList<>();
				ocosDto = new CabeceraOrdenDTO(ocosList.get(0));
				List<DetalleCabecera> dc = detalleCabeceraRepository.findByCabeceraOrden(ocosList.get(0));
				
					for (DetalleCabecera detalleCabecera : dc) {
						DetalleCabeceraDTO dcDto = new DetalleCabeceraDTO(detalleCabecera);
						List<BienDTO> bienDtoList = new ArrayList<>();
						List<DimensionDTO> dimensionDtoList = new ArrayList<>();
						
						List<Bien> b = bienRepository.findByDetalleCabecera(detalleCabecera);
						if(b != null && !b.isEmpty()) {
							for (Bien bien : b) {
								BienDTO bDto = new BienDTO(bien);
								bienDtoList.add(bDto);
							}
						}
						List<Dimension> d = dimensionRepository.findByDetalleCabecera(detalleCabecera);
						if(d != null && !d.isEmpty()) {
							for (Dimension dimension : d) {
								DimensionDTO dDto = new DimensionDTO(dimension);
								dimensionDtoList.add(dDto);
							}
						}
						dcDto.setBienes(bienDtoList);
						dcDto.setDimensiones(dimensionDtoList);
						detalleDtoList.add(dcDto);
					}
					
				ocosDto.setDetalleCabecera(detalleDtoList);
 				return ocosDto ;
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

	public CabeceraOrden findByNumeroOrden(String numeroOrden) throws Exception{
		try {
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findByNumeroOrden(numeroOrden);
			if (ocos != null && !ocos.isEmpty()) {
				return ocos.get(0);
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<CabeceraOrden> searchByParameters(String fechaInicio, String fechaFin, String codigo, String codProveedor, String rucProveedor, String codEmpresa, EstadoEnum estado) throws Exception {
		try {
			List<CabeceraOrden> ocos = cabeceraOrdenRepository.findByParametros(fechaInicio, fechaFin, codigo, codProveedor, rucProveedor, codEmpresa, estado);
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
	public String delete(Long id)  throws Exception {
		try {
			CabeceraOrden ocos = cabeceraOrdenRepository.findById(id).orElse(null);
			if (ocos != null) {
				List<DetalleCabecera> dcList = detalleCabeceraRepository.findByCabeceraOrden(ocos);
				if(dcList != null && !dcList.isEmpty()) {
					for (DetalleCabecera detalleCabecera : dcList) {
						List<Bien> bList = bienRepository.findByDetalleCabecera(detalleCabecera);
						if(bList != null && !bList.isEmpty()) {
							for (Bien bien : bList) {
								bienRepository.delete(bien);
							}
						}
						List<Dimension> dList = dimensionRepository.findByDetalleCabecera(detalleCabecera);
						if(dList != null && !dList.isEmpty()) {
							for (Dimension dimension : dList) {
								dimensionRepository.delete(dimension);
							}
						}
						detalleCabeceraRepository.delete(detalleCabecera);
					}
				}
				cabeceraOrdenRepository.delete(ocos);
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
	public String save(CabeceraOrden cabecera) throws Exception{
		try {
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
			cabecera.setEstadoRevision(EstadoEnum.PENDIENTE_REVISION);
			cabecera.setTipoOrden(isNumeric(cabecera.getNumeroOrden())?TipoEnum.OC:TipoEnum.OS);
			cabeceraOrdenRepository.save(cabecera);
			return "OK";
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Boolean isNumeric(String name) throws Exception {
		boolean resp = true;
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isDigit(name.charAt(i))) {
            	resp = false;
            }
        }
        return resp;
	}

}
