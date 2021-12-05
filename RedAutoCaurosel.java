package org.firstinspires.ftc.teamcode.RedAuto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="RedAutoCaurosel", group="Test")

public class RedAutoCaurosel extends LinearOpMode {
    
    RobotHardware robot = new RobotHardware();
    
    @Override
    public void runOpMode() {
        
        robot.init(hardwareMap);
        
        waitForStart();
        
        drive(.5, 0.0, 820*2);
        drive(.5, .5, 270*2);
        strafer(.5, 75*2);
        spin(-.5, 3500);
        strafer(-.5, 465*2);
    }
    
    public void drive(double leftPower, double rightPower, int time)
    {
        robot.leftFront.setPower(leftPower);
        robot.rightFront.setPower(-rightPower);
        robot.leftBack.setPower(leftPower);
        robot.rightBack.setPower(-rightPower);
        sleep(time);
        robot.leftFront.setPower(0);
        robot.rightFront.setPower(0);
        robot.leftBack.setPower(0);
        robot.rightBack.setPower(0);
    }
    
    public void strafer(double power, int time)
    {
        robot.leftFront.setPower(-power);
        robot.rightFront.setPower(-power);
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(power);
        sleep(time);
        robot.leftFront.setPower(0);
        robot.rightFront.setPower(0);
        robot.leftBack.setPower(0);
        robot.rightBack.setPower(0);
    }
    
    public void spin(double power, int time)
    {
        robot.cm.setPower(power);
        sleep(time);
        robot.cm.setPower(0);
    }
}
