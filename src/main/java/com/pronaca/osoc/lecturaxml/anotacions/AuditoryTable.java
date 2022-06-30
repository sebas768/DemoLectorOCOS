/**
 * 
 */
package com.pronaca.osoc.lecturaxml.anotacions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Freddy Castillo
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AuditoryTable {

	/**
	 * Tipo de entidad
	 * 
	 * @return
	 */
	public String tipoEntidad();

	/**
	 * Modulo al cual pertenece la entidad
	 * 
	 * @return
	 */
	public String modulo();
}
