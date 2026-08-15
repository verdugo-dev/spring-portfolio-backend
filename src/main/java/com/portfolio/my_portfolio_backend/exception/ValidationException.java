package com.portfolio.my_portfolio_backend.exception;

import java.util.Set;

import jakarta.validation.ConstraintViolation;

public class ValidationException extends RuntimeException {

    private final Set<? extends ConstraintViolation<?>> violations;

    public ValidationException(Set<? extends ConstraintViolation<?>> violations) {
        super("Error de validacion: se encontraron " + violations.size());
        this.violations = violations;
    }

    public Set<? extends ConstraintViolation<?>> getViolations() {
        return violations;
    }
    
}
