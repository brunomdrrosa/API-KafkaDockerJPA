package br.com.consumer.kafka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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