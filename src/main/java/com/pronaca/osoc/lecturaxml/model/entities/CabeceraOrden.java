package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * The persistent class for the LEC_CABECERA_ORDEN database table.
 */
@Entity
@Table(name = "LEC_CABECERA_ORDEN")
@NamedQueries({@NamedQuery(name = "CabeceraOrden.findCabecera", query = "Select object(c) from CabeceraOrden as c order by 1 ")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "numeroOrden", "estado", "error", "fechaProceso", "codTipoOrden", 
					   "referencia", "facturado", "liberado", "divisa", "tipoCambio",
					   "proveedor", "decProveedor", "codOrganizacion", "desOrganizacion",
					   "compania", "desCompania", "codOrganizacionComp", "desOrganizacionComp",
					   "importeBruto", "subtotal", "iva", "importeNetoFacturado", "netoEntregado",
					   "identPropietario", "codPropietario", "nombrePropietario", "identComprador",
					   "codComprador", "nombreComprador", "fechaOrden", "fechaPlanificadaRecepcion",
					   "fechaRealRecepcion", "estadoRecupDatos", "texto1", "texto2", "texto3",
					   "texto4", "texto5", "texto6", "texto7", "texto8", "texto9", "texto10",
					   "numerico1", "numerico2", "numerico3", "numerico4", "numerico5",
					   "fecha1", "fecha2", "fecha3", "fecha4", "fecha5", "personaReferencia", 
					   "codProveedorPrincipal", "nombreProveedorPrincipal", "bienesFacturadosRecib"})
public class CabeceraOrden implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;

	@Id
	@XmlElement(name = "NumeroOrden")
	@Column(name = "CAB_NUMERO_ORDEN")
	private String numeroOrden;

	@XmlTransient
	@Column(name = "CAB_ID")
	private String idOrden;

	@XmlElement(name = "Estado")
	@Column(name = "CAB_ESTADO")
	private String estado;

	@XmlElement(name = "Error")
	@Column(name = "CAB_ERROR")
	private String error;

	@XmlElement(name = "FechaProceso")
	@Column(name = "CAB_FECHA_PROCESO")
	private String fechaProceso;

	@XmlElement(name = "CodTipoOrden")
	@Column(name = "CAB_COD_TIPO_ORDEN")
	private String codTipoOrden;

	@XmlElement(name = "Referencia")
	@Column(name = "CAB_REFERENCIA")
	private String referencia;

	@XmlElement(name = "Facturado")
	@Column(name = "CAB_FACTURADO")
	private String facturado;

	@XmlElement(name = "Liberado")
	@Column(name = "CAB_LIBERADO")
	private String liberado;

	@XmlElement(name = "Divisa")
	@Column(name = "CAB_DIVISA")
	private String divisa;

	@XmlElement(name = "TipoCambio")
	@Column(name = "CAB_TIPO_CAMBIO")
	private String tipoCambio;

	@XmlElement(name = "Proveedor")
	@Column(name = "CAB_PROVEEDOR")
	private String proveedor;

	@XmlElement(name = "DescProveedor")
	@Column(name = "CAB_DEC_PROVEEDOR")
	private String decProveedor;

	@XmlElement(name = "CodOrganizacion")
	@Column(name = "CAB_COD_ORGANIZACION")
	private String codOrganizacion;

	@XmlElement(name = "DesOrganizacion")
	@Column(name = "CAB_DES_ORGANIZACION")
	private String desOrganizacion;

	@XmlElement(name = "Compania")
	@Column(name = "CAB_COMPANIA")
	private String compania;

	@XmlElement(name = "DesCompania")
	@Column(name = "CAB_DES_COMPANIA")
	private String desCompania;

	@XmlElement(name = "CodOrganizacionComp")
	@Column(name = "CAB_COD_ORGANIZACION_COMP")
	private String codOrganizacionComp;

	@XmlElement(name = "DesOrganizacionComp")
	@Column(name = "CAB_DES_ORGANIZACION_COMP")
	private String desOrganizacionComp;

	@XmlElement(name = "ImporteBruto")
	@Column(name = "CAB_IMPORTE_BRUTO")
	private String importeBruto;

	@XmlElement(name = "Subtotal")
	@Column(name = "CAB_SUBTOTAL")
	private String subtotal;
	
	@XmlElement(name = "Iva")
	@Column(name = "CAB_IVA")
	private String iva;

	@XmlElement(name = "ImporteNetoFacturado")
	@Column(name = "CAB_IMPORTE_NETO_FACTURADO")
	private String importeNetoFacturado;

	@XmlElement(name = "NetoEntregado")
	@Column(name = "CAB_NETO_ENTREGADO")
	private String netoEntregado;

	@XmlElement(name = "IdentPropietario")
	@Column(name = "CAB_IDENT_PROPIETARIO")
	private String identPropietario;

	@XmlElement(name = "CodPropietario")
	@Column(name = "CAB_COD_PROPIETARIO")
	private String codPropietario;

	@XmlElement(name = "NombrePropietario")
	@Column(name = "CAB_NOMBRE_PROPIETARIO")
	private String nombrePropietario;

	@XmlElement(name = "IdentComprado") 
	@Column(name = "CAB_IDENT_COMPRADOR")
	private String identComprador;

	@XmlElement(name = "CodComprador")
	@Column(name = "CAB_COD_COMPRADOR")
	private String codComprador;

	@XmlElement(name = "NombreComprador")
	@Column(name = "CAB_NOMBRE_COMPRADOR")
	private String nombreComprador;

	@XmlElement(name = "FechaOrden")
	@Column(name = "CAB_FECHA_ORDEN")
	private String fechaOrden;

	@XmlElement(name = "FechaPlanificadaRecepcion")
	@Column(name = "CAB_FECHA_PLANIFICADA_RECEPCION")
	private String fechaPlanificadaRecepcion;

	@XmlElement(name = "FechaRealRecepcion")
	@Column(name = "CAB_FECHA_REAL_RECEPCION")
	private String fechaRealRecepcion;

	@XmlElement(name = "EstadoRecupDatos")
	@Column(name = "CAB_ESTADO_RECUP_DATOS")
	private String estadoRecupDatos;

	@XmlElement(name = "Texto1")
	@Column(name = "CAB_TEXTO1")
	private String texto1;

	@XmlElement(name = "Texto2")
	@Column(name = "CAB_TEXTO2")
	private String texto2;

	@XmlElement(name = "Texto3")
	@Column(name = "CAB_TEXTO3")
	private String texto3;

	@XmlElement(name = "Texto4")
	@Column(name = "CAB_TEXTO4")
	private String texto4;

	@XmlElement(name = "Texto5")
	@Column(name = "CAB_TEXTO5")
	private String texto5;

	@XmlElement(name = "Texto6")
	@Column(name = "CAB_TEXTO6")
	private String texto6;

	@XmlElement(name = "Texto7")
	@Column(name = "CAB_TEXTO7")
	private String texto7;

	@XmlElement(name = "Texto8")
	@Column(name = "CAB_TEXTO8")
	private String texto8;

	@XmlElement(name = "Texto9")
	@Column(name = "CAB_TEXTO9")
	private String texto9;

	@XmlElement(name = "Texto10")
	@Column(name = "CAB_TEXTO10")
	private String texto10;

	@XmlElement(name = "Numerico1")
	@Column(name = "CAB_NUMERICO1")
	private String numerico1;

	@XmlElement(name = "Numerico2")
	@Column(name = "CAB_NUMERICO2")
	private String numerico2;

	@XmlElement(name = "Numerico3")
	@Column(name = "CAB_NUMERICO3")
	private String numerico3;

	@XmlElement(name = "Numerico4")
	@Column(name = "CAB_NUMERICO4")
	private String numerico4;

	@XmlElement(name = "Numerico5")
	@Column(name = "CAB_NUMERICO5")
	private String numerico5;

	@XmlElement(name = "Fecha1")
	@Column(name = "CAB_FECHA1")
	private String fecha1;

	@XmlElement(name = "Fecha2")
	@Column(name = "CAB_FECHA2")
	private String fecha2;

	@XmlElement(name = "Fecha3")
	@Column(name = "CAB_FECHA3")
	private String fecha3;

	@XmlElement(name = "Fecha4")
	@Column(name = "CAB_FECHA4")
	private String fecha4;

	@XmlElement(name = "Fecha5")
	@Column(name = "CAB_FECHA5")
	private String fecha5;

	@XmlElement(name = "PersonaReferencia")
	@Column(name = "CAB_PERSONA_REFERENCIA")
	private String personaReferencia;
	
	@XmlElement(name = "CodProveedorPrincipal")
	@Column(name = "CAB_COD_PROVEEDOR_PRINCIPAL")
	private String codProveedorPrincipal;

	@XmlElement(name = "NombreProveedorPrincipal")
	@Column(name = "CAB_NOMBRE_PROVEEDOR_PRINCIPAL")
	private String nombreProveedorPrincipal;

	@XmlElement(name = "BienesFacturadosRecib")
	@Column(name = "CAB_BIENES_FACTURADOS_RECIB")
	private String bienesFacturadosRecib;

	@XmlTransient
	@Column(name = "CAB_ESTADO_REVISION")
	@Enumerated(EnumType.STRING)
	private EstadoEnum estadoRevision;

	// bidirectional many-to-one association to DetalleCabecera
	@XmlTransient
	@OneToMany(mappedBy = "cabeceraOrden")
	@JsonManagedReference
	private List<DetalleCabecera> detalleCabecera;

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getCodTipoOrden() {
		return codTipoOrden;
	}

	public void setCodTipoOrden(String codTipoOrden) {
		this.codTipoOrden = codTipoOrden;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getDecProveedor() {
		return decProveedor;
	}

	public void setDecProveedor(String decProveedor) {
		this.decProveedor = decProveedor;
	}

	public String getCodOrganizacion() {
		return codOrganizacion;
	}

	public void setCodOrganizacion(String codOrganizacion) {
		this.codOrganizacion = codOrganizacion;
	}

	public String getDesOrganizacion() {
		return desOrganizacion;
	}

	public void setDesOrganizacion(String desOrganizacion) {
		this.desOrganizacion = desOrganizacion;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getDesCompania() {
		return desCompania;
	}

	public void setDesCompania(String desCompania) {
		this.desCompania = desCompania;
	}

	public String getCodOrganizacionComp() {
		return codOrganizacionComp;
	}

	public void setCodOrganizacionComp(String codOrganizacionComp) {
		this.codOrganizacionComp = codOrganizacionComp;
	}

	public String getDesOrganizacionComp() {
		return desOrganizacionComp;
	}

	public void setDesOrganizacionComp(String desOrganizacionComp) {
		this.desOrganizacionComp = desOrganizacionComp;
	}

	public String getImporteBruto() {
		return importeBruto;
	}

	public void setImporteBruto(String importeBruto) {
		this.importeBruto = importeBruto;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getImporteNetoFacturado() {
		return importeNetoFacturado;
	}

	public void setImporteNetoFacturado(String importeNetoFacturado) {
		this.importeNetoFacturado = importeNetoFacturado;
	}

	public String getNetoEntregado() {
		return netoEntregado;
	}

	public void setNetoEntregado(String netoEntregado) {
		this.netoEntregado = netoEntregado;
	}

	public String getIdentPropietario() {
		return identPropietario;
	}

	public void setIdentPropietario(String identPropietario) {
		this.identPropietario = identPropietario;
	}

	public String getCodPropietario() {
		return codPropietario;
	}

	public void setCodPropietario(String codPropietario) {
		this.codPropietario = codPropietario;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getIdentComprado() {
		return identComprador;
	}

	public void setIdentComprado(String identComprado) {
		this.identComprador = identComprado;
	}

	public String getCodComprador() {
		return codComprador;
	}

	public void setCodComprador(String codComprador) {
		this.codComprador = codComprador;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
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

	public String getEstadoRecupDatos() {
		return estadoRecupDatos;
	}

	public void setEstadoRecupDatos(String estadoRecupDatos) {
		this.estadoRecupDatos = estadoRecupDatos;
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

	public String getPersonaReferencia() {
		return personaReferencia;
	}

	public void setPersonaReferencia(String personaReferencia) {
		this.personaReferencia = personaReferencia;
	}

	public String getCodProveedorPrincipal() {
		return codProveedorPrincipal;
	}

	public void setCodProveedorPrincipal(String codProveedorPrincipal) {
		this.codProveedorPrincipal = codProveedorPrincipal;
	}

	public String getNombreProveedorPrincipal() {
		return nombreProveedorPrincipal;
	}

	public void setNombreProveedorPrincipal(String nombreProveedorPrincipal) {
		this.nombreProveedorPrincipal = nombreProveedorPrincipal;
	}

	public String getBienesFacturadosRecib() {
		return bienesFacturadosRecib;
	}

	public void setBienesFacturadosRecib(String bienesFacturadosRecib) {
		this.bienesFacturadosRecib = bienesFacturadosRecib;
	}

	public EstadoEnum getEstadoRevision() {
		return estadoRevision;
	}

	public void setEstadoRevision(EstadoEnum estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

	public List<DetalleCabecera> getDetalleCabecera() {
		return detalleCabecera;
	}

	public void setDetalleCabecera(List<DetalleCabecera> detalleCabecera) {
		this.detalleCabecera = detalleCabecera;
	}

}