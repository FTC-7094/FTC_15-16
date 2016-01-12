package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by "M" on 2015.12.05
 */

public class MainBotAutoBlue extends LinearOpMode {
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
        sleep(100001);
        //start moving straight forward
        motorFL.setPower(0.75);
        motorFR.setPower(0.75);
        sleep(1500); //keep going straight
        motorFR.setPower(0.00); //start turning right
        sleep(500); //keep turning for half second
        motorFL.setPower(0.75); //start going straight
        sleep(4750); //keep going straight -- make less, so we shoot out at an angle
        motorFR.setPower(0.00); //stop moving
        motorFL.setPower(0.00);
        spooleo.setPower(0.50); //start to raise box
        sleep(700); //keep raising box
        spooleo.setPower(0.00); //stop raising box
        bxServo.setPosition(0); //open box
    }
}

