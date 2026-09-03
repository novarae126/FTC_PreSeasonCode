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
    private final Pose one = new Pose(0,0, 0);
    private final Pose two = new Pose(84,0);
    //private final Pose three = new Pose(0,36,Math.toRadians(90));
   // private final Pose four = new Pose(0,36,Math.toRadians(90));


        @Override
    public void runOpMode() throws InterruptedException {
        follower = Constants.createFollower(hardwareMap);
        buildPath();
        follower.setStartingPose(one);
        waitForStart();
        follower.followPath(oneTwo);
        while (follower.isBusy()){
            if (opModeIsActive()) {
                follower.update();
                //follower.followPath(twoThree);
                //follower.followPath(threeFour);
                //follower.followPath(fourTwo);
            }

        }
    }
    private PathChain oneTwo, twoThree, threeFour, fourTwo;
    public void buildPath(){

        oneTwo = follower.pathBuilder()
                .addPath(new BezierLine(one, two))
                .setLinearHeadingInterpolation(one.getHeading(), two.getHeading())
                .build();
        twoThree = follower.pathBuilder()
                .addPath(new BezierLine(one, two))
                .setLinearHeadingInterpolation(one.getHeading(), two.getHeading())
                .build();
        threeFour = follower.pathBuilder()
                .addPath(new BezierLine(one, two))
                .setLinearHeadingInterpolation(one.getHeading(), two.getHeading())
                .build();
        fourTwo = follower.pathBuilder()
                .addPath(new BezierLine(one, two))
                .setLinearHeadingInterpolation(one.getHeading(), two.getHeading())
                .build();
    }

}
