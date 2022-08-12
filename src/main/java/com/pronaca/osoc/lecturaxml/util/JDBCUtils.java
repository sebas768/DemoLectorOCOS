package com.pronaca.osoc.lecturaxml.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class JDBCUtils {

	/**
	 * Log para la clase.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(JDBCUtils.class);

	public static final String DATASOURCE_NAME = "jdbc/sisocos";

	/**
	 * Constante que representa el valor de si en la invocacion a un stored procedure
	 */
	public static final String CONSTANTE_SI = "SI";

	/**
	 * Constante que representa el valor de no en la invocacion a un stored procedure
	 */
	public static final String CONSTANTE_NO = "NO";

	/** Conexion Generica **/
	protected Connection con;

	/**
	 * Metodo que permite retornar una conexion generica
	 * 
	 * @return Conexion generica.
	 * @throws Exception Excepcion que se arroja en caso de que exista algun error.
	 */
	public static Connection getConnection() throws Exception {
		try {
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource) initialContext.lookup(DATASOURCE_NAME);
			return dataSource.getConnection();
		} catch (NamingException ex) {
			LOG.error(ex.getMessage());
			throw new NamingException("Error en la busqueda JNDI de la conexion");
		}
	}

	/**
	 * M�todo que permite retornar una conexion generica
	 * 
	 * @return Conexion generica.
	 * @throws Exception Excepcion que se arroja en caso de que exista algun error.
	 */
	public static Connection getConnection(String dataSourceName) throws Exception {
		try {
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource) initialContext.lookup(dataSourceName);
			return dataSource.getConnection();
		} catch (NamingException ex) {
			LOG.error(ex.getMessage());
			throw new Exception("Error en la busqueda JNDI de la conexi�n");
		}
	}


	/**
	 * @param resultSet
	 */
	public static void safeClose(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOG.error("SQL error", e);
			}
		}
	}

	/**
	 * Permite cerrar un statement de modo seguro
	 * 
	 * @param statement Statement para cerrar
	 */
	public static void safeClose(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error("SQL error", e);
			}
		}
	}

	/**
	 * Permite cerrar una conexion de modo seguro.
	 * 
	 * @param connection Conexion para ser cerrada.
	 */
	public static void safeClose(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOG.error("SQL error", e);
			}
		}
	}

	/**
	 * Metodo que permite obtener el nextval de una secuencia dada.
	 * 
	 * @param nombreSecuencia El nombre de la secuencia.
	 * @return El nextval de la secuencia indicada.
	 */
	public static long secuenciaNextVal(String nombreSecuencia) throws Exception {

		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append("  SELECT ");
			ssql.append(nombreSecuencia);
			ssql.append(".NEXTVAL FROM DUAL  ");
			con = JDBCUtils.getConnection();
			stmt = con.prepareStatement(ssql.toString());
			rs = stmt.executeQuery();
			long resultado = 0L;
			if (rs.next()) {
				resultado = rs.getLong(1);
			} else {
				LOG.error("Error al obtener nextval de secuencia " + nombreSecuencia);
				throw new Exception("Error al obtener nextval de secuencia " + nombreSecuencia);
			}
			return resultado;
		} catch (Exception e) {
			LOG.error("Error al obtener nextval de secuencia " + nombreSecuencia, e);
			throw new Exception("Error al obtener nextval de secuencia " + nombreSecuencia);
		} finally {
			
			JDBCUtils.safeClose(stmt);
			JDBCUtils.safeClose(rs);
			JDBCUtils.safeClose(con);
		}
	}
	
	
	/**
	 * Metodo que permite obtener el nextval de una secuencia dada para .
	 * 
	 * @param nombreSecuencia El nombre de la secuencia.
	 * @return El nextval de la secuencia indicada.
	 */
	public static long secuenciaNextValBV(String nombreSecuencia) throws Exception {

		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append("  SELECT ");
			ssql.append(nombreSecuencia);
			ssql.append(".NEXTVAL FROM DUAL  ");
			con = JDBCUtils.getConnection();
			stmt = con.prepareStatement(ssql.toString());
			rs = stmt.executeQuery();
			long resultado = 0L;
			if (rs!=null && rs.next()) {
				resultado = rs.getLong(1);
			} else {
				//LOG.error("Error al obtener nextval de secuencia " + nombreSecuencia);
				//throw new Exception("Error al obtener nextval de secuencia " + nombreSecuencia);
				resultado = 0;
			}
			return resultado;
		} catch (Exception e) {
			LOG.error("Error al obtener nextval de secuencia " + nombreSecuencia, e);
			return 0;
		} finally {
			
			JDBCUtils.safeClose(stmt);
			JDBCUtils.safeClose(rs);
			JDBCUtils.safeClose(con);
		}
	}
	
	public static void createSecuencia(String nombreSecuencia, int minValue, int maxValue, int increment, int start){
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			StringBuilder ssql = new StringBuilder();
			ssql.append("  CREATE SEQUENCE ");
			ssql.append(nombreSecuencia);
			ssql.append(" MINVALUE ");
			ssql.append(minValue);
			ssql.append(" MAXVALUE ");
			ssql.append(maxValue);
			ssql.append(" INCREMENT BY ");
			ssql.append(increment);
			ssql.append(" START WITH ");
			ssql.append(start);
			ssql.append(" NOCACHE  NOORDER  NOCYCLE ");
			con = JDBCUtils.getConnection();
			stmt = con.prepareStatement(ssql.toString());
			rs = stmt.executeQuery();
			} catch (Exception e) {
			LOG.error("Error al crear el secuencial " + nombreSecuencia, e);
			//throw new Exception("Error al obtener nextval de secuencia " + nombreSecuencia);
		} finally {
			
			JDBCUtils.safeClose(stmt);
			JDBCUtils.safeClose(rs);
			JDBCUtils.safeClose(con);
		}
		
	}

}

