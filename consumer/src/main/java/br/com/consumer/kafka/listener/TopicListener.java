package br.com.consumer.kafka.listener;

import br.com.consumer.kafka.dto.StreamDTO;
import br.com.consumer.service.StreamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

    @Value("${topic.name.consumer}")
    private String topicName;

    private final StreamService streamService;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(@Payload StreamDTO payload){
        log.info("{} recebeu uma nova reprodução do usuário {}.", payload.getMusicasDTO().getArtista(), payload.getUserDTO().getNomeUsuario());
        streamService.create(payload);
    }

}