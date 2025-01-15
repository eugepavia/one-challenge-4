package com.eugepavia.challenge4.infra.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.UnexpectedTypeException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    // Para request no encontradas
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    // Para errores en la entrada del usuario
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(DatosError400::new).toList();;
        return ResponseEntity.badRequest().body(errores);
    }

    // Para errores en general con la validación de datos
    @ExceptionHandler(ValidaDatosException.class)
    public ResponseEntity errorValidacion(ValidaDatosException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    // DTO para formato de error 400
    private record DatosError400(String campo, String error) {
        public DatosError400(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }


}
