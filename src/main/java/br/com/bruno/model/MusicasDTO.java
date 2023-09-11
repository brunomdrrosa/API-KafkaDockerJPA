package br.com.bruno.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
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
