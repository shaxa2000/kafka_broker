package com.example.kafka.kafka.producer;

import com.example.kafka.model.Dto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Dto> kafkaTemplate;

    public void send(Dto message){
        kafkaTemplate.send(topicName, message);
        log.info("Message: '{}', has send to the topic: {}", message, topicName);
    }
}
