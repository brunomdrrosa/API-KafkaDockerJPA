package br.com.consumer.kafka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StreamDTO {
    private MusicasDTO musicasDTO;
    private UserDTO userDTO;
}
