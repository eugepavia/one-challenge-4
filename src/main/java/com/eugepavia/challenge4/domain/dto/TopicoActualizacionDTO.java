package com.eugepavia.challenge4.domain.dto;

// import jakarta.validation.constraints.NotBlank;

// Clase DTO para recibir los datos de tópicos a actualizar

public record TopicoActualizacionDTO(
        // @NotBlank(message = "{mensaje.obligatorio}")
        String mensaje,
        // @NotBlank(message = "{status.obligatorio}")
        String status
) {
}
