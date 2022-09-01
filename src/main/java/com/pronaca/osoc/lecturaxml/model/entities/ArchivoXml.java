package com.pronaca.osoc.lecturaxml.model.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the LEC_ARCHIVO_XML database table.
 */
@Entity
@Table(name = "LEC_ARCHIVO_XML")
@NamedQueries({	@NamedQuery(name = "ArchivoXml.findArchivo", query = "Select object(a) from ArchivoXml as a order by 1 " )})
public class ArchivoXml implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;
	
	@Id
	@SequenceGenerator(name = "LEC_ARCHIVO_XML_ARC_CODIGO_GENERATOR", sequenceName = "SEQ_LEC_ARCHIVO_XML",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEC_ARCHIVO_XML_ARC_CODIGO_GENERATOR")
	@Column(name = "ARC_CODIGO")
	private Long codigo;
	
	@Column(name = "ARC_NOMBRE_ARCHIVO" )
	private String nombreArchivo;
	
	@Column(name = "ARC_FECHA_ARCHIVO")
	private Date fechaArchivo;
	
	@Column(name = "ARC_FECHA_CARGA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaCarga;
	
	@Column(name = "ARC_PESO_ARCHIVO")
	private String pesoArchivo;
	
	@Column(name = "ARC_CONTENT_BLOB")
	private Blob contentBlob;
	
	@Column(name = "ARC_VERSION")
	private String version;
	
	@Column(name = "ARC_ESTADO_CARGA")
	private String estadoCarga;
	
	@Column(name = "ARC_TEXTO1")
	private String texto1;
	
	@Column(name = "ARC_TEXTO2")
	private String texto2;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Date getFechaArchivo() {
		return fechaArchivo;
	}

	public void setFechaArchivo(Date fechaArchivo) {
		this.fechaArchivo = fechaArchivo;
	}

	public String getPesoArchivo() {
		return pesoArchivo;
	}

	public void setPesoArchivo(String pesoArchivo) {
		this.pesoArchivo = pesoArchivo;
	}

	public Blob getContentBlob() {
		return contentBlob;
	}

	public void setContentBlob(Blob contentBlob) {
		this.contentBlob = contentBlob;
	}

	public String getEstadoCarga() {
		return estadoCarga;
	}

	public void setEstadoCarga(String estadoCarga) {
		this.estadoCarga = estadoCarga;
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

	public Calendar getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Calendar fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}