package com.maimai.springboot.maimaiaop.bean;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cache {
    int value() default 0;
}
