package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class RunServo extends OpMode {
    private CRServo leftServo, rightServo;

    @Override
    public void init() {
        leftServo = hardwareMap.get(CRServo.class, "Left");
        rightServo = hardwareMap.get(CRServo.class, "Right");
        leftServo.setDirection(CRServo.Direction.REVERSE);
        rightServo.setDirection(CRServo.Direction.FORWARD);

    }

    @Override
    public void loop() {
        boolean doIt = gamepad1.x;
        if (doIt){
        rightServo.setPower(1);
        leftServo.setPower(1);
        }
    }
}