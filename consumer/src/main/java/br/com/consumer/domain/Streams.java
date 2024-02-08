package br.com.consumer.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Streams {

    @Id
    @Type(type = "uuid-char")
    @Column(nullable = false, updatable = false, columnDefinition = "char(36)")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime horario;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String musica;
    @Column(nullable = false)
    private String artista;
    private String album;
    @Column(nullable = false)
    private int duracao;
}
