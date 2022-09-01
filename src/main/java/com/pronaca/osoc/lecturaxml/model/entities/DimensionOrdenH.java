package com.pronaca.osoc.lecturaxml.model.entities;

import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the LEC_DIMENSION_ORDEN_H database table.
 */
@Entity
@Table(name = "LEC_DIMENSION_ORDEN_H")
public class DimensionOrdenH implements Serializable {
 
	private static final long serialVersionUID = 700413412370715597L;
	
	@Id
	@SequenceGenerator(name = "LEC_DIMENSION_ORDEN_H_DIM_HIST_ID_GENERATOR", sequenceName = "SEQ_LEC_DIMENSION_ORDEN_H",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEC_DIMENSION_ORDEN_H_DIM_HIST_ID_GENERATOR")
	@Column(name = "DIM_HIST_ID") 
	private Long histId;
	
	@Column(name = "DIM_CODIGO") 
	private Long codigo;
	
	@Column(name = "DIM_NUMERO_ORDEN")
	private String numeroOrden;
	
	@Column(name = "DIM_ID")
	private String id;
	
	@Column(name = "DIM_ID_POSICION")
	private String idPosicion;
	
	@Column(name = "DIM_POSICION")
	private String posicion;
	
	@Column(name = "DIM_INDICE_PEDIDOS")
	private String indicePedidos;
	
	@Column(name = "DIM_COD_CUENTA")
	private String codCuenta;
	
	@Column(name = "DIM_NOMBRE_CUENTA")
	private String nombreCuenta; 
	
	@Column(name = "DIM_COD_CENTRO_COSTO")
	private String codCentroCosto;
	
	@Column(name = "DIM_NOMBRE_CENTRO_COSTO")
	private String nombreCentroCosto;
	
	@Column(name = "DIM_COD_PROYECTO")
	private String codProyecto;
	
	@Column(name = "DIM_NOMBRE_PROYECTO")
	private String nombreProyecto;
	
	@Column(name = "DIM_IMPORTE_BRUTO")
	private String importeBruto;
	
	@Column(name = "DIM_NETO")
	private String neto;
	
	@Column(name = "DIM_IVA")
	private String iva;
	
	@Column(name = "DIM_COD_FISCAL")
	private String codFiscal;
	
	@Column(name = "DIM_PORCENTAJE_IVA")
	private String porcentajeIva;
	
	@Column(name = "DIM_CANTIDAD")
	private String cantidad; 
	
	@Column(name = "DIM_TEXTO1")
	private String texto1;

	@Column(name = "DIM_TEXTO2")
	private String texto2;
	
	@Column(name = "DIM_TEXTO3")
	private String texto3;
	
	@Column(name = "DIM_TEXTO4")
	private String texto4;
	
	@Column(name = "DIM_TEXTO5")
	private String texto5;
	
	@Column(name = "DIM_TEXTO6")
	private String texto6;
	
	@Column(name = "DIM_TEXTO7")
	private String texto7;
	
	@Column(name = "DIM_TEXTO8")
	private String texto8;
	
	@Column(name = "DIM_TEXTO9")
	private String texto9;
	
	@Column(name = "DIM_TEXTO10")
	private String texto10;
	
	@Column(name = "DIM_TEXTO11")
	private String texto11;
	
	@Column(name = "DIM_TEXTO12")
	private String texto12;
	
	@Column(name = "DIM_TEXTO13")
	private String texto13;
	
	@Column(name = "DIM_TEXTO14")
	private String texto14;
	
	@Column(name = "DIM_TEXTO15")
	private String texto15;
	
	@Column(name = "DIM_TEXTO16")
	private String texto16;
	
	@Column(name = "DIM_TEXTO17")
	private String texto17;
	
	@Column(name = "DIM_TEXTO18")
	private String texto18;
	
	@Column(name = "DIM_TEXTO19")
	private String texto19;
	
	@Column(name = "DIM_TEXTO20")
	private String texto20;
	
	@Column(name = "DIM_NUMERICO1")
	private String numerico1;
	
	@Column(name = "DIM_NUMERICO2")
	private String numerico2;
	
	@Column(name = "DIM_NUMERICO3")
	private String numerico3;
	
	@Column(name = "DIM_NUMERICO4")
	private String numerico4;
	
	@Column(name = "DIM_NUMERICO5")
	private String numerico5;
	
	@Column(name = "DIM_FECHA1")
	private String fecha1;
	
	@Column(name = "DIM_FECHA2")
	private String fecha2;
	
	@Column(name = "DIM_FECHA3")
	private String fecha3;
	
	@Column(name = "DIM_FECHA4")
	private String fecha4;
	
	@Column(name = "DIM_FECHA5")
	private String fecha5;
	
	@Column(name = "DIM_ESTADO_REVISION")
	@Enumerated(EnumType.STRING)
	private EstadoEnum estadoRevision;

	
	public Long getHistId() {
		return histId;
	}

	public void setHistId(Long histId) {
		this.histId = histId;
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

	public String getIdPosicion() {
		return idPosicion;
	}

	public void setIdPosicion(String idPosicion) {
		this.idPosicion = idPosicion;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getIndicePedidos() {
		return indicePedidos;
	}

	public void setIndicePedidos(String indicePedidos) {
		this.indicePedidos = indicePedidos;
	}

	public String getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getCodCentroCosto() {
		return codCentroCosto;
	}

	public void setCodCentroCosto(String codCentroCosto) {
		this.codCentroCosto = codCentroCosto;
	}

	public String getNombreCentroCosto() {
		return nombreCentroCosto;
	}

	public void setNombreCentroCosto(String nombreCentroCosto) {
		this.nombreCentroCosto = nombreCentroCosto;
	}

	public String getCodProyecto() {
		return codProyecto;
	}

	public void setCodProyecto(String codProyecto) {
		this.codProyecto = codProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getImporteBruto() {
		return importeBruto;
	}

	public void setImporteBruto(String importeBruto) {
		this.importeBruto = importeBruto;
	}

	public String getNeto() {
		return neto;
	}

	public void setNeto(String neto) {
		this.neto = neto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getCodFiscal() {
		return codFiscal;
	}

	public void setCodFiscal(String codFiscal) {
		this.codFiscal = codFiscal;
	}

	public String getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(String porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
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

	public String getTexto6() {
		return texto6;
	}

	public void setTexto6(String texto6) {
		this.texto6 = texto6;
	}

	public String getTexto7() {
		return texto7;
	}

	public void setTexto7(String texto7) {
		this.texto7 = texto7;
	}

	public String getTexto8() {
		return texto8;
	}

	public void setTexto8(String texto8) {
		this.texto8 = texto8;
	}

	public String getTexto9() {
		return texto9;
	}

	public void setTexto9(String texto9) {
		this.texto9 = texto9;
	}

	public String getTexto10() {
		return texto10;
	}

	public void setTexto10(String texto10) {
		this.texto10 = texto10;
	}

	public String getTexto11() {
		return texto11;
	}

	public void setTexto11(String texto11) {
		this.texto11 = texto11;
	}

	public String getTexto12() {
		return texto12;
	}

	public void setTexto12(String texto12) {
		this.texto12 = texto12;
	}

	public String getTexto13() {
		return texto13;
	}

	public void setTexto13(String texto13) {
		this.texto13 = texto13;
	}

	public String getTexto14() {
		return texto14;
	}

	public void setTexto14(String texto14) {
		this.texto14 = texto14;
	}

	public String getTexto15() {
		return texto15;
	}

	public void setTexto15(String texto15) {
		this.texto15 = texto15;
	}

	public String getTexto16() {
		return texto16;
	}

	public void setTexto16(String texto16) {
		this.texto16 = texto16;
	}

	public String getTexto17() {
		return texto17;
	}

	public void setTexto17(String texto17) {
		this.texto17 = texto17;
	}

	public String getTexto18() {
		return texto18;
	}

	public void setTexto18(String texto18) {
		this.texto18 = texto18;
	}

	public String getTexto19() {
		return texto19;
	}

	public void setTexto19(String texto19) {
		this.texto19 = texto19;
	}

	public String getTexto20() {
		return texto20;
	}

	public void setTexto20(String texto20) {
		this.texto20 = texto20;
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

	public EstadoEnum getEstadoRevision() {
		return estadoRevision;
	}

	public void setEstadoRevision(EstadoEnum estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

}