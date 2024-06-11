package com.dominic.automation.springkafkaconsumer.model;

import lombok.Data;

@Data
public class MotorSystem {
    private StepMotor stepMotor;
    private EncoderRotary encoderRotary;

    public MotorSystem() {
        this.stepMotor = new StepMotor();
        this.encoderRotary = new EncoderRotary();
    }

    public MotorSystem(StepMotor stepMotor, EncoderRotary encoderRotary) {
        this.stepMotor = stepMotor;
        this.encoderRotary = encoderRotary;
    }

    // Méthode pour synchroniser les données, si nécessaire
    public void synchronizeData() {
        // Exemple de synchronisation: angle de l'encodeur avec l'angle du moteur
        this.encoderRotary.setAngle(this.stepMotor.getAngle());
    }
}
