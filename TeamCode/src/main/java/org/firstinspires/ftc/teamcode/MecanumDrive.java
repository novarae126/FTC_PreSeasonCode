package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MecanumDrive extends OpMode {
    private double x_command, y_command, z_command;
    private double frontLeftCommand, frontRightCommand, backLeftCommand, backRightCommand;
    private DcMotor frontLeft, frontRight, backLeft, backRight;


    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "fl");
        frontRight = hardwareMap.get(DcMotor.class, "fr");
        backLeft = hardwareMap.get(DcMotor.class, "bl");
        backRight = hardwareMap.get(DcMotor.class, "br");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        x_command = gamepad1.left_stick_x;
        y_command = -gamepad1.left_stick_y;
        z_command = gamepad1.right_stick_x;

        frontLeftCommand = y_command + x_command - z_command;
        frontRightCommand = y_command - x_command + z_command;
        backLeftCommand = y_command - x_command - z_command;
        backRightCommand = y_command + x_command + z_command;

        double max = Math.max(1, frontLeftCommand);
        max = Math.max(max, frontRightCommand);
        max = Math.max(max, backLeftCommand);
        max = Math.max(max, backRightCommand);

        frontRightCommand = frontRightCommand/max;
        frontLeftCommand = frontLeftCommand/max;
        backRightCommand = backRightCommand/max;
        backLeftCommand = backLeftCommand/max;

        frontLeft.setPower((frontLeftCommand/3));
        frontRight.setPower((frontRightCommand/3));
        backLeft.setPower((backLeftCommand/3));
        backRight.setPower((backRightCommand/3));


    }
}
