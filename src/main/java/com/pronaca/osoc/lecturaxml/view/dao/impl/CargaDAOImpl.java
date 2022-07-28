package com.pronaca.osoc.lecturaxml.view.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//import com.pronaca.osoc.lecturaxml.model.entities.CargaError;
//import com.pronaca.osoc.lecturaxml.model.entities.CargaIdb;
import com.pronaca.osoc.lecturaxml.view.dao.ICargaDAO;

@Service
public class CargaDAOImpl implements ICargaDAO {

	@Autowired
	private JdbcTemplate template;

	/*@Override
	public Integer crearCarga(CargaIdb c) throws Exception {
		return 0;
	}

	@Override
	public Integer crearError(CargaError e) throws Exception {
		return 0;
	}

	@Override
	public CargaIdb buscar(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarCarga(CargaIdb c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
