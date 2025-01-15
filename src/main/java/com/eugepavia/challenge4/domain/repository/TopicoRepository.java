package com.eugepavia.challenge4.domain.repository;

import com.eugepavia.challenge4.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    
    Optional<Topico> findByTitulo(String titulo);

    Optional<Topico> findByMensaje(String mensaje);

}
