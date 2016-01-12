package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by NN on 1/7/2016.
 */
public class MainBotAutoBase extends LinearOpMode {

    DcMotor driveR; //Motors for the drive system
    DcMotor driveL;

    //This programs is only here to provide a simple interface to program autonomous
    void lTurn(double speed, float seconds) throws InterruptedException {
        driveL.setPower(speed);
        driveR.setPower(0.000);
        sleep((int) seconds * 1000);
    }

    void rTurn(double speed, float seconds) throws InterruptedException {
        driveL.setPower(0.000);
        driveR.setPower(speed);
        sleep((int) seconds * 1000);
    }

    void stopT(float seconds) throws InterruptedException {
        driveL.setPower(0.000);
        driveR.setPower(0.000);
        sleep((int) seconds * 1000);
    }

    void moveT(double speed, float seconds) throws InterruptedException {
        driveL.setPower(speed);
        driveR.setPower(speed);
        sleep((int) seconds * 1000);
    }

    @Override //Only prepares motors
    public void runOpMode() throws InterruptedException
    {
        driveL = hardwareMap.dcMotor.get("DriveL");
        driveR = hardwareMap.dcMotor.get("DriveR");
        driveR.setDirection(DcMotor.Direction.REVERSE);
    }
}
