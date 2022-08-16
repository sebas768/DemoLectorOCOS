package com.pronaca.osoc.lecturaxml.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * The persistent class for the LEC_DETALLE_CABECERA database table.
 */
@Entity
@Table(name = "LEC_DETALLE_CABECERA")
@NamedQueries({ @NamedQuery(name = "DetalleCabecera.findDetalle", query = "Select object(d) from DetalleCabecera as d order by 1 ") })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "numeroOrden", "posicion", "facturado", "liberado",  "cantidadPerdida",
					   "unidadCompra", "precio", "importe", "unidadPrecio", "importeBruto",
					   "iva", "codFiscal", "porcentajeIva", "cantidadFacturada", "cantidadNetaEntrega",
					   "cantidadEntrega", "entregaMercaderiaReq", "codProducto",
					   "nombreProducto", "unspsc", "fechaPlanificadaRecepcion", "fechaRealRecepcion",
					   "comentario", "texto1", "texto2", "texto3", "texto4", "texto5", "texto6",
					   "texto7", "texto8", "texto9", "texto10", "numerico1", "numerico2", "numerico3",
					   "numerico4", "numerico5", "fecha1", "fecha2", "fecha3", "fecha4", "fecha5",
					   "descripcion", "codFactorIng", "codEstrategiaIng", "bienesFacturadosRecib", "metodoRecepcion","dimension","bien"})
public class DetalleCabecera implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;

	@Id
	@XmlTransient
	@SequenceGenerator(name = "LEC_DETALLE_CABECERA_DET_CODIGO_GENERATOR", sequenceName = "SEQ_LEC_DETALLE_CABECERA",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEC_DETALLE_CABECERA_DET_CODIGO_GENERATOR")
	@Column(name = "DET_CODIGO")
	private Long codigo;

	@Transient
	@XmlElement(name = "NumeroOrden")
	private String numeroOrden;
	
	// bidirectional many-to-one association
	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "DET_NUMERO_ORDEN", nullable = false) 
	@JsonBackReference
	private CabeceraOrden cabeceraOrden;

	@XmlTransient
	@Column(name = "DET_ID")
	private String id;

	@XmlTransient
	@Column(name = "DET_ID_ORDEN")
	private String idOrden;

	@XmlElement(name = "Posicion")
	@Column(name = "DET_POSICION")
	private String posicion;

	@XmlElement(name = "Facturado")
	@Column(name = "DET_FACTURADO")
	private String facturado;

	@XmlElement(name = "Liberado")
	@Column(name = "DET_LIBERADO")
	private String liberado;

	@XmlElement(name = "CantidadPedida")
	@Column(name = "DET_CANTIDAD_PERDIDA")
	private String cantidadPerdida;
	
	@XmlElement(name = "UnidadCompra")
	@Column(name = "DET_UNIDAD_COMPRA")
	private String unidadCompra;

	@XmlElement(name = "Precio")
	@Column(name = "DET_PRECIO")
	private String precio;

	@XmlElement(name = "Importe")
	@Column(name = "DET_IMPORTE")
	private String importe;
	
	@XmlElement(name = "UnidadPrecio")
	@Column(name = "DET_UNIDAD_PRECIO")
	private String unidadPrecio;
	
	@XmlElement(name = "ImporteBruto")
	@Column(name = "DET_IMPORTE_BRUTO")
	private String importeBruto;

	@XmlElement(name = "Iva")
	@Column(name = "DET_IVA")
	private String iva;
	
	@XmlElement(name = "CodFiscal")
	@Column(name = "DET_COD_FISCAL")
	private String codFiscal;

	@XmlElement(name = "PorcentajeIva")
	@Column(name = "DET_PORCENTAJE_IVA")
	private String porcentajeIva;

	@XmlTransient
	@Column(name = "DET_IMPORTE_NETO_FACTURADO")
	private String importeNetoFacturado;
	
	@XmlElement(name = "CantidadFacturada")
	@Column(name = "DET_CANTIDAD_FACTURADA")
	private String cantidadFacturada;
	
	@XmlElement(name = "CantidadNetaEntregada")
	@Column(name = "DET_CANTIDAD_NETA_ENTREGA")
	private String cantidadNetaEntrega;

	@XmlElement(name = "CantidadEntregada")
	@Column(name = "DET_CANTIDAD_ENTREGA")
	private String cantidadEntrega;

	@XmlElement(name = "EntregaMercaderiaReq")
	@Column(name = "DET_ENTREGA_MERCADERIA_REQ")
	private String entregaMercaderiaReq;
	
	@XmlElement(name = "CodProducto")
	@Column(name = "DET_COD_PRODUCTO")
	private String codProducto;

	@XmlElement(name = "NombreProducto")
	@Column(name = "DET_NOMBRE_PRODUCTO")
	private String nombreProducto;
	
	@XmlElement(name = "Unspsc")
	@Column(name = "DET_UNSPSC")
	private String unspsc;
	
	@XmlElement(name = "FechaPlanificadaRecepcion")
	@Column(name = "DET_FECHA_PLANIFICADA_RECEPCION")
	private String fechaPlanificadaRecepcion;
	
	@XmlElement(name = "FechaRealRecepcion")
	@Column(name = "DET_FECHA_REAL_RECEPCION")
	private String fechaRealRecepcion;
	
	@XmlElement(name = "Comentario")
	@Column(name = "DET_COMENTARIO")
	private String comentario;
	
	@XmlElement(name = "Texto1")
	@Column(name = "DET_TEXTO1")
	private String texto1;
	
	@XmlElement(name = "Texto2")
	@Column(name = "DET_TEXTO2")
	private String texto2;

	@XmlElement(name = "Texto3")
	@Column(name = "DET_TEXTO3")
	private String texto3;

	@XmlElement(name = "Texto4")
	@Column(name = "DET_TEXTO4")
	private String texto4;

	@XmlElement(name = "Texto5")
	@Column(name = "DET_TEXTO5")
	private String texto5;

	@XmlElement(name = "Texto6")
	@Column(name = "DET_TEXTO6")
	private String texto6;

	@XmlElement(name = "Texto7")
	@Column(name = "DET_TEXTO7")
	private String texto7;

	@XmlElement(name = "Texto8")
	@Column(name = "DET_TEXTO8")
	private String texto8;

	@XmlElement(name = "Texto9")
	@Column(name = "DET_TEXTO9")
	private String texto9;

	@XmlElement(name = "Texto10")
	@Column(name = "DET_TEXTO10")
	private String texto10;
	
	@XmlElement(name = "Numerico1")
	@Column(name = "DET_NUMERICO1")
	private String numerico1;

	@XmlElement(name = "Numerico2")
	@Column(name = "DET_NUMERICO2")
	private String numerico2;

	@XmlElement(name = "Numerico3")
	@Column(name = "DET_NUMERICO3")
	private String numerico3;

	@XmlElement(name = "Numerico4")
	@Column(name = "DET_NUMERICO4")
	private String numerico4;

	@XmlElement(name = "Numerico5")
	@Column(name = "DET_NUMERICO5")
	private String numerico5;
	
	@XmlElement(name = "Fecha1")
	@Column(name = "DET_FECHA1")
	private String fecha1;

	@XmlElement(name = "Fecha2")
	@Column(name = "DET_FECHA2")
	private String fecha2;

	@XmlElement(name = "Fecha3")
	@Column(name = "DET_FECHA3")
	private String fecha3;
	
	@XmlElement(name = "Fecha4")
	@Column(name = "DET_FECHA4")
	private String fecha4;

	@XmlElement(name = "Fecha5")
	@Column(name = "DET_FECHA5")
	private String fecha5;

	@XmlElement(name = "Descripcion")
	@Column(name = "DET_DESCRIPCION")
	private String descripcion;
	
	@XmlElement(name = "CodFactorIng")
	@Column(name = "DET_COD_FACTOR_ING")
	private String codFactorIng;

	@XmlElement(name = "CodEstrategiaIng")
	@Column(name = "DET_COD_ESTRATEGIA_ING")
	private String codEstrategiaIng;

	@XmlElement(name = "BienesFacturadosRecib")
	@Column(name = "DET_BIENES_FACTURADOS_RECIB")
	private String bienesFacturadosRecib;

	@XmlElement(name = "MetodoRecepcion")
	@Column(name = "DET_METODO_RECEPCION")
	private String metodoRecepcion;
	
	// bidirectional many-to-one association to Dimension
	@XmlElementWrapper(name = "Dimensiones")
	@XmlElement(name = "Dimension", namespace = "")
	@OneToMany(mappedBy = "detalleCabecera")
	@JsonManagedReference
	private List<Dimension> dimension;

	// bidirectional many-to-one association to Bien
	@XmlElementWrapper(name = "Bienes")
	@XmlElement(name = "Bien", namespace = "")
	@OneToMany(mappedBy = "detalleCabecera")
	@JsonManagedReference
	private List<Bien> bien;

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

	public String getCantidadPerdida() {
		return cantidadPerdida;
	}

	public void setCantidadPerdida(String cantidadPerdida) {
		this.cantidadPerdida = cantidadPerdida;
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

	public CabeceraOrden getCabeceraOrden() {
		return cabeceraOrden;
	}

	public void setCabeceraOrden(CabeceraOrden cabeceraOrden) {
		this.cabeceraOrden = cabeceraOrden;
	}

	public List<Dimension> getDimension() {
		return dimension;
	}

	public void setDimension(List<Dimension> dimension) {
		this.dimension = dimension;
	}

	public List<Bien> getBien() {
		return bien;
	}

	public void setBien(List<Bien> bien) {
		this.bien = bien;
	}

}