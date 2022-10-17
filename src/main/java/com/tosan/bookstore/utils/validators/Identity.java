package com.tosan.bookstore.utils.validators;

//public final class IdValidator {
//    public static boolean Validate(Long id) {
//        return id >= 0;
//    }
//}

import com.tosan.bookstore.exceptions.BookStoreFaults;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = IdValidator.class)
@Documented
public @interface Identity {
    //String message() default "{IpAddress.invalid}";

    BookStoreFaults msg();

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}