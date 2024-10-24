package org.hl.springlearn.aopdemo.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author houlei
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    String desc() default "";
}

