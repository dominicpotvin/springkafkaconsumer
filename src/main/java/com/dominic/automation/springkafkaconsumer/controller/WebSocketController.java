package com.dominic.automation.springkafkaconsumer.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @MessageMapping("/send/message")
    public void handleWebSocketMessage(String message) {
        logger.info("Received message from frontend: " + message);
        // Vous pouvez ajouter une logique supplémentaire ici
    }
}
