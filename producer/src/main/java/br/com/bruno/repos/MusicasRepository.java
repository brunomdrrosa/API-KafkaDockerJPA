package br.com.bruno.repos;

import br.com.bruno.domain.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MusicasRepository extends JpaRepository<Musicas, UUID> {
}
