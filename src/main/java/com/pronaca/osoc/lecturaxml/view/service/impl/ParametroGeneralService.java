package com.pronaca.osoc.lecturaxml.view.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.model.entities.ParametroGeneral;
import com.pronaca.osoc.lecturaxml.view.repositories.ParametroGeneralRepository;
import com.pronaca.osoc.lecturaxml.view.service.IParametroGeneralService;

@Service
public class ParametroGeneralService implements IParametroGeneralService {

	@Autowired
	private ParametroGeneralRepository parametroGeneralRepository;

	@Override
	public String getString(String codigo) throws Exception {
		try {
			List<ParametroGeneral> parametro = parametroGeneralRepository.findByCodigo(codigo);
			if (parametro != null && !parametro.isEmpty())
				return parametro.get(0).getValorCadena();
			else
				return null;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bayteq.pronaca.b2b.dao.ParametroGeneralDao#getInteger(java.lang.String)
	 */
	@Override
	public Integer getInteger(String pk) throws Exception {
		List<ParametroGeneral> parametro = parametroGeneralRepository.findByCodigo(pk);
		if (parametro != null && !parametro.isEmpty())
			return Integer.valueOf(parametro.get(0).getValorEntero().toString());
		else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bayteq.pronaca.b2b.dao.ParametroGeneralDao#getDouble(java.lang.String)
	 */
	@Override
	public Double getDouble(String pk) throws Exception {
		List<ParametroGeneral> parametro = parametroGeneralRepository.findByCodigo(pk);
		if (parametro != null && !parametro.isEmpty())
			return Double.valueOf(parametro.get(0).getValorEntero().toString());
		else
			return null;
	}

}
