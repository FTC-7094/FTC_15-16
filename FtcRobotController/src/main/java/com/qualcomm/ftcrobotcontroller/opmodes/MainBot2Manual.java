package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by "NN" on 2015.10.31
 */

public class MainBot2Manual extends OpMode {
    float powerScale (float initialPower, boolean modifier) //Nonlinear scaling from PushBotHardware
    {
        // Remove illegal powers.
        float legalPower = Range.clip (initialPower, -1, 1);

        float[] scale = {
                0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f,
                0.18f, 0.24f, 0.30f, 0.36f, 0.43f, 0.50f,
                0.60f, 0.72f, 0.85f, 1.00f, 1.00f
        };

        // Get the corresponding index for the legalised power.
        int indexValue = (int)(legalPower * 16.0);
        if (indexValue < 0) { indexValue = -indexValue; }

        //Scale and return power.
        float finalPower;
        if (legalPower < 0) { finalPower = -scale[indexValue]; }
        else { finalPower = scale[indexValue]; }
        //Doubles speed if boolean modifier is true
        if (modifier) { return finalPower; }
        else { return finalPower / 2; }
    }

    DcMotor driveR; //Motors for the drive system
    DcMotor driveL;
    DcMotor hingeA; //Tandem hang angle (hangle) motors
    DcMotor hingeB;
    DcMotor rotorA; //Tandem tape rotor motors
    DcMotor rotorB;
    Servo   climbR; //Climber hitting servos
    Servo   climbL;

    public MainBot2Manual(){}

    @Override public void init() {
        //initialize servo and motors
        climbL = hardwareMap.servo  .get("ClimbL");
        climbR = hardwareMap.servo  .get("ClimbR");
        rotorA = hardwareMap.dcMotor.get("RotorA");
        rotorB = hardwareMap.dcMotor.get("RotorB");
        driveL = hardwareMap.dcMotor.get("DriveL");
        driveR = hardwareMap.dcMotor.get("DriveR");
        hingeA = hardwareMap.dcMotor.get("HingeA");
        hingeB = hardwareMap.dcMotor.get("HingeB");
        //reverse opposite direction motors
        driveL.setDirection(DcMotor.Direction.REVERSE);
        hingeA.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override public void loop() {
        //Digital controlled section
        if      (gamepad2.left_bumper ) { hingeA.setPower( 0.2); hingeB.setPower( 0.2); }
        else if (gamepad2.right_bumper) { hingeA.setPower(-0.2); hingeB.setPower(-0.2); }
        else /*Neither bumper pressed*/ { hingeA.setPower( 0.0); hingeB.setPower( 0.0); }
        if (gamepad2.a) { climbL.setPosition( 0.5); }
        else            { climbL.setPosition( 0.0); }
        if (gamepad2.b) { climbR.setPosition( 0.5); }
        else            { climbR.setPosition( 1.0); }

        //Analog controlled power definition section
        double drivePL = powerScale( gamepad1.left_stick_y, gamepad1.right_bumper );
        double drivePR = powerScale( gamepad1.right_stick_y,gamepad1.right_bumper );
        double rotorPw = ( gamepad2.left_trigger - gamepad2.right_trigger ) * 0.500;

        //Analog controlled section
        driveL.setPower(drivePL);
        driveR.setPower(drivePR);
        rotorA.setPower(rotorPw);
        rotorB.setPower(rotorPw);

        //Telemetry section
        telemetry.addData("Left  Power", drivePL);
        telemetry.addData("Right Power", drivePR);
        telemetry.addData("Rotor Power", rotorPw);
    }
}