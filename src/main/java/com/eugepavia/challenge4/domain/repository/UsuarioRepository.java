package com.eugepavia.challenge4.domain.repository;

import com.eugepavia.challenge4.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
