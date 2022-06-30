package com.pronaca.osoc.lecturaxml.loaderxml.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.loaderxml.FactoryLoaderXml;
import com.pronaca.osoc.lecturaxml.loaderxml.IAplicaPromocionLoaderView;

@Service
public class FactoryLoaderImpl implements FactoryLoaderXml {

	/**
	 * 
	 */
	private static final long serialVersionUID = -397282918168389915L;
	@Autowired
	protected IAplicaPromocionLoaderView iAplicaPromocionLoaderView;

	public FactoryLoaderImpl() {
		super();
	}

	@Override
	public IAplicaPromocionLoaderView getIAplicaPromocionLoaderView() {
		return iAplicaPromocionLoaderView;
	}

}
