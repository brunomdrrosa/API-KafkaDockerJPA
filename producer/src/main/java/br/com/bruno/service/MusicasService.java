package br.com.bruno.service;

import br.com.bruno.domain.Musicas;
import br.com.bruno.model.musicas.MusicasDTO;
import br.com.bruno.repos.MusicasRepository;
import br.com.bruno.util.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class MusicasService {

    private final MusicasRepository musicasRepository;

    public List<MusicasDTO> buscarTodasMusicas() {
        final List<Musicas> musicass = musicasRepository.findAll(Sort.by("artista"));
        return musicass.stream()
                .map(musicas -> mapToDTO(musicas, new MusicasDTO()))
                .toList();
    }

    public MusicasDTO buscarMusicaPorId(final UUID id) {
        return musicasRepository.findById(id)
                .map(musicas -> mapToDTO(musicas, new MusicasDTO()))
                .orElseThrow(() -> new NotFoundException("Música não encontrada para o ID: " + id));
    }

    public Musicas salvarMusica(final MusicasDTO musicasDTO) {
        final Musicas musicas = new Musicas();
        mapToEntity(musicasDTO, musicas);
        return musicasRepository.save(musicas);
    }

    public Musicas atualizarMusica(final UUID id, final MusicasDTO musicasDTO) {
        final Musicas musicas = musicasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Música não encontrada para o ID: " + id));
        mapToEntity(musicasDTO, musicas);
        return musicasRepository.save(musicas);
    }

    public void delete(final UUID id) {
        musicasRepository.deleteById(id);
    }

    private MusicasDTO mapToDTO(final Musicas musicas, final MusicasDTO musicasDTO) {
        musicasDTO.setId(musicas.getId());
        musicasDTO.setTitulo(musicas.getTitulo());
        musicasDTO.setArtista(musicas.getArtista());
        musicasDTO.setDuracao(musicas.getDuracao());
        musicasDTO.setAlbum(musicas.getAlbum());
        musicasDTO.setImagemCapa(musicas.getImagemCapa());
        return musicasDTO;
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
