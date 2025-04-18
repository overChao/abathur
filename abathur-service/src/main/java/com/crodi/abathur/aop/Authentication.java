package com.crodi.abathur.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Crodi
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Authentication {

	/**
	 * 是否放行 默认不放行
	 * @return boolean
	 */
	boolean pass() default false;

}
