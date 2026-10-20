package com.eugepavia.challenge4.domain.controller;

// Clase Controller para el registro de usuarios nuevos

import com.eugepavia.challenge4.domain.dto.RegistroUsuarioDTO;
import com.eugepavia.challenge4.domain.dto.UsuarioSalidaDTO;
import com.eugepavia.challenge4.domain.model.Usuario;
import com.eugepavia.challenge4.domain.repository.UsuarioRepository;
import com.eugepavia.challenge4.infra.service.ReglasDeNegocio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ReglasDeNegocio revision;

    @PostMapping
    public ResponseEntity<UsuarioSalidaDTO> registrarUsuario(@RequestBody @Valid RegistroUsuarioDTO dto) {
        revision.usuarioDuplicado(dto.nombre(),  dto.email());
        var contrasenaCodificada = passwordEncoder.encode(dto.contrasena());
        var usuario = usuarioRepository.save(new Usuario(dto, contrasenaCodificada));
        return ResponseEntity.status(HttpStatus.CREATED).body(new  UsuarioSalidaDTO(usuario));
    }

}
