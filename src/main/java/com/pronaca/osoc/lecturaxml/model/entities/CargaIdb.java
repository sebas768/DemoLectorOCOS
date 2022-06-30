package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TAR_CARGA_IDB database table.
 */
@Entity
@Table(name = "IDB_CARGA_IDB")
public class CargaIdb implements Serializable {

	private static final long serialVersionUID = 4466101622033467380L;

	@Id
	@SequenceGenerator(name = "IDB_CARGA_IDB_CARCODIGO_GENERATOR", sequenceName = "SEQ_CARGA_IDB",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDB_CARGA_IDB_CARCODIGO_GENERATOR")
	@Column(name = "CAR_CODIGO", unique = true, nullable = false, precision = 19)
	private Long codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "CAR_FECHA_ARCHIVO")
	private Date fechaArchivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CAR_FECHA_FIN")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CAR_FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "CAR_NOMBRE_TABLA", length = 20)
	private String nombreTabla;

	@Column(name = "CAR_RESULTADO", length = 150)
	private String resultado;

	@Column(name = "CAR_SISTEMA", length = 20)
	private String sistema;

	@Column(name = "CAR_TAMANO_ARCHIVO", length = 30)
	private String tamanoArchivo;

	@Column(name = "CAR_ESTADO", length = 15)
	private String estado;

	// bi-directional many-to-one association to CargaError
	@OneToMany(mappedBy = "cargaIdb")
	private List<CargaError> cargaErrors;

	public CargaIdb() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaArchivo() {
		return fechaArchivo;
	}

	public void setFechaArchivo(Date fechaArchivo) {
		this.fechaArchivo = fechaArchivo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getTamanoArchivo() {
		return tamanoArchivo;
	}

	public void setTamanoArchivo(String tamanoArchivo) {
		this.tamanoArchivo = tamanoArchivo;
	}

	public List<CargaError> getCargaErrors() {
		return cargaErrors;
	}

	public void setCargaErrors(List<CargaError> cargaErrors) {
		this.cargaErrors = cargaErrors;
	}

}
