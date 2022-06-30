package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.pronaca.osoc.lecturaxml.anotacions.LoaderAnotation;
import com.pronaca.osoc.lecturaxml.model.generic.CargaIDBGeneric;

@Entity
@Table(name = "B2B_APLICA_PROMOCION")
@LoaderAnotation(fileXML = "AplicaPromocion.xml", isUpdateEstatus = false)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "secuenciaSolicitud", "codigoProducto", "codigoClienteBaanIV", "codigoCompania",
		"estadoPromocion", "tipoCabeceraRegistro" })
public class AplicaPromocion extends CargaIDBGeneric<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3525789896368323643L;

	@XmlTransient
	@Id
	@SequenceGenerator(name = "B2B_APLICA_PROMOCION_APCODIGO_GENERATOR", sequenceName = "SEQ_APLICA_PROMOCION",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "B2B_APLICA_PROMOCION_APCODIGO_GENERATOR")
	@Column(name = "AP_CODIGO_APLICAPRM")
	private Long codigo;

	@XmlElement(name = "SecuenciaSolicitud")
	@Column(name = "AP_PRMSECUENCIASOLICITUD")
	private Long secuenciaSolicitud;

	@XmlElement(name = "CodigoProducto")
	@Column(name = "AP_PRMCODIGOPRODUCTO")
	private String codigoProducto;

	@XmlElement(name = "CodigoClienteBaanIV")
	@Column(name = "AP_PRMCODIGOCLIENTEBAANIV")
	private String codigoClienteBaanIV;

	@XmlElement(name = "CodigoCompania")
	@Column(name = "AP_PRMCODIGOCOMPANIA")
	private String codigoCompania;

	@XmlElement(name = "EstadoPromocion")
	@Column(name = "AP_PRMESTADO")
	private String estadoPromocion;

	@XmlElement(name = "TipoCabeceraRegistro")
	@Column(name = "AP_PRMTIPOCABECERAREGISTRO")
	private String tipoCabeceraRegistro;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getSecuenciaSolicitud() {
		return secuenciaSolicitud;
	}

	public void setSecuenciaSolicitud(Long secuenciaSolicitud) {
		this.secuenciaSolicitud = secuenciaSolicitud;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getCodigoClienteBaanIV() {
		return codigoClienteBaanIV;
	}

	public void setCodigoClienteBaanIV(String codigoClienteBaanIV) {
		this.codigoClienteBaanIV = codigoClienteBaanIV;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getTipoCabeceraRegistro() {
		return tipoCabeceraRegistro;
	}

	public void setTipoCabeceraRegistro(String tipoCabeceraRegistro) {
		this.tipoCabeceraRegistro = tipoCabeceraRegistro;
	}

	@Override
	public Long getPk() {
		return Long.valueOf(-1);
	}

	@Override
	public Boolean isValidEntiti() {
		return true;
	}

	public String getEstadoPromocion() {
		return estadoPromocion;
	}

	public void setEstadoPromocion(String estadoPromocion) {
		this.estadoPromocion = estadoPromocion;
	}

	@Override
	public Object[] getData() {
		return null;
	}

}
