package com.pronaca.osoc.lecturaxml.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the LEC_ID_MENSAJES_LOGS database table.
 * 
 */
@Entity
@Table(name="LEC_ID_MENSAJES_LOGS")
public class LecIdMensajesLogs {
	
	@Id
	@SequenceGenerator(name="LEC_ID_MENSAJES_LOGS_IML_ID_GENERATOR", sequenceName="SEQ_LEC_ID_MENSAJES_LOGS", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LEC_ID_MENSAJES_LOGS_IML_ID_GENERATOR")
	@Column(name="IML_ID")
	private Long id;
	
	@Column(name="IML_REFERENCEID")
	private String referenceId;

	@Column(name="IML_MESSAGEID")
	private String messageId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}