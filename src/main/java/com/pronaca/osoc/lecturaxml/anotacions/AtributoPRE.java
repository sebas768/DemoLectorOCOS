package com.pronaca.osoc.lecturaxml.anotacions;

 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AtributoPRE {

	public String objectType() default "";

	public String propertyName() default "";

	public boolean isMapping() default false;

	public boolean isPrimaryKey() default false;

	/**
	 * Metodo que valida si un entity es valido para registrar en el sistema
	 * 
	 * @return
	 */
	
	public boolean isValidateEntity() default false;
}
