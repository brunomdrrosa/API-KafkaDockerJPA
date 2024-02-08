package br.com.bruno.kafka;

import br.com.bruno.model.stream.StreamDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, StreamDTO> kafkaTemplate;

    public void send(StreamDTO message){
        log.info("Mensagem enviada: {}",  message);

        ProducerFactory<String, StreamDTO> producerFactory = kafkaTemplate.getProducerFactory();
        if (producerFactory instanceof DefaultKafkaProducerFactory<String, StreamDTO> defaultProducerFactory) {
            JsonSerializer<StreamDTO> jsonSerializer = new JsonSerializer<>();
            jsonSerializer.setAddTypeInfo(false);
            defaultProducerFactory.setValueSerializer(jsonSerializer);
        }
        kafkaTemplate.send(topicName, message);
    }

}