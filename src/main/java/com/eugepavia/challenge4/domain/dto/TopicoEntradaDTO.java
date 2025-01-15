package com.eugepavia.challenge4.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record TopicoEntradaDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        //@NotBlank
        @JsonAlias("autor_id")
        Long autorId,
        @NotBlank
        String curso
) {
}