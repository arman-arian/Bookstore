package com.tosan.bookstore.utils.enums;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface EnumDescription {
    String value() default "";
}
