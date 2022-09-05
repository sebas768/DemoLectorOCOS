package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.dto.BienDTO;
import com.pronaca.osoc.lecturaxml.model.dto.CabeceraOrdenDTO;
import com.pronaca.osoc.lecturaxml.model.dto.DetalleCabeceraDTO;
import com.pronaca.osoc.lecturaxml.model.dto.DimensionDTO;
import com.pronaca.osoc.lecturaxml.model.entities.BienOrdenH;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrdenH;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabeceraH;
import com.pronaca.osoc.lecturaxml.model.entities.DimensionOrdenH;
import com.pronaca.osoc.lecturaxml.view.repositories.BienOrdenHRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.CabeceraOrdenHRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.DetalleOrdenHRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.DimensionOrdenHRepository;
import com.pronaca.osoc.lecturaxml.view.service.IOrdenHistoricoService;

@Service
public class OrdenHistoricoService implements IOrdenHistoricoService {

	@Autowired
	private CabeceraOrdenHRepository cabeceraOrdenHRepository;
	@Autowired
	private BienOrdenHRepository bienOrdenHRepository;
	@Autowired
	private DimensionOrdenHRepository dimensionOrdenHRepository;
	@Autowired
	private DetalleOrdenHRepository detalleOrdenHRepository;
	
	@Override
	public CabeceraOrdenDTO findByCodigo(Long codigo) throws Exception {
		try {
			List<CabeceraOrdenH> ocosHList = cabeceraOrdenHRepository.findByCodigo(codigo);
			if (ocosHList != null && !ocosHList.isEmpty()) {
				CabeceraOrdenDTO ocosDto;
				List<DetalleCabeceraDTO> detalleDtoList = new ArrayList<>();
				ocosDto = new CabeceraOrdenDTO(ocosHList.get(0));
				
				List<DetalleCabeceraH> dc = detalleOrdenHRepository.findByCabCodigo(ocosDto.getCodigo());
				
					for (DetalleCabeceraH detalleCabecera : dc) {
						DetalleCabeceraDTO dcDto = new DetalleCabeceraDTO(detalleCabecera);
						List<BienDTO> bienDtoList = new ArrayList<>();
						List<DimensionDTO> dimensionDtoList = new ArrayList<>();
						
						List<BienOrdenH> b = bienOrdenHRepository.findByDetCodigo(detalleCabecera.getCodigo());
						if(b != null && !b.isEmpty()) {
							for (BienOrdenH bien : b) {
								BienDTO bDto = new BienDTO(bien);
								bienDtoList.add(bDto);
							}
						}
						List<DimensionOrdenH> d = dimensionOrdenHRepository.findByDetCodigo(detalleCabecera.getCodigo());
						if(d != null && !d.isEmpty()) {
							for (DimensionOrdenH dimension : d) {
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
	

	public List<CabeceraOrdenH> findByNumeroOrden(String numeroOrden) throws Exception{
		try {
			List<CabeceraOrdenH> ocos = cabeceraOrdenHRepository.findByNumeroOrden(numeroOrden);
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
