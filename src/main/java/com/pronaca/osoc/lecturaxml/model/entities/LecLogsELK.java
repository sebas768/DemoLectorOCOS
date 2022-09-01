package com.pronaca.osoc.lecturaxml.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the LEC_LOGS_ELK database table.
 * 
 */
@Entity
@Table(name="LEC_LOGS_ELK")
public class LecLogsELK {
	
	@Id
	@SequenceGenerator(name="LEC_LOGS_ELK_ELK_CODIGO_GENERATOR", sequenceName = "SEQ_LEC_LOGS_ELK", allocationSize = 1)
	@GeneratedValue(generator="LEC_LOGS_ELK_ELK_CODIGO_GENERATOR", strategy=GenerationType.SEQUENCE)
	@Column(name="ELK_CODIGO")
	private Long codigo;
	
	@Column(name="ELK_LEC_CODIGO_OCOS")
	private String codigoOrden;
	
	@Column(name="ELK_LEC_CODIGO_DET_OCOS")
	private Long codigoDetalle;
	
	@Column(name="ELK_CODIGO_COMPANIA")
	private String codigoCompania;
	
	@Column(name="ELK_UUID")
	private String uuid;
	
	/*@Temporal( TemporalType.TIMESTAMP)
	@Column(name="ELK_FECHA_PROCESO")
	private Date fechaProceso;*/
	
	@Column(name="ELK_EVENTO")
	private String evento;
	
	@Column(name="ELK_ESTADO")
	private String estado;
	
	@Column(name="ELK_MENSAJE_RESPUESTA")
	private String mensajeRespuesta;
	
	@Column(name="ELK_REFERENCE_ID")
	private String referenceId;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCodigoOrden() {
		return codigoOrden;
	}

	public void setCodigoOrden(String codigoOrden) {
		this.codigoOrden = codigoOrden;
	}

	public Long getCodigoDetalle() {
		return codigoDetalle;
	}

	public void setCodigoDetalle(Long codigoDetalle) {
		this.codigoDetalle = codigoDetalle;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
}
