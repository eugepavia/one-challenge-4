package com.eugepavia.challenge4.domain.dto;

import jakarta.validation.constraints.NotNull;

// Clase DTO para recibir los datos de usuario en el login

public record AutenticacionDTO(
        @NotNull(message = "Es necesario escribir el nombre de usuario")
        String usuario,
        @NotNull(message = "Es necesario escribir la contraseña")
        String contrasena
) {
}
