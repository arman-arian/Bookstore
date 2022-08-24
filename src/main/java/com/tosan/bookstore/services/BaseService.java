package com.tosan.bookstore.services;

import com.tosan.bookstore.exceptions.GeneralException;
import jakarta.validation.*;

import java.util.Set;

public abstract class BaseService {
    protected <T> void ValidateInputs(T obj) {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            var hasError = false;
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(obj);

            StringBuilder errors = new StringBuilder();
            for (ConstraintViolation<T> violation : violations) {
                errors.append(violation.getMessage());
                hasError = true;
            }

            if (hasError) {
                throw new GeneralException("0000", errors.toString());
            }
        } catch (Exception ex) {
            throw new GeneralException("0001", "ValidateInputs Error", ex);
        }
    }
}
