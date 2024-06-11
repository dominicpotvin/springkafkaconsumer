package com.dominic.automation.springkafkaconsumer.model;

public class SensorData {
    private double rpm;
    private double temperature;
    private double humidity;

    // Constructeur par défaut nécessaire pour la désérialisation
    public SensorData() {}

    // Constructeur avec tous les paramètres, utilisé pour l'initialisation
    public SensorData(double rpm, double temperature, double humidity) {
        this.rpm = rpm;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // Getters et setters
    public double getRpm() {
        return rpm;
    }
    public void setRpm(double rpm) {
        this.rpm = rpm;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getHumidity() {
        return humidity;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
