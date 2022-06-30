package com.pronaca.osoc.lecturaxml.anotacions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;

/**
 * Objeto que representa los atributos de de un entity en el serivor FTP, cuyos atributos seran
 * usados en el load
 * 
 * @author Freddy Castillo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LoaderAnotation {

	/**
	 * Nombre del archivo xml de carga
	 * 
	 * @return
	 */
	public String fileXML() default "";

	/**
	 * Posee atributo estado para actualizar o cambiar de estado el registro
	 * 
	 * @return
	 */
	public boolean isUpdateEstatus();

	/**
	 * Retorna el valor del estatus INACTIVO
	 * 
	 * @return
	 */
	public EstadoEnum valueInactive() default EstadoEnum.INACTIVO;

	/**
	 * Retorna el valor para el estatus ACTIVO
	 * 
	 * @return
	 */
	public EstadoEnum valueActive() default EstadoEnum.ACTIVO;

	/**
	 * Retorna el valor para el estatus ACTIVO
	 * 
	 * @return
	 */
	public String columnEstatus() default "estado";

	/**
	 * <b> Conditions update. </b>
	 * <p>
	 * [Author rene.travez, 22/03/2017]
	 * </p>
	 * 
	 * @return String[]
	 */
	public abstract String[] conditionsUpdate() default {};

	/**
	 * Procedimiento SQL Para inserscion
	 * 
	 * @return
	 */
	public String procedureQuerry() default "";
}
