package com.eugepavia.challenge4.infra.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eugepavia.challenge4.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

// Servicios relacionados con la generación y validación de tokens

@Service
public class TokenService {

    @Value("${api.security.secret}")  // Configurar variable de entorno
    private String apiSecret;
    @Value("${token.expiration}")  // Configurar variable de entorno
    private Long tokenExpiration;

    // Método para generar tokens
    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            String token = JWT.create()
                    .withIssuer("Foro Hub")
                    .withSubject(usuario.getNombre())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(generaFechaExpiracion())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Problema al generar token");
        }
    }

    // Método para verificar que el usuario tenga la sesión iniciada
    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("Token null");
        }

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("Foro Hub")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }

        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verifier inválido");
        }
        return verifier.getSubject();

    }

    // Método para validar tokens
    public String verificaToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("Foro Hub")
                    .build()
                    .verify(token);
            return verifier.getSubject();
        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }
        return null;
    }

    // Tiempo de expiración de tokens
    private Instant generaFechaExpiracion() {
        return LocalDateTime.now().plusHours(tokenExpiration).toInstant(ZoneOffset.of("-06:00"));
    }



}

