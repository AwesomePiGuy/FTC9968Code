package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="ControlledByZack", group="TeleOp")

public class Controlled extends OpMode{

    //* Define Robot 
    RobotHardware robot = new RobotHardware();
    
     //* Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "1");
    }
     //* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {
    }

     // Code to run ONCE when the driver hits PLAY
    @Override
    public void start() {
    }
     // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double strafe = 0.0;
        double rotate = -gamepad1.right_stick_x * .25;
        double drive = -gamepad1.left_stick_y/2;
        boolean G1rightBumper = gamepad1.right_bumper;
        boolean G1leftBumper = gamepad1.left_bumper;
        
        if (G1rightBumper)
        {
         strafe = .35;
        }
        else if (G1leftBumper)
        {
         strafe = -.35;
        }
        
        robot.leftFront.setPower(strafe + drive - rotate);
        robot.rightFront.setPower(strafe - drive - rotate);
        robot.leftBack.setPower(-strafe + drive - rotate);
        robot.rightBack.setPower(-strafe - drive - rotate);
        if(gamepad2.right_bumper == true)
        {
            robot.cm.setPower(-.5);
            try{
                TimeUnit.MILLISECONDS.sleep(30);
            }catch (InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }
        else if(gamepad2.left_bumper == true)
        {
            robot.cm.setPower(.5);
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        else
        {
            robot.cm.setPower(0);
        }
        if(gamepad2.b == true)
        {
            robot.cm.setPower(-.5);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        else if(gamepad2.x == true)
        {
            robot.cm.setPower(.5);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        else
        {
          robot.cm.setPower(0);
        }
    }
     // Code to run ONCE after the driver hits STOP
    @Override
    public void stop() {
    }
}
