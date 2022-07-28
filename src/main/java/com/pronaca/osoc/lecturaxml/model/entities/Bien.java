package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * The persistent class for the LEC_BIEN database table.
 */
@Entity
@Table(name = "LEC_BIEN")
@NamedQueries({	@NamedQuery(name = "Bien.findBien", query = "Select object(b) from Bien as b order by 1 " )})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "numeroOrden", "id", "numeroRecepcion", "lineaRecepcion", "posicion", "cantidadRecibida",
					   "neto", "precioNeto", "fechaEntrega", "idUsuario", "codUsuario", "nombreUsuario",
					   "texto1", "texto2", "texto3", "texto4", "texto5", "numerico1", "numerico2", "numerico3",
					   "numerico4", "numerico5", "fecha1", "fecha2", "fecha3", "fecha4", "fecha5", "metodoRecepcion"})
public class Bien implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;
	
	@XmlTransient
	@Id
	@SequenceGenerator(name = "LEC_BIEN_BIE_CODIGO_GENERATOR", sequenceName = "SEQ_LEC_BIEN",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEC_BIEN_BIE_CODIGO_GENERATOR")
	@Column(name = "BIE_CODIGO")
	private Long codigo;
	
	// bidirectional many-to-one association
	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "BIE_DET_CODIGO", nullable = false)
	private DetalleCabecera detalleCabecera;
	
	@XmlElement(name = "NumeroOrden")
	@Column(name = "BIE_NUMERO_ORDEN")
	private String numeroOrden;
	
	@XmlElement(name = "Id")
	@Column(name = "BIE_ID")
	private String id;
	
	@XmlElement(name = "NumeroRecepcion") 
	@Column(name = "BIE_NUMERO_RECEPCION")
	private String numeroRecepcion;
	
	@XmlElement(name = "LineaRecepcion") 
	@Column(name = "BIE_LINEA_RECEPCION")
	private String lineaRecepcion;
	
	@XmlElement(name = "Posicion") 
	@Column(name = "BIE_POSICION")
	private String posicion;
	
	@XmlElement(name = "CantidadRecibida") 
	@Column(name = "BIE_CANTIDAD_RECIBIDA")
	private String cantidadRecibida;
	
	@XmlElement(name = "Neto") 
	@Column(name = "BIE_NETO")
	private String neto;
	
	@XmlElement(name = "PrecioNeto") 
	@Column(name = "BIE_PRECIO_NETO")
	private String precioNeto;
	
	@XmlElement(name = "FechaEntrega") 
	@Column(name = "BIE_FECHA_ENTREGA")
	private String fechaEntrega;
	
	@XmlElement(name = "IdUsuario")
	@Column(name = "BIE_ID_USUARIO")
	private String idUsuario;
	
	@XmlElement(name = "CodUsuario")
	@Column(name = "BIE_COD_USUARIO")
	private String codUsuario;
	
	@XmlElement(name = "NombreUsuario")
	@Column(name = "BIE_NOMBRE_USUARIO")
	private String nombreUsuario;
	
	@XmlElement(name = "Texto1")
	@Column(name = "BIE_TEXTO1")
	private String texto1;
	
	@XmlElement(name = "Texto2")
	@Column(name = "BIE_TEXTO2")
	private String texto2;
	
	@XmlElement(name = "Texto3")
	@Column(name = "BIE_TEXTO3")
	private String texto3;
	
	@XmlElement(name = "Texto4")
	@Column(name = "BIE_TEXTO4")
	private String texto4;
	
	@XmlElement(name = "Texto5")
	@Column(name = "BIE_TEXTO5")
	private String texto5;
	 
	@XmlElement(name = "Numerico1")
	@Column(name = "BIE_NUMERICO1")
	private String numerico1;
	
	@XmlElement(name = "Numerico2")
	@Column(name = "BIE_NUMERICO2")
	private String numerico2;
	
	@XmlElement(name = "Numerico3")
	@Column(name = "BIE_NUMERICO3")
	private String numerico3;
	
	@XmlElement(name = "Numerico4")
	@Column(name = "BIE_NUMERICO4")
	private String numerico4;
	
	@XmlElement(name = "Numerico5")
	@Column(name = "BIE_NUMERICO5")
	private String numerico5;
	
	@XmlElement(name = "Fecha1")
	@Column(name = "BIE_FECHA1")
	private String fecha1;
	
	@XmlElement(name = "Fecha2")
	@Column(name = "BIE_FECHA2")
	private String fecha2;
	
	@XmlElement(name = "Fecha3")
	@Column(name = "BIE_FECHA3")
	private String fecha3;
	
	@XmlElement(name = "Fecha4")
	@Column(name = "BIE_FECHA4")
	private String fecha4;
	
	@XmlElement(name = "Fecha5")
	@Column(name = "BIE_FECHA5")
	private String fecha5;
	
	@XmlElement(name = "MetodoRecepcion")
	@Column(name = "BIE_METODO_RECEPCION")
	private String metodoRecepcion;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public DetalleCabecera getDetalleCabecera() {
		return detalleCabecera;
	}

	public void setDetalleCabecera(DetalleCabecera detalleCabecera) {
		this.detalleCabecera = detalleCabecera;
	}

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroRecepcion() {
		return numeroRecepcion;
	}

	public void setNumeroRecepcion(String numeroRecepcion) {
		this.numeroRecepcion = numeroRecepcion;
	}

	public String getLineaRecepcion() {
		return lineaRecepcion;
	}

	public void setLineaRecepcion(String lineaRecepcion) {
		this.lineaRecepcion = lineaRecepcion;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(String cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public String getNeto() {
		return neto;
	}

	public void setNeto(String neto) {
		this.neto = neto;
	}

	public String getPrecioNeto() {
		return precioNeto;
	}

	public void setPrecioNeto(String precioNeto) {
		this.precioNeto = precioNeto;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

	public String getTexto3() {
		return texto3;
	}

	public void setTexto3(String texto3) {
		this.texto3 = texto3;
	}

	public String getTexto4() {
		return texto4;
	}

	public void setTexto4(String texto4) {
		this.texto4 = texto4;
	}

	public String getTexto5() {
		return texto5;
	}

	public void setTexto5(String texto5) {
		this.texto5 = texto5;
	}

	public String getNumerico1() {
		return numerico1;
	}

	public void setNumerico1(String numerico1) {
		this.numerico1 = numerico1;
	}

	public String getNumerico2() {
		return numerico2;
	}

	public void setNumerico2(String numerico2) {
		this.numerico2 = numerico2;
	}

	public String getNumerico3() {
		return numerico3;
	}

	public void setNumerico3(String numerico3) {
		this.numerico3 = numerico3;
	}

	public String getNumerico4() {
		return numerico4;
	}

	public void setNumerico4(String numerico4) {
		this.numerico4 = numerico4;
	}

	public String getNumerico5() {
		return numerico5;
	}

	public void setNumerico5(String numerico5) {
		this.numerico5 = numerico5;
	}

	public String getFecha1() {
		return fecha1;
	}

	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}

	public String getFecha2() {
		return fecha2;
	}

	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}

	public String getFecha3() {
		return fecha3;
	}

	public void setFecha3(String fecha3) {
		this.fecha3 = fecha3;
	}

	public String getFecha4() {
		return fecha4;
	}

	public void setFecha4(String fecha4) {
		this.fecha4 = fecha4;
	}

	public String getFecha5() {
		return fecha5;
	}

	public void setFecha5(String fecha5) {
		this.fecha5 = fecha5;
	}

	public String getMetodoRecepcion() {
		return metodoRecepcion;
	}

	public void setMetodoRecepcion(String metodoRecepcion) {
		this.metodoRecepcion = metodoRecepcion;
	}

}