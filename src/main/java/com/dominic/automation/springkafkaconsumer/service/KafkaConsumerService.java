package com.dominic.automation.springkafkaconsumer.service;

import com.dominic.automation.springkafkaconsumer.event.HumidityChangeEvent;
import com.dominic.automation.springkafkaconsumer.event.RpmChangedEvent;
import com.dominic.automation.springkafkaconsumer.event.TemperatureChangeEvent;
import com.dominic.automation.springkafkaconsumer.model.SensorData;
import com.dominic.automation.springkafkaconsumer.transformer.SensorDataTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final SensorDataTransformer sensorDataTransformer;
    private final ApplicationService applicationService; // Injection de GlobalVariables

    @Autowired
    public KafkaConsumerService(ApplicationService applicationService) { // Mise à jour du constructeur
        this.sensorDataTransformer = new SensorDataTransformer();
        this.applicationService = applicationService;
    }

    @KafkaListener(topics = "sendMockDataRPM", groupId = "group-id")
    public void consumeMessage(String message) {
        try {
            SensorData sensorData = sensorDataTransformer.transform(message);
            System.out.println("data input from kafka: " + message);
            double rpm = sensorData.getRpm();
            applicationService.handleRpmChanged(new RpmChangedEvent(this, rpm));
            double temperature = sensorData.getTemperature();
            applicationService.handleTempChanged(new TemperatureChangeEvent(this, temperature));
            double humidity = sensorData.getHumidity();
            applicationService.handleHumidityChanged(new HumidityChangeEvent(this, humidity));


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
