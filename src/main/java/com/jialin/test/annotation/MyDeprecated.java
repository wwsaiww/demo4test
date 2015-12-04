package com.jialin.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : JiaLin
 * @Group : TGB
 * @Date : 2014/6/9
 * @Description :
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDeprecated {
    public String description() default "Warning:This method is Deprecated!";
}






