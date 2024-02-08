package br.com.bruno.controller;

import br.com.bruno.kafka.KafkaProducer;
import br.com.bruno.model.stream.StreamDTO;
import br.com.bruno.model.musicas.MusicasDTO;
import br.com.bruno.model.usuario.UserDTO;
import br.com.bruno.service.MusicasService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/streams", produces = MediaType.APPLICATION_JSON_VALUE)
public class StreamsRest {

    private final KafkaProducer kafkaProducer;
    private final MusicasService musicasService;

    @ApiOperation(value = "Adicionar uma música como ouvida para o usuário.")
    @PostMapping("/{id}")
    public ResponseEntity<MusicasDTO> addStream(@PathVariable("id") UUID id,
                                                @RequestBody final UserDTO userDTO) {
        MusicasDTO musica = musicasService.buscarMusicaPorId(id);
        StreamDTO streamDTO = new StreamDTO();
        streamDTO.setMusicasDTO(musica);
        streamDTO.setUserDTO(userDTO);

        kafkaProducer.send(streamDTO);

        return new ResponseEntity<>(musica, HttpStatus.OK);
    }

}
