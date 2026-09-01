package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous
public class TestPath extends LinearOpMode {

    private Follower follower;
    private final Pose start = new Pose(0,0, 0);
    private final Pose end = new Pose(20,20,Math.toRadians(90));
    @Override
    public void runOpMode() throws InterruptedException {
        follower = Constants.createFollower(hardwareMap);
        buildPath();
        follower.setStartingPose(start);
        waitForStart();
        follower.followPath(testPose);
        while (follower.isBusy()){
            follower.update();
            follower.followPath(testPose);
        }
    }
    private PathChain testPose;
    public void buildPath(){

        testPose = follower.pathBuilder()
                .addPath(new BezierLine(start, end))
                .setLinearHeadingInterpolation(start.getHeading(), end.getHeading())
                .build();
    }
}
