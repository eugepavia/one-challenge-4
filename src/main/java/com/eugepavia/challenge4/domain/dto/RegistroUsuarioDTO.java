package com.eugepavia.challenge4.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Clase DTO para el registro de usuarios nuevos

public record RegistroUsuarioDTO(
        @NotBlank(message = "Es necesario escribir el nombre de usuario")
        @Size(max = 100, message = "El nombre de usuario no puede exceder 100 caracteres")
        String nombre,
        @NotBlank(message = "Es necesario escribir el correo electrónico")
        @Email(message = "El formato del correo electrónico no es válido")
        @Size(max = 100, message = "El correo no puede exceder 100 caracteres")
        String email,
        @NotBlank(message = "Es necesario escribir la contraseña")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String contrasena
) {
}
