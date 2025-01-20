package com.eugepavia.challenge4.domain.repository;

import com.eugepavia.challenge4.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interfaz para Derived Queries en la base de datos MySQL
// Consulta a la tabla "topicos"

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    
    Optional<Topico> findByTitulo(String titulo);

    Optional<Topico> findByMensaje(String mensaje);

}
