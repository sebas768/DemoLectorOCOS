package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TAR_CARGA_ERROR database table.
 */
@Entity
@Table(name = "IDB_CARGA_ERROR")
public class CargaError implements Serializable {

	private static final long serialVersionUID = -7574807222865082629L;

	@Id
	@SequenceGenerator(name = "IDB_CARGA_ERROR_ERRCODIGO_GENERATOR", sequenceName = "SEQ_CARGA_ERROR",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDB_CARGA_ERROR_ERRCODIGO_GENERATOR")
	@Column(name = "ERR_CODIGO", unique = true, nullable = false, precision = 19)
	private Long codigo;

	@Column(name = "ERR_ERROR", length = 1000)
	private String error;

	@Temporal(TemporalType.DATE)
	@Column(name = "ERR_FECHA")
	private Date fecha;

	// bi-directional many-to-one association to CargaIdb
	@ManyToOne
	@JoinColumn(name = "ERR_CODIGO_CARGA", nullable = false)
	private CargaIdb cargaIdb;

	public CargaError() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CargaIdb getCargaIdb() {
		return cargaIdb;
	}

	public void setCargaIdb(CargaIdb cargaIdb) {
		this.cargaIdb = cargaIdb;
	}

}