package br.com.bruno.controller;

import br.com.bruno.domain.Musicas;
import br.com.bruno.kafka.KafkaProducer;
import br.com.bruno.model.MusicasDTO;
import br.com.bruno.service.MusicasService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.bruno.util.DateUtils.ISO_DATE_TIME_FORMATTER;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/musicas", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicasRest {

    private final KafkaProducer kafkaProducer;
    private final MusicasService service;

    @ApiOperation(value= "Buscar todas as músicas disponíveis no sistema.")
    @GetMapping
    public ResponseEntity<List<MusicasDTO>> getMusicas() {
        kafkaProducer.send("[GET] /musicas --> Requisição recebida as " + LocalDateTime.now().format(ISO_DATE_TIME_FORMATTER));
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation(value= "Buscar uma música por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<MusicasDTO> getMusica(@PathVariable(name = "id") final UUID id) {
        kafkaProducer.send("[GET] /musicas/{id} --> Requisição recebida para buscar música com ID: " + id + " às "
                + LocalDateTime.now().format(ISO_DATE_TIME_FORMATTER));
        return ResponseEntity.ok(service.get(id));
    }

    @ApiOperation(value= "Adicionar uma nova música no sistema.")
    @PostMapping
    public ResponseEntity<Musicas> createMusicas(@RequestBody final MusicasDTO musicasDTO) {
        kafkaProducer.send("[POST] /musicas --> Requisição recebida para adicionar a música " + musicasDTO.getTitulo()
                + " de " + musicasDTO.getArtista() + " às " + LocalDateTime.now().format(ISO_DATE_TIME_FORMATTER));
        final Musicas createdId = service.create(musicasDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @ApiOperation(value= "Atualizar uma música do sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Musicas> updateMusicas(@PathVariable(name = "id") final UUID id,
                                                 @RequestBody final MusicasDTO musicasDTO) {
        kafkaProducer.send("[PUT] /musicas/{id} --> Requisição recebida para atualizar música com ID: " + id + " às "
                + LocalDateTime.now().format(ISO_DATE_TIME_FORMATTER));
        return ResponseEntity.ok(service.update(id, musicasDTO));
    }

    @ApiOperation(value= "Remover uma música do sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusicas(@PathVariable(name = "id") final UUID id) {
        kafkaProducer.send("[DELETE] /musicas/{id} --> Requisição recebida para deletar música com ID: " + id + " às "
                + LocalDateTime.now().format(ISO_DATE_TIME_FORMATTER));
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
