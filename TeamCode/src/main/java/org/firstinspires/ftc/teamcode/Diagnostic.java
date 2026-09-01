package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Diagnostic extends OpMode {
    private double x_command, y_command, z_command;
    private double frontLeftCommand, frontRightCommand, backLeftCommand, backRightCommand;
    private DcMotor frontLeft, frontRight, backLeft, backRight;


    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        if (gamepad1.a){
            frontLeft.setPower(1);
        }
        if (gamepad1.b){
            frontRight.setPower(1);
        }
        if (gamepad1.x){
            backLeft.setPower(1);
        }
        if (gamepad1.y){
            backRight.setPower(1);
        }
        telemetry.addData("frontLft = a, frontRight = b, backRight = y, backLeft = x", 1);


    }
}
