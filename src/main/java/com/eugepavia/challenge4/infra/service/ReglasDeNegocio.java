package com.eugepavia.challenge4.infra.service;

import com.eugepavia.challenge4.domain.model.Topico;
import com.eugepavia.challenge4.domain.model.Usuario;
import com.eugepavia.challenge4.domain.repository.TopicoRepository;
import com.eugepavia.challenge4.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReglasDeNegocio {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;


    // Revisar si existe ID de usuario
    public Usuario existeUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ValidaDatosException("El ID del autor no existe");
        }
        return usuarioRepository.getReferenceById(id);
    }

    // Revisar si existe ID de tópico
    public Topico existeTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidaDatosException("El ID del tópico no existe");
        }
        return topicoRepository.getReferenceById(id);
    }




}