// WebSocketService.java
package com.dominic.automation.springkafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WebSocketService {

    // cette class sert à envoyer des messages à un client WebSocket
    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketService(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void sendMessage(String topic, double message) {
        logger.info("Sending message to topic: /topic/" + topic);
        if (Objects.isNull(message)) {
            logger.error("Message is null");
            return;
        }
        template.convertAndSend("/topic/" + topic, message);
        logger.info("Message sent: " + message);
    }

}
