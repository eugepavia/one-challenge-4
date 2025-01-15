package com.eugepavia.challenge4.domain.controller;

import com.eugepavia.challenge4.domain.dto.TopicoEntradaDTO;
import com.eugepavia.challenge4.domain.dto.TopicoSalidaDTO;
import com.eugepavia.challenge4.domain.model.Topico;
import com.eugepavia.challenge4.domain.model.Usuario;
import com.eugepavia.challenge4.domain.repository.TopicoRepository;
import com.eugepavia.challenge4.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<TopicoSalidaDTO> registraTopico(@RequestBody @Valid TopicoEntradaDTO topicoDTO, UriComponentsBuilder uri) {
        Usuario autor = usuarioRepository.getReferenceById(topicoDTO.autorId());
        Topico topico = new Topico(topicoDTO,autor);
        topicoRepository.save(topico);

        URI url = uri.path("/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        TopicoSalidaDTO retorno = new TopicoSalidaDTO(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());

        return ResponseEntity.created(url).body(retorno);
    }




}
