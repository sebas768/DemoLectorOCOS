package com.pronaca.osoc.lecturaxml.model.generic;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.pronaca.osoc.lecturaxml.anotacions.Sistema;

@MappedSuperclass
@Sistema(sistema = "B2B-PUENTE", activoCarga = true)
public abstract class CargaIDBGeneric<Pk extends Serializable> {

	public abstract Pk getPk();

	public abstract Boolean isValidEntiti();

	public abstract Object[] getData();

}