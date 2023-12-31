package com.example.kafkademo;

import com.example.kafkademo.api.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> template) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                template.send("events", new Message(
                            "Message " + i,
                                LocalDateTime.now())
                                );
            }
        };
    }
}
