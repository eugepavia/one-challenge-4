package com.eugepavia.challenge4.domain.repository;

import com.eugepavia.challenge4.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

// Interfaz para Derived Queries en la base de datos MySQL
// Consulta a la tabla "usuarios"

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByNombre(String username);

}
