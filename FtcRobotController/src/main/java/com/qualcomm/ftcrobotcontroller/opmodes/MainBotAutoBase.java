package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by NN on 2016.01.1X
 */
public class MainBotAutoBase extends LinearOpMode {

    DcMotor driveR; //Motors for the drive system
    DcMotor driveL;
    DcMotor rotorA; //Motors for tape measure
    DcMotor rotorB;
    DcMotor hingeA; //Motors for hang angle (Hangle)
    DcMotor hingeB;
    Servo   climbL;
    Servo   climbR;

    //This programs is only here to provide a simpler interface to program autonomous
    void lTurn (double speed) { driveL.setPower(speed); driveR.setPower(0.000); } //Drive based functions
    void rTurn (double speed) { driveL.setPower(0.000); driveR.setPower(speed); }
    void spinB (double speed) { driveL.setPower(-speed);driveR.setPower(speed); }
    void moveB (double speed) { driveL.setPower(speed); driveR.setPower(speed); }
    void stopB ()             { driveL.setPower(0.000); driveR.setPower(0.000); }

    void highT (double speed) { hingeA.setPower(speed); hingeB.setPower(speed);
                                rotorA.setPower(0.000); rotorB.setPower(0.000); } //Tape measure based functions
    void longT (double speed) { rotorA.setPower(speed); rotorB.setPower(speed);
                                hingeA.setPower(0.000); hingeB.setPower(0.000); }
    void stopT ()             { hingeA.setPower(0.000); hingeB.setPower(0.000);
                                rotorA.setPower(0.000); rotorB.setPower(0.000); }

    void mensL () { climbL.setPosition(0.5);} //Climber servo based functions
    void mensR () { climbR.setPosition(0.5);}
    void noMen () { climbL.setPosition(0.0); climbR.setPosition(1.0); }

    @Override //Only prepares motors
    public void runOpMode() throws InterruptedException
    {
        climbL = hardwareMap.servo.  get("ClimbL");
        climbR = hardwareMap.servo.  get("ClimbR");
        driveL = hardwareMap.dcMotor.get("DriveL");
        driveR = hardwareMap.dcMotor.get("DriveR");
        hingeA = hardwareMap.dcMotor.get("HingeA");
        hingeB = hardwareMap.dcMotor.get("HingeB");
        rotorA = hardwareMap.dcMotor.get("RotorA");
        rotorB = hardwareMap.dcMotor.get("RotorB");
        driveR.setDirection(DcMotor.Direction.REVERSE);
        hingeA.setDirection(DcMotor.Direction.REVERSE);
        climbL.setPosition(0.0); climbR.setPosition(1.0);
    }
}
