package com.qualcomm.ftcrobotcontroller.opmodes;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by "M" on 2015.12.05
 */

public class MainBotAutoBeta extends LinearOpMode {
    DcMotor motorRR;
    DcMotor motorRL;
    DcMotor spooleo; //Pun on Romeo, spool motor
    Servo   bxServo; //"o"


    ColorSensor cSensor;
    float[] hsvOf(ColorSensor sensor) {
        float converted[] = {};
        Color.RGBToHSV(sensor.red() * 8, sensor.green() * 8, sensor.blue() * 8, converted);
        return converted;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        bxServo = hardwareMap.servo      .get("BoxServo"   );
        motorRL = hardwareMap.dcMotor    .get("RearLeft"   );
        motorRR = hardwareMap.dcMotor    .get("RearRight"  );
        spooleo = hardwareMap.dcMotor    .get("RearSpool"  );
        cSensor = hardwareMap.colorSensor.get("ColorSensor");

        cSensor.enableLed(true);
        waitForStart();
        hsvOf(cSensor);
        // turn off the LED.
        cSensor.enableLed(false);
    }
}

