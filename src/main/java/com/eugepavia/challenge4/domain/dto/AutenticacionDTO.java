package com.eugepavia.challenge4.domain.dto;

import jakarta.validation.constraints.NotNull;

public record AutenticacionDTO(
        @NotNull(message = "Es necesario escribir el nombre de usuario")
        String usuario,
        @NotNull(message = "Es necesario escribir la contraseña")
        String contrasena
) {
}
