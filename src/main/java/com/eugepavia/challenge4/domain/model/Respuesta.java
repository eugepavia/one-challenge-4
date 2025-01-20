package com.eugepavia.challenge4.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

// Clase modelo para los objetos Respuesta

@Entity
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDateTime fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
}
