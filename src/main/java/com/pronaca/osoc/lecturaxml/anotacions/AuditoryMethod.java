/**
 * 
 */
package com.pronaca.osoc.lecturaxml.anotacions;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Freddy Castillo
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditoryMethod {

	/**
	 * Si el campo es auditable
	 * 
	 * @return
	 */
	public boolean disable() default false;

	/**
	 * Expresión utilizada en la uditoria
	 * 
	 * @return
	 */
	public String expresionAuditoria() default "";

	/**
	 * Referencia de la primary key 2
	 * 
	 * @return
	 */
	public boolean isPk1() default false;

	/**
	 * Referencia de la primary key 2
	 * 
	 * @return
	 */
	public boolean isPk2() default false;

	/**
	 * Referencia de la primary key 3
	 * 
	 * @return
	 */
	public boolean isPk3() default false;

	/**
	 * Descripción de la primary key 1
	 * 
	 * @return
	 */
	public boolean isPk1Descripcion() default false;

	/**
	 * Descripción de la primary key 2
	 * 
	 * @return
	 */
	public boolean isPk2Descripcion() default false;

	/**
	 * Descripción de la primary key 3
	 * 
	 * @return
	 */
	public boolean isPk3Descripcion() default false;

	/**
	 * Se realiza la auditoria en la actualizacion
	 * 
	 * @return
	 */
	public boolean aditableUpdate() default false;

	/**
	 * Se realiza la auditoria en la creacion
	 * 
	 * @return
	 */
	public boolean aditableCreate() default false;

	/**
	 * Se realiza la auditoria en la eliminacion
	 * 
	 * @return
	 */
	public boolean aditableDelete() default false;

}
