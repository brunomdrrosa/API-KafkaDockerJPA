package br.com.bruno.controller;

import br.com.bruno.domain.Musicas;
import br.com.bruno.kafka.KafkaProducer;
import br.com.bruno.model.MusicasDTO;
import br.com.bruno.repos.MusicasRepository;
import br.com.bruno.service.MusicasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/musicas", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicasRest {

    private final KafkaProducer kafkaProducer;
    private final MusicasRepository musicasRepository;
    private final MusicasService service;

    @GetMapping
    public ResponseEntity<List<MusicasDTO>> getMusicas() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicasDTO> getMusica(@PathVariable(name = "id") final UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<Musicas> createMusicas(@RequestBody final MusicasDTO musicasDTO) {
        final Musicas musicas = new Musicas();
        mapToEntity(musicasDTO, musicas);
        Musicas musica = musicasRepository.save(musicas);
        kafkaProducer.send("A música " + musica.getTitulo() + " interpretada por " + musica.getArtista() + " foi adicionada no banco de dados.");
        return new ResponseEntity<>(musica, HttpStatus.CREATED);
    }

    private Musicas mapToEntity(final MusicasDTO musicasDTO, final Musicas musicas) {
        musicas.setTitulo(musicasDTO.getTitulo());
        musicas.setArtista(musicasDTO.getArtista());
        musicas.setDuracao(musicasDTO.getDuracao());
        musicas.setAlbum(musicasDTO.getAlbum());
        musicas.setImagemCapa(musicasDTO.getImagemCapa());
        return musicas;
    }
}
