package com.dominic.automation.springkafkaconsumer.event;

import org.springframework.context.ApplicationEvent;

public class TemperatureChangeEvent extends ApplicationEvent {
    private double temperature;

    public TemperatureChangeEvent(Object source, double temperature) {
        super(source);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}
