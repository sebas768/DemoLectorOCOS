/**
 * 
 */
package com.pronaca.osoc.lecturaxml.anotacions;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/******************************************************************************************************
 * <center>(c) Copyright BAYTEQ Cia. Ltda. 2006</center>
 * <center>www.bayteq.com</center> <center>info@bayteq.com</center><br/>
 * Este programa de computador es propiedad de BAYTEQ Cia. Ltda. y esta
 * protegido por las leyes y tratados internacionales de derechos de autor. El
 * uso, reproducci�n o distribuci�n no autorizada de este programa, o cualquier
 * porci�n de �l, puede dar lugar a sanciones criminales y civiles severas, y
 * ser�n procesadas con el grado m�ximo contemplado por la ley.<br/>
 * <br/>
 * 
 * @author:Freddy Castillo
 * @Archivo:AtributoBPM.java
 * @Descripci�n:
 * @Fecha: 29/12/2016
 ******************************************************************************************************/

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AtributoExcel {

	/**
	 * Tipo de Atributo
	 * 
	 * @return
	 */
	public String objectType() default "";

	/**
	 * Indice de la columna en elk archivo excel
	 * 
	 * @return
	 */
	public int propertyColumnIndex() default 0;

	/**
	 * Indica si un atributo existe o esta en el objeto BPM
	 * 
	 * @return
	 */
	public boolean isMapping() default false;

	public String nombreColumna() default "";
	public String comentario() default "";
	public int columna() default -1;
	public String setMetodo() default "";
	
}
