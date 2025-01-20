package com.eugepavia.challenge4.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

// Clase DTO para la confirmación del registro de tópicos nuevos

public record TopicoSalidaDTO(
        String titulo,
        String mensaje,
        @JsonAlias("fecha_creacion")
        LocalDateTime fechaCreacion
) {
}
