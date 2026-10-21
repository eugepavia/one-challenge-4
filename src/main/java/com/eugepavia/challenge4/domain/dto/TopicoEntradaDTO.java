package com.eugepavia.challenge4.domain.dto;

import jakarta.validation.constraints.NotBlank;

// Clase DTO para el registro de tópicos nuevos

public record TopicoEntradaDTO(
        @NotBlank(message = "{titulo.obligatorio}")
        String titulo,
        @NotBlank(message = "{mensaje.obligatorio}")
        String mensaje,
        @NotBlank(message = "{curso.obligatorio}")
        String curso
) {
}