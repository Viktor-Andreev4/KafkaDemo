package com.example.kafkademo.api;

import java.time.LocalDateTime;

public record Message(
        String message,
        LocalDateTime created) {

}
