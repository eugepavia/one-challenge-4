package com.eugepavia.challenge4.domain.controller;

import com.eugepavia.challenge4.domain.dto.AutenticacionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AutenticacionDTO dto) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dto.usuario(),dto.contrasena());
        var usuarioAutenticado = manager.authenticate(authToken);
        // var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        // return ResponseEntity.ok(JWTtoken);
        return ResponseEntity.ok().build();
    }



}
