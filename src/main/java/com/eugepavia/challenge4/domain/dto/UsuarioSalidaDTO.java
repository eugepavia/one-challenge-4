package com.eugepavia.challenge4.domain.dto;


// Clase DTO para la confirmación del registro de usuarios nuevos

import com.eugepavia.challenge4.domain.model.Usuario;

public record UsuarioSalidaDTO(
        Long id,
        String nombre,
        String email
) {

    public UsuarioSalidaDTO(Usuario usuario) {
        this(usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail());
    }

}
