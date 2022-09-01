package com.pronaca.osoc.lecturaxml.view.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pronaca.osoc.lecturaxml.exceptions.DAOException;
import com.pronaca.osoc.lecturaxml.model.entities.ParametroGeneral;
import com.pronaca.osoc.lecturaxml.view.dao.ParametroGeneralDAO;
import com.pronaca.osoc.lecturaxml.view.repositories.ParametroGeneralRepository;

@Repository
public class ParametroGeneralDAOImpl implements ParametroGeneralDAO {

	@Autowired
	private ParametroGeneralRepository parametroGeneralRepository;

	@Override
	public String getString(String codigo) throws DAOException {

		ParametroGeneral parametro = parametroGeneralRepository.findById(codigo).orElse(null);
		if (parametro != null)
			return parametro.getValorCadena();
		else
			throw new DAOException("no se encuentra el parametro " + codigo);

	}

}
