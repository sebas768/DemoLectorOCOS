package com.pronaca.osoc.lecturaxml.model.dto;

import java.io.Serializable;
import java.util.List;

import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * 
 * @author bayteq
 *
 */
public class CabeceraOrdenDTO implements Serializable {
	
	private static final long serialVersionUID = 2513506782694494679L;
	private String numeroOrden;
	private String idOrden;
	private String estado;
	private String error;
	private String fechaProceso;
	private String codTipoOrden;
	private String referencia;
	private String facturado;
	private String liberado;
	private String divisa;
	private String tipoCambio;
	private String proveedor;
	private String decProveedor;
	private String codOrganizacion;
	private String desOrganizacion;
	private String compania;
	private String desCompania;
	private String codOrganizacionComp;
	private String desOrganizacionComp;
	private String importeBruto;
	private String subtotal;
	private String iva;
	private String importeNetoFacturado;
	private String netoEntregado;
	private String identPropietario;
	private String codPropietario;
	private String nombrePropietario;
	private String identComprador;
	private String codComprador;
	private String nombreComprador;
	private String fechaOrden;
	private String fechaPlanificadaRecepcion;
	private String fechaRealRecepcion;
	private String estadoRecupDatos;
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
	private String personaReferencia;
	private String codProveedorPrincipal;
	private String nombreProveedorPrincipal;
	private String bienesFacturadosRecib;
	private EstadoEnum estadoRevision;
	private List<DetalleCabeceraDTO> detalleCabecera;
	
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
	public String getIdentComprador() {
		return identComprador;
	}
	public void setIdentComprador(String identComprador) {
		this.identComprador = identComprador;
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
	public List<DetalleCabeceraDTO> getDetalleCabecera() {
		return detalleCabecera;
	}
	public void setDetalleCabecera(List<DetalleCabeceraDTO> detalleCabecera) {
		this.detalleCabecera = detalleCabecera;
	}
}