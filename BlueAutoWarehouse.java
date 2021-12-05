package org.firstinspires.ftc.teamcode.BlueAuto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="BlueAutoWarehouse", group="Test")

public class BlueAutoWarehouse extends LinearOpMode {
    
    RobotHardware robot = new RobotHardware();
    
    @Override
    public void runOpMode() {
        
        robot.init(hardwareMap);
        
        waitForStart();
        
        strafer(-1, 700);
        drive(-1, -1, 500);
        strafer(-1,500);
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
