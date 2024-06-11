package com.dominic.automation.springkafkaconsumer.model;

import com.dominic.automation.springkafkaconsumer.event.HumidityChangeEvent;
import com.dominic.automation.springkafkaconsumer.event.RpmChangedEvent;
import com.dominic.automation.springkafkaconsumer.event.TemperatureChangeEvent;
import com.dominic.automation.springkafkaconsumer.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class SensorDataHandler {
    private SensorData sensorData;
    private ApplicationService applicationService;
    private ApplicationEventPublisher eventPublisher;

    private static final Logger logger = LoggerFactory.getLogger(SensorDataHandler.class);

    @Autowired
    public SensorDataHandler(ApplicationService applicationService, ApplicationEventPublisher eventPublisher) {
        this.applicationService = applicationService;
        this.eventPublisher = eventPublisher;
        this.sensorData = new SensorData(); // Initialise avec des valeurs par défaut ou injectez-les si nécessaire
    }


    private void setRpm(double rpm) {
        if (Double.compare(sensorData.getRpm(), rpm) != 0.0) {
            logger.info("Changement de RPM détecté: ancien = " + sensorData.getRpm() + ", nouveau = " + rpm);
            sensorData.setRpm(rpm);
            eventPublisher.publishEvent(new RpmChangedEvent(this, rpm));
        } else {
            logger.info("Aucun changement de RPM: " + rpm);
        }
    }
    private void setTemperature(double temperature) {
        if (Double.compare(sensorData.getTemperature(), temperature) != 0.0) {
            logger.info("Aucun changement de température: " + temperature);
            sensorData.setTemperature(temperature);
            eventPublisher.publishEvent(new TemperatureChangeEvent(this, temperature));
        } else {
            logger.info("Aucun changement de température: " + temperature);
        }
    }
    private void setHumidity(double humidity) {
        if (Double.compare(sensorData.getHumidity(), humidity) != 0.0) {
            logger.info("Changement d'humidité détecté: ancien = " + sensorData.getHumidity() + ", nouveau = " + humidity);
            sensorData.setHumidity(humidity);
            eventPublisher.publishEvent(new HumidityChangeEvent(this, humidity));
        } else {
            logger.info("Aucun changement d'humidité: " + humidity);
        }
    }
}
