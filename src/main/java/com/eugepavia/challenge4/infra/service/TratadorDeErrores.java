package com.eugepavia.challenge4.infra.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Clase para tratar los errores y estados de respuesta HTTP

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

    // Para usuario/contraseña inválidos
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity error403LoginInvalido() {
        return ResponseEntity.badRequest().body("El usuario y/o la contraseña no se encuentran registrados");
    }

    // Para permisos inválidos
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity error403PermisoInvalido() {
        return ResponseEntity.badRequest().body("No se tienen los permisos necesarios para realizar esta acción");
    }

    // DTO para formato de error 400
    private record DatosError400(String campo, String error) {
        public DatosError400(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }


}
