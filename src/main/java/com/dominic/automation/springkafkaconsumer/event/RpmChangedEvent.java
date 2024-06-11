package com.dominic.automation.springkafkaconsumer.event;


import org.springframework.context.ApplicationEvent;


public class RpmChangedEvent extends ApplicationEvent {
    private double rpm;

    public RpmChangedEvent(Object source, double rpm) {
        super(source);
        this.rpm = rpm;
    }

    public double getRpm() {

        return rpm;
    }
}
