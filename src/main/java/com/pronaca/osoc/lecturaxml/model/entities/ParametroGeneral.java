package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the B2B_PARAMETRO_GENERAL database table.
 */
@Entity
@Table(name = "B2B_PARAMETRO_GENERAL")
@NamedQueries({	@NamedQuery(name = "ParametroGeneral.findParametros", query = "Select object(t) from ParametroGeneral as t where t.modificable ='SI' " )})
public class ParametroGeneral implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;

	@Id
	@Column(name = "PGE_ID")
	private String codigo;

	@Column(name = "PGE_DESCRIPCION")
	private String descripcion;

	@Column(name = "PGE_ESTADO")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "PGE_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "PGE_MODIFICABLE")
	private String modificable;

	@Column(name = "PGE_TIPO_DATO")
	private String tipoDato;

	@Column(name = "PGE_VALOR_CADENA")
	private String valorCadena;

	@Column(name = "PGE_VALOR_DECIMAL")
	private BigDecimal valorDecimal;

	@Column(name = "PGE_VALOR_ENTERO")
	private Long valorEntero;

	public ParametroGeneral() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getModificable() {
		return modificable;
	}

	public void setModificable(String modificable) {
		this.modificable = modificable;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getValorCadena() {
		return valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public BigDecimal getValorDecimal() {
		return valorDecimal;
	}

	public void setValorDecimal(BigDecimal valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	public Long getValorEntero() {
		return valorEntero;
	}

	public void setValorEntero(Long valorEntero) {
		this.valorEntero = valorEntero;
	}

}