/**
 * 
 */
package com.pronaca.osoc.lecturaxml.view.servicexml.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Types;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pronaca.osoc.lecturaxml.exceptions.DAOException;
import com.pronaca.osoc.lecturaxml.exceptions.NotFundEntityException;
import com.pronaca.osoc.lecturaxml.exceptions.ValidaEntityException;
import com.pronaca.osoc.lecturaxml.model.dto.ReturnInfoCarga;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.model.enums.OperacionCRUDEnum;
import com.pronaca.osoc.lecturaxml.sftp.impl.ClienteSFTP;
import com.pronaca.osoc.lecturaxml.util.JDBCExceptionMapping;
import com.pronaca.osoc.lecturaxml.util.JDBCUtils;
import com.pronaca.osoc.lecturaxml.view.servicexml.IServiceXmlGeneric;

/**
 * @author Bayteq
 */
@SuppressWarnings("all")
public abstract class ServiceXmlGeneric<T extends Serializable, Pk extends Serializable>
		implements IServiceXmlGeneric<T, Pk> {
	private Logger logger = LoggerFactory.getLogger(ServiceXmlGeneric.class);
	protected Class<T> entityClass;
	protected Class<Pk> pkClass;
	protected T instance;
	protected Pk pk;

	@PersistenceContext
	private EntityManager em;

	public ServiceXmlGeneric() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		Type[] genericInterfaces = genericSuperclass.getActualTypeArguments();
		entityClass = (Class<T>) genericInterfaces[0];
		pkClass = (Class<Pk>) genericInterfaces[1];
	}

	@Override
	public int actualizarEntidades(EstadoEnum estado, String columnEstatus) throws Exception {
		try {
			Query q = em.createQuery(
					" UPDATE " + this.entityClass.getSimpleName() + " a SET a." + columnEstatus + " = :estado ");
			q.setParameter("estado", estado.getDescripcion());
			return q.executeUpdate();
		} catch (final Exception e) {
			throw e;
		}
	}

	/**
	 * @param o
	 * @throws NotFundEntityException
	 * @throws Exception
	 */
	@Transactional
	@Override
	public synchronized T create(final T o)
			throws DAOException, ValidaEntityException, Exception, NotFundEntityException {
		try {
			if (validateOperationLoader(o, OperacionCRUDEnum.I)) {
				em.persist(o);
				em.flush();
			}
			return o;
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public synchronized T findById(final Pk id) throws DAOException, ValidaEntityException, Exception {
		T entidad = null;
		if (id != null)
			entidad = em.find(entityClass, id);
		if (entidad == null) {
			final StringBuffer msg = new StringBuffer();
			msg.append("Entidad ");
			msg.append(entityClass.getSimpleName());
			msg.append('[');
			msg.append(id.toString());
			msg.append("] no encontrada.");
			throw new DAOException(msg.toString());
		}
		return entidad;
	}

	/**
	 * @param o
	 * @throws NotFundEntityException
	 * @throws Exception
	 */
	@Override
	public synchronized T update(final T o)
			throws DAOException, ValidaEntityException, Exception, NotFundEntityException {
		try {
			T other = null;
			validateOperationLoader(o, OperacionCRUDEnum.U);
			other = em.merge(o);
			em.flush();
			return other;

		} catch (final Exception e) {
			throw e;
		}
	}

	@Override
	public void loadParameterCarga() {

	}

	@Override
	public ReturnInfoCarga executeProcedureArray(String sp, String dataSourceName, Object... obj) throws Exception {
		CallableStatement stmt = null;
		java.sql.Connection con = null;
		String mensajeError = "";
		int retstatus = -1;

		try {
			con = JDBCUtils.getConnection(dataSourceName);
			stmt = con.prepareCall(sp);
			stmt = getBuilParameter(stmt, obj);
			stmt.execute();
			retstatus = stmt.getInt(1);

			switch (retstatus) {
			case JDBCExceptionMapping.ESTADO_UNKNOW_FAIL:
				mensajeError = stmt.getString(3);
				throw new ValidaEntityException(mensajeError);
			case JDBCExceptionMapping.ESTADO_FAIL:
				int exception = stmt.getInt(2);
				mensajeError = stmt.getString(3);
				throw new ValidaEntityException(mensajeError + " [N�mero excepci�n] " + exception);
			}
			return new ReturnInfoCarga(stmt.getString(4), stmt.getString(3), stmt.getInt(2), stmt.getInt(1));
		} catch (Exception ex) {
			throw new ValidaEntityException(ex.getMessage());
		} finally {
			JDBCUtils.safeClose(stmt);
			JDBCUtils.safeClose(con);
		}
	}

	public CallableStatement getBuilParameter(CallableStatement query, Object... parm) throws Exception {
		query.registerOutParameter(1, Types.NUMERIC);// RETORNO
		query.registerOutParameter(2, Types.NUMERIC);// PNO_EXCEPCION
		query.registerOutParameter(3, Types.VARCHAR);// PSO_MENSAJE
		query.registerOutParameter(4, Types.VARCHAR);// PSO_RESULTADO
		for (int i = 0; i < parm.length; i++) {
			if (parm[i] instanceof String)
				query.setString(i + 5, String.valueOf(parm[i]));
			else if (parm[i] == null)
				query.setNull(i + 5, Types.NULL);
		}

		return query;
	}

	public int actualizarEntidades(EstadoEnum estado, String columnEstatus, String[] conditions) throws Exception {
		try {
			StringBuffer querry = new StringBuffer();
			querry.append(" UPDATE " + this.entityClass.getSimpleName() + " a SET a." + columnEstatus + " = :estado ");

			if (conditions.length != 0) {
				querry.append("WHERE 0=0 ");
				for (String condition : conditions) {
					querry.append(" AND ");
					querry.append("a." + condition);
				}
			}

			Query q = em.createQuery(querry.toString());
			q.setParameter("estado", estado.getDescripcion());
			return q.executeUpdate();
		} catch (final Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean validateOperationLoader(T o, OperacionCRUDEnum operacion)
			throws ValidaEntityException, NotFundEntityException {
		return true;
	}

}
