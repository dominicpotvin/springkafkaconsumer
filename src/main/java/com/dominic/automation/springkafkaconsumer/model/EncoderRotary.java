package com.dominic.automation.springkafkaconsumer.model;

import lombok.Data;

@Data
public class EncoderRotary {
    private double rpm;
    private double angle;
    private double steps;
    private double direction;
    private double speed;
    private double acceleration;
    private double deceleration;
    private double torque;
    private double current;
    private double voltage;
    private double power;

    public EncoderRotary() {
    }
}

