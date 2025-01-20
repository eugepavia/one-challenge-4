package com.eugepavia.challenge4.infra.service;

// Error para la validación de datos

public class ValidaDatosException extends RuntimeException {
    public ValidaDatosException(String message) {
        super(message);
    }
}
