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
 * The persistent class for the LEC_DETALLE_ORDEN_H database table.
 */
@Entity
@Table(name = "LEC_DETALLE_ORDEN_H")
public class DetalleCabeceraH implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;

	@Id
	@SequenceGenerator(name = "LEC_DETALLE_ORDEN_H_DET_HIST_ID_GENERATOR", sequenceName = "SEQ_LEC_DETALLE_ORDEN_H",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEC_DETALLE_ORDEN_H_DET_HIST_ID_GENERATOR")
	@Column(name = "DET_HIST_ID")
	private Long histId;

	@Column(name = "DET_CODIGO")
	private Long codigo;
	
	@Column(name = "DET_ID")
	private String id;

	@Column(name = "DET_ID_ORDEN")
	private String idOrden;

	@Column(name = "DET_NUMERO_ORDEN")
	private String numeroOrden;

	@Column(name = "DET_POSICION")
	private String posicion;

	@Column(name = "DET_FACTURADO")
	private String facturado;

	@Column(name = "DET_LIBERADO")
	private String liberado;

	@Column(name = "DET_CANTIDAD_PEDIDA")
	private String cantidadPedida;
	
	@Column(name = "DET_UNIDAD_COMPRA")
	private String unidadCompra;

	@Column(name = "DET_PRECIO")
	private String precio;

	@Column(name = "DET_IMPORTE")
	private String importe;
	
	@Column(name = "DET_UNIDAD_PRECIO")
	private String unidadPrecio;
	
	@Column(name = "DET_IMPORTE_BRUTO")
	private String importeBruto;

	@Column(name = "DET_IVA")
	private String iva;
	
	@Column(name = "DET_COD_FISCAL")
	private String codFiscal;

	@Column(name = "DET_PORCENTAJE_IVA")
	private String porcentajeIva;

	@Column(name = "DET_IMPORTE_NETO_FACTURADO")
	private String importeNetoFacturado;
	
	@Column(name = "DET_CANTIDAD_FACTURADA")
	private String cantidadFacturada;
	
	@Column(name = "DET_CANTIDAD_NETA_ENTREGA")
	private String cantidadNetaEntrega;

	@Column(name = "DET_CANTIDAD_ENTREGA")
	private String cantidadEntrega;

	@Column(name = "DET_ENTREGA_MERCADERIA_REQ")
	private String entregaMercaderiaReq;
	
	@Column(name = "DET_COD_PRODUCTO")
	private String codProducto;

	@Column(name = "DET_NOMBRE_PRODUCTO")
	private String nombreProducto;
	
	@Column(name = "DET_UNSPSC")
	private String unspsc;
	
	@Column(name = "DET_FECHA_PLANIFICADA_RECEPCION")
	private String fechaPlanificadaRecepcion;
	
	@Column(name = "DET_FECHA_REAL_RECEPCION")
	private String fechaRealRecepcion;
	
	@Column(name = "DET_COMENTARIO")
	private String comentario;
	
	@Column(name = "DET_TEXTO1")
	private String texto1;
	
	@Column(name = "DET_TEXTO2")
	private String texto2;

	@Column(name = "DET_TEXTO3")
	private String texto3;

	@Column(name = "DET_TEXTO4")
	private String texto4;

	@Column(name = "DET_TEXTO5")
	private String texto5;

	@Column(name = "DET_TEXTO6")
	private String texto6;

	@Column(name = "DET_TEXTO7")
	private String texto7;

	@Column(name = "DET_TEXTO8")
	private String texto8;

	@Column(name = "DET_TEXTO9")
	private String texto9;

	@Column(name = "DET_TEXTO10")
	private String texto10;
	
	@Column(name = "DET_NUMERICO1")
	private String numerico1;

	@Column(name = "DET_NUMERICO2")
	private String numerico2;

	@Column(name = "DET_NUMERICO3")
	private String numerico3;

	@Column(name = "DET_NUMERICO4")
	private String numerico4;

	@Column(name = "DET_NUMERICO5")
	private String numerico5;
	
	@Column(name = "DET_FECHA1")
	private String fecha1;

	@Column(name = "DET_FECHA2")
	private String fecha2;

	@Column(name = "DET_FECHA3")
	private String fecha3;
	
	@Column(name = "DET_FECHA4")
	private String fecha4;

	@Column(name = "DET_FECHA5")
	private String fecha5;

	@Column(name = "DET_DESCRIPCION")
	private String descripcion;
	
	@Column(name = "DET_COD_FACTOR_ING")
	private String codFactorIng;

	@Column(name = "DET_COD_ESTRATEGIA_ING")
	private String codEstrategiaIng;

	@Column(name = "DET_BIENES_FACTURADOS_RECIB")
	private String bienesFacturadosRecib;

	@Column(name = "DET_METODO_RECEPCION")
	private String metodoRecepcion;
	
	@Column(name = "DET_ESTADO_REVISION")
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

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getFacturado() {
		return facturado;
	}

	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}

	public String getLiberado() {
		return liberado;
	}

	public void setLiberado(String liberado) {
		this.liberado = liberado;
	}

	public String getUnidadCompra() {
		return unidadCompra;
	}

	public void setUnidadCompra(String unidadCompra) {
		this.unidadCompra = unidadCompra;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getUnidadPrecio() {
		return unidadPrecio;
	}

	public void setUnidadPrecio(String unidadPrecio) {
		this.unidadPrecio = unidadPrecio;
	}

	public String getImporteBruto() {
		return importeBruto;
	}

	public void setImporteBruto(String importeBruto) {
		this.importeBruto = importeBruto;
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

	public String getImporteNetoFacturado() {
		return importeNetoFacturado;
	}

	public void setImporteNetoFacturado(String importeNetoFacturado) {
		this.importeNetoFacturado = importeNetoFacturado;
	}

	public String getCantidadFacturada() {
		return cantidadFacturada;
	}

	public void setCantidadFacturada(String cantidadFacturada) {
		this.cantidadFacturada = cantidadFacturada;
	}

	public String getCantidadNetaEntrega() {
		return cantidadNetaEntrega;
	}

	public void setCantidadNetaEntrega(String cantidadNetaEntrega) {
		this.cantidadNetaEntrega = cantidadNetaEntrega;
	}

	public String getCantidadEntrega() {
		return cantidadEntrega;
	}

	public void setCantidadEntrega(String cantidadEntrega) {
		this.cantidadEntrega = cantidadEntrega;
	}

	public String getEntregaMercaderiaReq() {
		return entregaMercaderiaReq;
	}

	public void setEntregaMercaderiaReq(String entregaMercaderiaReq) {
		this.entregaMercaderiaReq = entregaMercaderiaReq;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getUnspsc() {
		return unspsc;
	}

	public void setUnspsc(String unspsc) {
		this.unspsc = unspsc;
	}

	public String getFechaPlanificadaRecepcion() {
		return fechaPlanificadaRecepcion;
	}

	public void setFechaPlanificadaRecepcion(String fechaPlanificadaRecepcion) {
		this.fechaPlanificadaRecepcion = fechaPlanificadaRecepcion;
	}

	public String getFechaRealRecepcion() {
		return fechaRealRecepcion;
	}

	public void setFechaRealRecepcion(String fechaRealRecepcion) {
		this.fechaRealRecepcion = fechaRealRecepcion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodFactorIng() {
		return codFactorIng;
	}

	public void setCodFactorIng(String codFactorIng) {
		this.codFactorIng = codFactorIng;
	}

	public String getCodEstrategiaIng() {
		return codEstrategiaIng;
	}

	public void setCodEstrategiaIng(String codEstrategiaIng) {
		this.codEstrategiaIng = codEstrategiaIng;
	}

	public String getBienesFacturadosRecib() {
		return bienesFacturadosRecib;
	}

	public void setBienesFacturadosRecib(String bienesFacturadosRecib) {
		this.bienesFacturadosRecib = bienesFacturadosRecib;
	}

	public String getMetodoRecepcion() {
		return metodoRecepcion;
	}

	public void setMetodoRecepcion(String metodoRecepcion) {
		this.metodoRecepcion = metodoRecepcion;
	}

	public String getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(String cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public EstadoEnum getEstadoRevision() {
		return estadoRevision;
	}

	public void setEstadoRevision(EstadoEnum estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

}