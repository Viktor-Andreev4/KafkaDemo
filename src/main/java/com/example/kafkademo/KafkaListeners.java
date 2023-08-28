package com.example.kafkademo;

import com.example.kafkademo.api.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "events",
            groupId = "events-consumer",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Received message: " + data);
    }
}
