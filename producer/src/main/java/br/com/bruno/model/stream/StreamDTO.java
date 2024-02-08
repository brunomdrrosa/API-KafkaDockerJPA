package br.com.bruno.model.stream;

import br.com.bruno.model.musicas.MusicasDTO;
import br.com.bruno.model.usuario.UserDTO;
import lombok.Data;

@Data
public class StreamDTO {
    private MusicasDTO musicasDTO;
    private UserDTO userDTO;
}
