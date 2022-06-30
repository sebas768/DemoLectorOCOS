package com.pronaca.osoc.lecturaxml.view.servicexml.impl;

import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.exceptions.NotFundEntityException;
import com.pronaca.osoc.lecturaxml.exceptions.ValidaEntityException;
import com.pronaca.osoc.lecturaxml.model.entities.AplicaPromocion;
import com.pronaca.osoc.lecturaxml.model.enums.OperacionCRUDEnum;
import com.pronaca.osoc.lecturaxml.view.servicexml.IAplicaPromocionService;

@Service
public class AplicaPromocionServiceImpl extends ServiceXmlGeneric<AplicaPromocion, Long> implements IAplicaPromocionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8838186957518713588L;

	@Override
	public void loadParameterCarga() {

	}
	@Override
	public Boolean validateOperationLoader(AplicaPromocion o, OperacionCRUDEnum operacion)
			throws ValidaEntityException, NotFundEntityException {
		
		return super.validateOperationLoader(o, operacion);
	}
	

}
