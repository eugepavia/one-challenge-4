package com.eugepavia.challenge4.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoActualizacionDTO(
        @NotBlank
        String mensaje,
        @NotBlank
        String status
) {
}
