package br.com.bruno.controller;

import br.com.bruno.domain.Musicas;
import br.com.bruno.model.musicas.MusicasDTO;
import br.com.bruno.service.MusicasService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/musicas", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicasRest {

    private final MusicasService service;

    @ApiOperation(value= "Buscar todas as músicas disponíveis no sistema.")
    @GetMapping
    public ResponseEntity<List<MusicasDTO>> getMusicas() {
        return ResponseEntity.ok(service.buscarTodasMusicas());
    }

    @ApiOperation(value= "Buscar uma música por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<MusicasDTO> getMusica(@PathVariable(name = "id") final UUID id) {
        return ResponseEntity.ok(service.buscarMusicaPorId(id));
    }

    @ApiOperation(value= "Adicionar uma nova música no sistema.")
    @PostMapping
    public ResponseEntity<Musicas> createMusicas(@RequestBody final MusicasDTO musicasDTO) {
        return new ResponseEntity<>(service.salvarMusica(musicasDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value= "Atualizar uma música do sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Musicas> updateMusicas(@PathVariable(name = "id") final UUID id,
                                                 @RequestBody final MusicasDTO musicasDTO) {
        return ResponseEntity.ok(service.atualizarMusica(id, musicasDTO));
    }

    @ApiOperation(value= "Remover uma música do sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusicas(@PathVariable(name = "id") final UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
