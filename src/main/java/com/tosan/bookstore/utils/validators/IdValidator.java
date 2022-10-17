package com.tosan.bookstore.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class IdValidator implements ConstraintValidator<Identity, Long> {
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value >= 0;
    }
}