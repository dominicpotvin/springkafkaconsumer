package com.dominic.automation.springkafkaconsumer.transformer;
import com.dominic.automation.springkafkaconsumer.model.SensorData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class SensorDataTransformer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SensorData transform(String message) throws JsonProcessingException {
        return objectMapper.readValue(message, SensorData.class);
    }
}