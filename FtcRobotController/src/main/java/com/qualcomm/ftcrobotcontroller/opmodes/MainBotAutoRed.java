package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created for yusuf on 2016.01.13
 */

public class MainBotAutoRed extends MainBotAutoBase {
    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
        waitForStart();
        moveB(0.2); sleep(750); rTurn(0.3); sleep(1750); moveB(0.2); sleep(2000); //push debris
        lTurn(-0.1); sleep(1000); moveB(0.10); sleep(2000); longT(0.2); sleep(3500); stopT(); //position tape
        highT( 0.2); sleep(500); stopT(    ); mensR(    ); //prepare bot for liftoff
        longT( 0.2); moveB(1.0); sleep(5000); stopT(    ); stopB(    ); noMen(); //bring bot up
    }
}

