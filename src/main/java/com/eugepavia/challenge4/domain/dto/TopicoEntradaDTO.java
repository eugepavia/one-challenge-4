package com.eugepavia.challenge4.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Clase DTO para el registro de tópicos nuevos

public record TopicoEntradaDTO(
        @NotBlank(message = "{titulo.obligatorio}")
        String titulo,
        @NotBlank(message = "{mensaje.obligatorio}")
        String mensaje,
        @NotNull(message = "{autor.obligatorio}")
        @JsonAlias("autor_id")
        Long autorId,
        @NotBlank(message = "{curso.obligatorio}")
        String curso
) {
}