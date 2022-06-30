package com.pronaca.osoc.lecturaxml.model.enums;

public enum OperacionCRUDEnum implements Identificable<OperacionCRUDEnum> {

	U("UPDATE"), I("INSERT"), D("DELETE");

	private String descripcion;

	private OperacionCRUDEnum(final String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public OperacionCRUDEnum getIdentificador() {
		return this;
	}

}
