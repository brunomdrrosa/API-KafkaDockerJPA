package br.com.consumer.service;

import br.com.consumer.kafka.dto.StreamDTO;
import br.com.consumer.domain.Streams;
import br.com.consumer.repos.StreamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class StreamService {

    private final StreamRepository repository;

    public void create(StreamDTO informacoes) {
        Streams streams = mapToEntity(informacoes);
        repository.save(streams);
    }

    private Streams mapToEntity(StreamDTO informacoes) {
        Streams streams = new Streams();

        streams.setAlbum(informacoes.getMusicasDTO().getAlbum());
        streams.setArtista(informacoes.getMusicasDTO().getArtista());
        streams.setDuracao(informacoes.getMusicasDTO().getDuracao());
        streams.setMusica(informacoes.getMusicasDTO().getTitulo());
        streams.setUsuario(informacoes.getUserDTO().getNomeUsuario());
        streams.setHorario(LocalDateTime.now());
        return streams;
    }
}
