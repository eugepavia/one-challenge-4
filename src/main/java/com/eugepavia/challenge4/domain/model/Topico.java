package com.eugepavia.challenge4.domain.model;

import com.eugepavia.challenge4.domain.dto.TopicoEntradaDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topicos")
// @Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private long autorId;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;

    // CONSTRUCTORES
    public Topico(TopicoEntradaDTO topicoDTO) {
        this.titulo = topicoDTO.titulo();
        this.mensaje = topicoDTO.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.SIN_RESOLVER;
        this.autorId = topicoDTO.autorId();
    }

    // GETTERS


    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Status getStatus() {
        return status;
    }

    public long getAutorId() {
        return autorId;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
}
