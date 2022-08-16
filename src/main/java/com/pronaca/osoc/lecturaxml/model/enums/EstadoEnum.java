package com.pronaca.osoc.lecturaxml.model.enums;

public enum EstadoEnum implements Identificable<EstadoEnum>{
	
	PENDIENTE_REVISION("PENDIENTE_REVISION"), PROCESADA("PROCESADA"), TODOS("TODOS"),  CARGADO("CARGADO"), ACTIVO("ACTIVO"), INACTIVO("INACTIVO");

	private String descripcion;

	private EstadoEnum(final String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public EstadoEnum getIdentificador() {
		return this;
	}
}
