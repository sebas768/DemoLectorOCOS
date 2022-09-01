package com.pronaca.osoc.lecturaxml.model.dto;

import java.io.Serializable;
import java.util.List;

import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * 
 * @author bayteq
 *
 */
public class DetalleCabeceraDTO implements Serializable {
	
	private static final long serialVersionUID = 2513506782694494679L;
	private Long codigo;
	private String numeroOrden;
	private String id;
	private String idOrden;
	private String posicion;
	private String facturado;
	private String liberado;
	private String cantidadPedida;
	private String unidadCompra;
	private String precio;
	private String importe;
	private String unidadPrecio;
	private String importeBruto;
	private String iva;
	private String codFiscal;
	private String porcentajeIva;
	private String importeNetoFacturado;
	private String cantidadFacturada;
	private String cantidadNetaEntrega;
	private String cantidadEntrega;
	private String entregaMercaderiaReq;
	private String codProducto;
	private String nombreProducto;
	private String unspsc;
	private String fechaPlanificadaRecepcion;
	private String fechaRealRecepcion;
	private String comentario;
	private String texto1;
	private String texto2;
	private String texto3;
	private String texto4;
	private String texto5;
	private String texto6;
	private String texto7;
	private String texto8;
	private String texto9;
	private String texto10;
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
	private String descripcion;
	private String codFactorIng;
	private String codEstrategiaIng;
	private String bienesFacturadosRecib;
	private String metodoRecepcion;
	private EstadoEnum estadoRevision;
	private List<DimensionDTO> dimensiones;
	private List<BienDTO> bienes;
	
	
	
	public DetalleCabeceraDTO(DetalleCabecera dc) {
		super();
		this.codigo = dc.getCodigo();
		this.numeroOrden = dc.getNumeroOrden();
		this.id = dc.getId();
		this.idOrden = dc.getIdOrden();
		this.posicion = dc.getPosicion();
		this.facturado = dc.getFacturado();
		this.liberado = dc.getLiberado();
		this.cantidadPedida = dc.getCantidadPedida();
		this.unidadCompra = dc.getUnidadCompra();
		this.precio = dc.getPrecio();
		this.importe = dc.getImporte();
		this.unidadPrecio = dc.getUnidadPrecio();
		this.importeBruto = dc.getImporteBruto();
		this.iva = dc.getIva();
		this.codFiscal = dc.getCodFiscal();
		this.porcentajeIva = dc.getPorcentajeIva();
		this.importeNetoFacturado = dc.getImporteNetoFacturado();
		this.cantidadFacturada = dc.getCantidadFacturada();
		this.cantidadNetaEntrega = dc.getCantidadNetaEntrega();
		this.cantidadEntrega = dc.getCantidadEntrega();
		this.entregaMercaderiaReq = dc.getEntregaMercaderiaReq();
		this.codProducto = dc.getCodProducto();
		this.nombreProducto = dc.getNombreProducto();
		this.unspsc = dc.getUnspsc();
		this.fechaPlanificadaRecepcion = dc.getFechaPlanificadaRecepcion();
		this.fechaRealRecepcion = dc.getFechaRealRecepcion();
		this.comentario = dc.getComentario();
		this.texto1 = dc.getTexto1();
		this.texto2 = dc.getTexto2();
		this.texto3 = dc.getTexto3();
		this.texto4 = dc.getTexto4();
		this.texto5 = dc.getTexto5();
		this.texto6 = dc.getTexto6();
		this.texto7 = dc.getTexto7();
		this.texto8 = dc.getTexto8();
		this.texto9 = dc.getTexto9();
		this.texto10 = dc.getTexto10();
		this.numerico1 = dc.getNumerico1();
		this.numerico2 = dc.getNumerico2();
		this.numerico3 = dc.getNumerico3();
		this.numerico4 = dc.getNumerico4();
		this.numerico5 = dc.getNumerico5();
		this.fecha1 = dc.getFecha1();
		this.fecha2 = dc.getFecha2();
		this.fecha3 = dc.getFecha3();
		this.fecha4 = dc.getFecha4();
		this.fecha5 = dc.getFecha5();
		this.descripcion = dc.getDescripcion();
		this.codFactorIng = dc.getCodFactorIng();
		this.codEstrategiaIng = dc.getCodEstrategiaIng();
		this.bienesFacturadosRecib = dc.getBienesFacturadosRecib();
		this.metodoRecepcion = dc.getMetodoRecepcion();
		this.estadoRevision = dc.getEstadoRevision();
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
	public String getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(String cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
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
	public List<DimensionDTO> getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(List<DimensionDTO> dimensiones) {
		this.dimensiones = dimensiones;
	}
	public List<BienDTO> getBienes() {
		return bienes;
	}
	public void setBienes(List<BienDTO> bienes) {
		this.bienes = bienes;
	}
	public EstadoEnum getEstadoRevision() {
		return estadoRevision;
	}
	public void setEstadoRevision(EstadoEnum estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	
}
