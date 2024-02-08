package br.com.consumer.repos;

import br.com.consumer.domain.Streams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StreamRepository extends JpaRepository<Streams, UUID> {
}
