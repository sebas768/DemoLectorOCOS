package com.pronaca.osoc.lecturaxml.logs.model.json;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Evento implements Serializable {

	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = -1338392741236446275L;
	/**
	 * PROPERTIES
	 */
	@SerializedName(value = "@timestamp")
	private String timestamp;
	
	@SerializedName(value = "evento.tipo")
	private String tipo;
	
	@SerializedName(value = "evento.mensaje.entrada")
	private String mensajeEndtrada;
	
	@SerializedName(value = "evento.mensaje.salida")
	private String mensajeSalida;

	@SerializedName(value = "evento.mensaje.error")
	private String mensajeError;
	
	@SerializedName(value = "evento.codigo")
	private String eventoCodigo;
	
	@SerializedName(value = "evento.valor")
	private String eventoValor;
	
	@SerializedName(value = "evento.nivel")
	private String eventoNivel;
	
	@SerializedName(value = "evento.compania")
	private String eventoCompania;
	
	@SerializedName(value = "evento.sistema ")
	private String eventoSistema ;
	
	@SerializedName(value = "evento.capa")
	private String eventoCapa;
	
	@SerializedName(value = "evento.paso")
	private String eventoPaso;
	
	@SerializedName(value = "evento.hora.inicio")
	private String eventoHoraInicio;
	
	@SerializedName(value = "evento.hora.fin")
	private String eventoHoraFin ;
	
	@SerializedName(value = "evento.referenceId")
	private String eventoReferenceId;
	
	@SerializedName(value = "evento.proceso.nombre")
	private String eventoProcesoNombre;

	@SerializedName(value = "evento.actividad")
	private String eventoActividad;

	@SerializedName(value = "evento.pantalla")
	private String eventoPantalla;
	
	@SerializedName(value = "evento.clase")
	private String eventoClase;
	
	@SerializedName(value = "evento.metodo")
	private String eventoMetodo;

	@SerializedName(value = "actualiza.valor.original")
	private String actualizaValorOriginal;
	
	@SerializedName(value = "actualiza.valor.actualizado")
	private String actualizaValorActualizado;
	
	@SerializedName(value = "actualiza.valor.descrpcion")
	private String actualizaValorDescrpcion;
	
	@SerializedName(value = "aplicacion.nombre")
	private String aplicacionNombre;
	
	@SerializedName(value = "host.name")
	private String hostName;
	
	@SerializedName(value = "host.ip")
	private String hostIp;
	
	@SerializedName(value = "host.os.nombre")
	private String hostOsNombre;
	
	@SerializedName(value = "host.os.version")
	private String hostOsVersion;
	
	@SerializedName(value = "componente.tipo")
	private String componenteTipo;
	
	@SerializedName(value = "componente.nombre")
	private String componenteNombre;
	
	@SerializedName(value = "componente.operacion")
	private String componenteOperacion;
	
	@SerializedName(value = "http.request.metodo")
	private String httpRequestMetodo;
	
	@SerializedName(value = "http.codigo.respuesta")
	private String httpCodigoRespuesta;
	
	@SerializedName(value = "url.full")
	private String urlFull ;

	@SerializedName(value = "url.path")
	private String urlPath ;

	@SerializedName(value = "url.puerto")
	private String urlPuerto ;

	@SerializedName(value = "usuario.nombre")
	private String usuarioNombre ;

	@SerializedName(value = "usuario.email")
	private String usuarioEmail ;

	@SerializedName(value = "usuario.nombrecompleto")
	private String usuarioNombrecompleto;
	
	@SerializedName(value = "usuario.rol")
	private String usuarioRol ;

	@SerializedName(value = "usuario.numero.intentos.acceso")
	private String usuarioNumeroIntentosAcceso;

	
	public Evento() {

	}


	public String getTimestamp() {
		return timestamp;
	}




	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getMensajeEndtrada() {
		return mensajeEndtrada;
	}




	public void setMensajeEndtrada(String mensajeEndtrada) {
		this.mensajeEndtrada = mensajeEndtrada;
	}




	public String getMensajeSalida() {
		return mensajeSalida;
	}




	public void setMensajeSalida(String mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
	}




	public String getMensajeError() {
		return mensajeError;
	}




	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}




	public String getEventoCodigo() {
		return eventoCodigo;
	}




	public void setEventoCodigo(String eventoCodigo) {
		this.eventoCodigo = eventoCodigo;
	}




	public String getEventoValor() {
		return eventoValor;
	}




	public void setEventoValor(String eventoValor) {
		this.eventoValor = eventoValor;
	}




	public String getEventoNivel() {
		return eventoNivel;
	}




	public void setEventoNivel(String eventoNivel) {
		this.eventoNivel = eventoNivel;
	}




	public String getEventoCompania() {
		return eventoCompania;
	}




	public void setEventoCompania(String eventoCompania) {
		this.eventoCompania = eventoCompania;
	}




	public String getEventoSistema() {
		return eventoSistema;
	}




	public void setEventoSistema(String eventoSistema) {
		this.eventoSistema = eventoSistema;
	}




	public String getEventoCapa() {
		return eventoCapa;
	}




	public void setEventoCapa(String eventoCapa) {
		this.eventoCapa = eventoCapa;
	}




	public String getEventoHoraInicio() {
		return eventoHoraInicio;
	}




	public void setEventoHoraInicio(String eventoHoraInicio) {
		this.eventoHoraInicio = eventoHoraInicio;
	}




	public String getEventoHoraFin() {
		return eventoHoraFin;
	}




	public void setEventoHoraFin(String eventoHoraFin) {
		this.eventoHoraFin = eventoHoraFin;
	}




	public String getEventoReferenceId() {
		return eventoReferenceId;
	}




	public void setEventoReferenceId(String eventoReferenceId) {
		this.eventoReferenceId = eventoReferenceId;
	}




	public String getEventoProcesoNombre() {
		return eventoProcesoNombre;
	}




	public void setEventoProcesoNombre(String eventoProcesoNombre) {
		this.eventoProcesoNombre = eventoProcesoNombre;
	}




	public String getEventoActividad() {
		return eventoActividad;
	}




	public void setEventoActividad(String eventoActividad) {
		this.eventoActividad = eventoActividad;
	}




	public String getEventoPantalla() {
		return eventoPantalla;
	}




	public void setEventoPantalla(String eventoPantalla) {
		this.eventoPantalla = eventoPantalla;
	}




	public String getEventoClase() {
		return eventoClase;
	}




	public void setEventoClase(String eventoClase) {
		this.eventoClase = eventoClase;
	}




	public String getEventoMetodo() {
		return eventoMetodo;
	}




	public void setEventoMetodo(String eventoMetodo) {
		this.eventoMetodo = eventoMetodo;
	}




	public String getActualizaValorOriginal() {
		return actualizaValorOriginal;
	}




	public void setActualizaValorOriginal(String actualizaValorOriginal) {
		this.actualizaValorOriginal = actualizaValorOriginal;
	}




	public String getActualizaValorActualizado() {
		return actualizaValorActualizado;
	}




	public void setActualizaValorActualizado(String actualizaValorActualizado) {
		this.actualizaValorActualizado = actualizaValorActualizado;
	}




	public String getActualizaValorDescrpcion() {
		return actualizaValorDescrpcion;
	}




	public void setActualizaValorDescrpcion(String actualizaValorDescrpcion) {
		this.actualizaValorDescrpcion = actualizaValorDescrpcion;
	}




	public String getAplicacionNombre() {
		return aplicacionNombre;
	}




	public void setAplicacionNombre(String aplicacionNombre) {
		this.aplicacionNombre = aplicacionNombre;
	}




	public String getHostName() {
		return hostName;
	}




	public void setHostName(String hostName) {
		this.hostName = hostName;
	}




	public String getHostIp() {
		return hostIp;
	}




	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}




	public String getHostOsNombre() {
		return hostOsNombre;
	}




	public void setHostOsNombre(String hostOsNombre) {
		this.hostOsNombre = hostOsNombre;
	}




	public String getHostOsVersion() {
		return hostOsVersion;
	}




	public void setHostOsVersion(String hostOsVersion) {
		this.hostOsVersion = hostOsVersion;
	}




	public String getComponenteTipo() {
		return componenteTipo;
	}




	public void setComponenteTipo(String componenteTipo) {
		this.componenteTipo = componenteTipo;
	}




	public String getComponenteNombre() {
		return componenteNombre;
	}




	public void setComponenteNombre(String componenteNombre) {
		this.componenteNombre = componenteNombre;
	}




	public String getComponenteOperacion() {
		return componenteOperacion;
	}




	public void setComponenteOperacion(String componenteOperacion) {
		this.componenteOperacion = componenteOperacion;
	}




	public String getHttpRequestMetodo() {
		return httpRequestMetodo;
	}




	public void setHttpRequestMetodo(String httpRequestMetodo) {
		this.httpRequestMetodo = httpRequestMetodo;
	}




	public String getHttpCodigoRespuesta() {
		return httpCodigoRespuesta;
	}




	public void setHttpCodigoRespuesta(String httpCodigoRespuesta) {
		this.httpCodigoRespuesta = httpCodigoRespuesta;
	}




	public String getUrlFull() {
		return urlFull;
	}




	public void setUrlFull(String urlFull) {
		this.urlFull = urlFull;
	}




	public String getUrlPath() {
		return urlPath;
	}




	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}




	public String getUrlPuerto() {
		return urlPuerto;
	}




	public void setUrlPuerto(String urlPuerto) {
		this.urlPuerto = urlPuerto;
	}




	public String getUsuarioNombre() {
		return usuarioNombre;
	}




	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}




	public String getUsuarioEmail() {
		return usuarioEmail;
	}




	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}




	public String getUsuarioNombrecompleto() {
		return usuarioNombrecompleto;
	}




	public void setUsuarioNombrecompleto(String usuarioNombrecompleto) {
		this.usuarioNombrecompleto = usuarioNombrecompleto;
	}




	public String getUsuarioRol() {
		return usuarioRol;
	}




	public void setUsuarioRol(String usuarioRol) {
		this.usuarioRol = usuarioRol;
	}




	public String getUsuarioNumeroIntentosAcceso() {
		return usuarioNumeroIntentosAcceso;
	}




	public void setUsuarioNumeroIntentosAcceso(String usuarioNumeroIntentosAcceso) {
		this.usuarioNumeroIntentosAcceso = usuarioNumeroIntentosAcceso;
	}




	public String getEventoPaso() {
		return eventoPaso;
	}




	public void setEventoPaso(String eventoPaso) {
		this.eventoPaso = eventoPaso;
	}

	
	
}
