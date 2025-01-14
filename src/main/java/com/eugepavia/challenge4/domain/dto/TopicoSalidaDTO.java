package com.eugepavia.challenge4.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record TopicoSalidaDTO(
        String titulo,
        String mensaje,
        @JsonAlias("fecha_creacion")
        LocalDateTime fechaCreacion
) {
}
