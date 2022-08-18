package com.pronaca.osoc.lecturaxml.model.enums;

public enum TipoEnum implements Identificable<TipoEnum>{
	
	OC("OC"), OS("OS");

	private String descripcion;

	private TipoEnum(final String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public TipoEnum getIdentificador() {
		return this;
	}
}
