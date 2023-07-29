package com.example.kafka.kafka.consumer;

import com.example.kafka.model.Dto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenTopic(ConsumerRecord<String, Dto> payload) {
        log.info("value: {}", payload.value());
    }
}
