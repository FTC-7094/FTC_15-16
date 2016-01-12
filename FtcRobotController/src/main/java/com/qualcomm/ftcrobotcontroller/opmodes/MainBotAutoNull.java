package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by "M" on 2015.12.05
 */

public class MainBotAutoNull extends LinearOpMode {
    Servo   bxServo;
    DcMotor motorFR;
    DcMotor motorFL;
    DcMotor spooleo;

    @Override
    public void runOpMode() throws InterruptedException {
        bxServo = hardwareMap.servo  .get("BoxServo"  );
        motorFL = hardwareMap.dcMotor.get("FrontLeft" );
        motorFR = hardwareMap.dcMotor.get("FrontRight");
        spooleo = hardwareMap.dcMotor.get("RearSpool" );
        bxServo.setPosition(1);

        waitForStart();
        sleep(10000);
        //start moving straight forward
        motorFL.setPower(0.75);
        motorFR.setPower(0.75);
        sleep(5000); //keep going straight
        motorFL.setPower(0.00); //stop moving
        motorFR.setPower(0.00);
    }
}

