package com.eugepavia.challenge4.domain.dto;

import com.eugepavia.challenge4.domain.model.Topico;

import java.time.LocalDateTime;

public record TopicoDetallesDTO(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {

    public TopicoDetallesDTO(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus().getStatusCompleto(),
                topico.getAutor().getNombre(),
                topico.getCurso().getTituloCompleto());
    }


}
