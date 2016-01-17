package com.qualcomm.ftcrobotcontroller.opmodes;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created for yusuf on 2016.01.13
 */

public class MainBotAutoBeta extends MainBotAutoBase {
    public void runOpMode() throws InterruptedException {
        moveB( 1.0); sleep(500); spinB( 1.0); sleep( 1000); moveB( 1.0); sleep( 1000); stopB(); //get on ramp
        highT( 0.5); sleep( 1000); highT( 0.0); longT( 1.0); sleep( 3000); stopT(    ); //attach tape
        mensR(    ); longT(-1.0); moveB( 1.0); stopT(    ); stopB(    ); noMen(    ); //bring bot up
    }
}

