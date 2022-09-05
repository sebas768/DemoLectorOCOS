package com.pronaca.osoc.lecturaxml.model.dto;

import java.io.Serializable;


import com.pronaca.osoc.lecturaxml.model.entities.Bien;
import com.pronaca.osoc.lecturaxml.model.entities.BienOrdenH;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;


/**
 * 
 * @author bayteq
 *
 */
public class BienDTO implements Serializable {
	
	private static final long serialVersionUID = 2513506782694494679L;
	private Long codigo;
	private String numeroOrden;
	private String id;
	private String numeroRecepcion;
	private String lineaRecepcion;
	private String posicion;
	private String cantidadRecibida;
	private String neto;
	private String precioNeto;
	private String fechaEntrega;
	private String idUsuario;
	private String codUsuario;
	private String nombreUsuario;
	private String texto1;
	private String texto2;
	private String texto3;
	private String texto4;
	private String texto5;
	private String numerico1;
	private String numerico2;
	private String numerico3;
	private String numerico4;
	private String numerico5;
	private String fecha1;
	private String fecha2;
	private String fecha3;
	private String fecha4;
	private String fecha5;
	private String metodoRecepcion;
	private EstadoEnum estadoRevision;
	
	
	public BienDTO(Bien b) {
		super();
		this.codigo = b.getCodigo();
		this.numeroOrden = b.getNumeroOrden();
		this.id = b.getId();
		this.numeroRecepcion = b.getNumeroRecepcion();
		this.lineaRecepcion = b.getLineaRecepcion();
		this.posicion = b.getPosicion();
		this.cantidadRecibida = b.getCantidadRecibida();
		this.neto = b.getNeto();
		this.precioNeto = b.getPrecioNeto();
		this.fechaEntrega = b.getFechaEntrega();
		this.idUsuario = b.getIdUsuario();
		this.codUsuario = b.getCodUsuario();
		this.nombreUsuario = b.getNombreUsuario();
		this.texto1 = b.getTexto1();
		this.texto2 = b.getTexto2();
		this.texto3 = b.getTexto3();
		this.texto4 = b.getTexto4();
		this.texto5 = b.getTexto5();
		this.numerico1 = b.getNumerico1();
		this.numerico2 = b.getNumerico2();
		this.numerico3 = b.getNumerico3();
		this.numerico4 = b.getNumerico4();
		this.numerico5 = b.getNumerico5();
		this.fecha1 = b.getFecha1();
		this.fecha2 = b.getFecha2();
		this.fecha3 = b.getFecha3();
		this.fecha4 = b.getFecha4();
		this.fecha5 = b.getFecha5();
		this.metodoRecepcion = b.getMetodoRecepcion();
		this.estadoRevision = b.getEstadoRevision();
	}
	
	public BienDTO(BienOrdenH b) {
		super();
		this.codigo = b.getCodigo();
		this.numeroOrden = b.getNumeroOrden();
		this.id = b.getId();
		this.numeroRecepcion = b.getNumeroRecepcion();
		this.lineaRecepcion = b.getLineaRecepcion();
		this.posicion = b.getPosicion();
		this.cantidadRecibida = b.getCantidadRecibida();
		this.neto = b.getNeto();
		this.precioNeto = b.getPrecioNeto();
		this.fechaEntrega = b.getFechaEntrega();
		this.idUsuario = b.getIdUsuario();
		this.codUsuario = b.getCodUsuario();
		this.nombreUsuario = b.getNombreUsuario();
		this.texto1 = b.getTexto1();
		this.texto2 = b.getTexto2();
		this.texto3 = b.getTexto3();
		this.texto4 = b.getTexto4();
		this.texto5 = b.getTexto5();
		this.numerico1 = b.getNumerico1();
		this.numerico2 = b.getNumerico2();
		this.numerico3 = b.getNumerico3();
		this.numerico4 = b.getNumerico4();
		this.numerico5 = b.getNumerico5();
		this.fecha1 = b.getFecha1();
		this.fecha2 = b.getFecha2();
		this.fecha3 = b.getFecha3();
		this.fecha4 = b.getFecha4();
		this.fecha5 = b.getFecha5();
		this.metodoRecepcion = b.getMetodoRecepcion();
		this.estadoRevision = b.getEstadoRevision();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public EstadoEnum getEstadoRevision() {
		return estadoRevision;
	}
	public void setEstadoRevision(EstadoEnum estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	
}
