package consumer.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer2Service {
    @KafkaListener(
            topics = "${kafka.topic.produtor2}",
            groupId = "group2",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset){
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }
}
