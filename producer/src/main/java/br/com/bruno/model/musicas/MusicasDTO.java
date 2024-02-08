package br.com.bruno.model.musicas;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class MusicasDTO {
    private UUID id;
    @NotNull
    private String titulo;
    @NotNull
    private String artista;
    @NotNull
    private Integer duracao;
    private String album;
    private String imagemCapa;
}
