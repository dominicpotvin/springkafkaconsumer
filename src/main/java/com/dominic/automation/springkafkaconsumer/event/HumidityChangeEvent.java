package com.dominic.automation.springkafkaconsumer.event;

import org.springframework.context.ApplicationEvent;

public class HumidityChangeEvent extends ApplicationEvent {
    private double humidity;

    public HumidityChangeEvent(Object source, double humidity) {
        super(source);
        this.humidity = humidity;
    }

    public double getHumidity() {
        return humidity;
    }
}
