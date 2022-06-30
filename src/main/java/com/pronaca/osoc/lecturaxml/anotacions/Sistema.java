package com.pronaca.osoc.lecturaxml.anotacions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Sistema {

	public String sistema() default "";

	public boolean activoCarga() default true;

	public String dataSourceName() default "jdbc/b2b";

}
