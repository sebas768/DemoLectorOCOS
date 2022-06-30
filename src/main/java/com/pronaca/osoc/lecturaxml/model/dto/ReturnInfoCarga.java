package com.pronaca.osoc.lecturaxml.model.dto;

public class ReturnInfoCarga {
	private String resultado;
	private String mensajeError;
	private int numeroError;
	private int numeroRetorno;

	public ReturnInfoCarga() {
		super();
	}

	public ReturnInfoCarga(String resultado, String mensajeError, int numeroError, int numeroRetorno) {
		super();
		this.resultado = resultado;
		this.mensajeError = mensajeError;
		this.numeroError = numeroError;
		this.numeroRetorno = numeroRetorno;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public int getNumeroError() {
		return numeroError;
	}

	public void setNumeroError(int numeroError) {
		this.numeroError = numeroError;
	}

	public int getNumeroRetorno() {
		return numeroRetorno;
	}

	public void setNumeroRetorno(int numeroRetorno) {
		this.numeroRetorno = numeroRetorno;
	}
}
