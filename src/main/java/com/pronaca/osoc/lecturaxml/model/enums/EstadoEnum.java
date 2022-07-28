package com.pronaca.osoc.lecturaxml.model.enums;

public enum EstadoEnum implements Identificable<EstadoEnum>{
	ACTIVO("ACTIVO"), INACTIVO("INACTIVO"), ACT("ACT"), INA("INA"), SI("Si"), NO("No"), 
	PENDIENTE_REVISION("PENDIENTE_REVISION"), PROCESADA("PROCESADA"), TODOS("TODOS"), CARGADO("CARGADO");

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
