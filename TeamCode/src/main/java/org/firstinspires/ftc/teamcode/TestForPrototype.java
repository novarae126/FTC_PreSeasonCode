package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TestForPrototype extends OpMode {

    private DcMotor intake;
    private Servo servo1, servo2;

    @Override
    public void init() {
        intake = hardwareMap.get(DcMotor.class, "intake");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
    }

    @Override
    public void loop() {
        if (gamepad1.left_trigger > 0.5) {
            servo1.setPosition(0.025);
            servo2.setPosition(0);
        }if (gamepad1.left_bumper){
            servo1.setPosition(0);
            servo2.setPosition(0.025);
        }

        if (gamepad1.right_trigger > 0.5) {
            intake.setPower(1);
        }
        if(gamepad1.right_bumper){
            intake.setPower(-1);
        }else {
            intake.setPower(0);
        }
    }
}
