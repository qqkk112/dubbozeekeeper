package com.reger.test.annotation;


import java.lang.annotation.*;

/**
 * 打印方法入参
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PrintParam {
}
