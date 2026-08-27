package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.drawCurrentAndHistory;
import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.follower;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@TeleOp
public class MecanumDrive extends OpMode {
    private double x_command, y_command, z_command;
    private double frontLeftCommand, frontRightCommand, backLeftCommand, backRightCommand;
    private DcMotor frontLeft, frontRight, backLeft, backRight;

//    private static Follower follower;
//    public static void drawCurrent() {
//        try {
//            Drawing.drawRobot(follower.getPose());
//            Drawing.sendPacket();
//        } catch (Exception e) {
//            throw new RuntimeException("Drawing failed " + e);
//        }
//    }
///67 ohio
//    public static void drawCurrentAndHistory() {
//        Drawing.drawPoseHistory(poseHistory);
//        drawCurrent();
//    }
//67 ohio
    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

//        follower = Constants.createFollower(hardwareMap);
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

//        follower.update();
//        drawCurrentAndHistory();

    }
}
