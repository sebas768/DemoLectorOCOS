package com.pronaca.osoc.lecturaxml.view.servicexml;

import java.io.Serializable;

import com.pronaca.osoc.lecturaxml.exceptions.DAOException;
import com.pronaca.osoc.lecturaxml.exceptions.NotFundEntityException;
import com.pronaca.osoc.lecturaxml.exceptions.ValidaEntityException;
import com.pronaca.osoc.lecturaxml.model.dto.ReturnInfoCarga;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.model.enums.OperacionCRUDEnum;

public interface IServiceXmlGeneric<T extends Serializable, Pk extends Serializable> extends Serializable {

	/**
	 * Ejecuta la carga de los parametros de coneccion
	 */
	public abstract void loadParameterCarga();

	public int actualizarEntidades(EstadoEnum estado, String columnEstatus, String[] conditions) throws Exception;

	public int actualizarEntidades(EstadoEnum estado, String columnEstatus) throws Exception;

	public T findById(final Pk id) throws DAOException, ValidaEntityException, Exception;

	public T update(final T o) throws DAOException, ValidaEntityException, NotFundEntityException, Exception;

	public T create(final T o) throws DAOException, ValidaEntityException, NotFundEntityException, Exception;

	ReturnInfoCarga executeProcedureArray(String sp, String dataSourceName, Object... obj) throws Exception;

	Boolean validateOperationLoader(T o, OperacionCRUDEnum operacion)
			throws ValidaEntityException, NotFundEntityException;
}
