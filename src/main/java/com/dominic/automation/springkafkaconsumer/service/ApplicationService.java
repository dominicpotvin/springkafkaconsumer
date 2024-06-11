// ApplicationService.java
package com.dominic.automation.springkafkaconsumer.service;

import com.dominic.automation.springkafkaconsumer.event.HumidityChangeEvent;
import com.dominic.automation.springkafkaconsumer.event.RpmChangedEvent;
import com.dominic.automation.springkafkaconsumer.event.TemperatureChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private double rpm;
    private double temperature;
    private double humidity;
    private final WebSocketService webSocketService;

    public ApplicationService(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @EventListener
    public void handleRpmChanged(RpmChangedEvent event) {
        this.rpm = event.getRpm();
        // Préfixe ajouté ici
        webSocketService.sendMessage("rpm", this.rpm);
    }

    @EventListener
    public void handleTempChanged(TemperatureChangeEvent event) {
        this.temperature = event.getTemperature();
        // Préfixe ajouté ici
        webSocketService.sendMessage("temperature", this.temperature);
    }

    @EventListener
    public void handleHumidityChanged(HumidityChangeEvent event) {
        this.humidity = event.getHumidity();
        // Préfixe ajouté ici
        webSocketService.sendMessage("humidity", this.humidity);
    }
}