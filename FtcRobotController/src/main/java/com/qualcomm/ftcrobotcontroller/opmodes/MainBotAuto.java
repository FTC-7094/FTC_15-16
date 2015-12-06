package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by "M" on 2015.12.05
 */

public class MainBotAuto extends LinearOpMode {
    Servo   bxServo;
    DcMotor motorRR;
    DcMotor motorRL;
    DcMotor spooleo;

    @Override
    public void runOpMode() throws InterruptedException {
        bxServo = hardwareMap.servo  .get("BoxServo");
        motorRL = hardwareMap.dcMotor.get("RearLeft"   );
        motorRR = hardwareMap.dcMotor.get("RearRight"  );
        spooleo = hardwareMap.dcMotor.get("RearSpool"  );


        waitForStart();
        //start moving straight forward
        motorRL.setPower(0.75);
        motorRR.setPower(0.75);
        sleep(3000); //keep going straight
        motorRL.setPower(0.00); //start turning right
        sleep(500); //keep turning for half second
        motorRR.setPower(0.75); //start going straight
        sleep(2500); //keep going straight
        motorRR.setPower(0.00); //stop moving
        motorRL.setPower(0.00);
        spooleo.setPower(0.50); //start to raise box
        sleep(700); //keep raising box
        spooleo.setPower(0.00); //stop raising box
        bxServo.setPosition(1); //open box
    }
}

