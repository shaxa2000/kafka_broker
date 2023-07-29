package com.example.kafka.controller;

import com.example.kafka.model.Dto;
import com.example.kafka.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageController {
    private final KafkaProducer kafkaProducer;

    @GetMapping("send/{message}")
    public void sendKafkaMessage(@PathVariable String message) {

        kafkaProducer.send(Dto.builder()
                .name("dto")
                .payload(message)
                .build());
    }
}
