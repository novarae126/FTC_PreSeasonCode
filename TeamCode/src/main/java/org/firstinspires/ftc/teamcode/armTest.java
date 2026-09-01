package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class armTest extends OpMode {

    private DcMotorEx arm;
    private Servo wrist;
    private double servoValue;
    private boolean last=false, last2=false;
    @Override
    public void init() {
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        wrist = hardwareMap.get(Servo.class, "wrist");
        arm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        arm.setPower(gamepad1.left_trigger - gamepad1.right_trigger + gamepad1.left_stick_y);
        wrist.setPosition(gamepad1.right_stick_y);
    }
}
