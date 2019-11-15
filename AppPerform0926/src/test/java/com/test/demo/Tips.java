package com.test.demo;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target({ElementType.METHOD, ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.TYPE})
public @interface Tips {
	
	// 描述
		String description() default "";

		// 预期风险
		String riskPoint() default "";

		// 触发时机
		String triggerTime() default "";

}
