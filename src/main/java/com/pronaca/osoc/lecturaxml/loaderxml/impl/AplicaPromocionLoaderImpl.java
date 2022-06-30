package com.pronaca.osoc.lecturaxml.loaderxml.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.loaderxml.IAplicaPromocionLoaderView;
import com.pronaca.osoc.lecturaxml.model.entities.AplicaPromocion;
import com.pronaca.osoc.lecturaxml.view.servicexml.IAplicaPromocionService;
import com.pronaca.osoc.lecturaxml.view.servicexml.IServiceXmlGeneric;

@Service
public class AplicaPromocionLoaderImpl extends LoaderGenericImpl<AplicaPromocion, Long>
		implements IAplicaPromocionLoaderView {

	@Autowired
	IAplicaPromocionService iAplicaPromocionService;

	public AplicaPromocionLoaderImpl() {
		super();
	}

	@Override
	public IServiceXmlGeneric<AplicaPromocion, Long> getDAO() {
		return iAplicaPromocionService;
	}

}
