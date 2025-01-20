package com.eugepavia.challenge4.domain.controller;

import com.eugepavia.challenge4.domain.dto.TopicoActualizacionDTO;
import com.eugepavia.challenge4.domain.dto.TopicoDetallesDTO;
import com.eugepavia.challenge4.domain.dto.TopicoEntradaDTO;
import com.eugepavia.challenge4.domain.dto.TopicoSalidaDTO;
import com.eugepavia.challenge4.domain.model.Topico;
import com.eugepavia.challenge4.domain.repository.TopicoRepository;
import com.eugepavia.challenge4.domain.repository.UsuarioRepository;
import com.eugepavia.challenge4.infra.service.ReglasDeNegocio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// Clase Controller para las requests relacionadas con los tópicos

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReglasDeNegocio revision;

    // Registra tópico nuevo
    @PostMapping
    public ResponseEntity<TopicoSalidaDTO> registraTopico(@RequestBody @Valid TopicoEntradaDTO topicoDTO, UriComponentsBuilder uri) {
        var autor = revision.existeUsuario(topicoDTO.autorId());
        Topico topico = new Topico(topicoDTO,autor);
        revision.topicoDuplicado(topico);
        topicoRepository.save(topico);

        URI url = uri.path("/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        TopicoSalidaDTO retorno = new TopicoSalidaDTO(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());

        return ResponseEntity.created(url).body(retorno);
    }

    // Consulta lista de todos los tópicos
    @GetMapping
    public ResponseEntity<Page<TopicoDetallesDTO>> listaTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
            var pagina = topicoRepository.findAll(paginacion).map(TopicoDetallesDTO::new);
        return ResponseEntity.ok(pagina);
    }

    // Consulta tópico específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetallesDTO> consultaTopico(@PathVariable Long id) {
        var topico = revision.existeTopico(id);
        return ResponseEntity.ok(new TopicoDetallesDTO(topico));
    }

    // Actualiza tópico específico por ID
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDetallesDTO> actualizaTopico(@RequestBody @Valid TopicoActualizacionDTO topicoDTO, @PathVariable Long id) {
        var topico = revision.existeTopico(id);
        topico.actualizaDatos(topicoDTO);
        return ResponseEntity.ok(new TopicoDetallesDTO(topico));
    }

    // Elimina tópico específico por ID
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaTopico(@PathVariable Long id) {
        revision.existeTopico(id);
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
