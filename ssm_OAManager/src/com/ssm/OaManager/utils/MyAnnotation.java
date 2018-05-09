package com.ssm.OaManager.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//调用元注解 设置作用于运行时
@Retention(RetentionPolicy.RUNTIME)
//设置作用位置
@Target(value={ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
public @interface MyAnnotation {
		
		String[] methodNames();
}
