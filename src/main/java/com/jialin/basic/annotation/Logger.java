package com.jialin.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : JiaLin
 * @Group : TGB
 * @Date : 2014/6/10
 * @Description :
 */

@Retention(RetentionPolicy.RUNTIME)
@Target( {
        ElementType.FIELD
})
public @interface Logger {
}
