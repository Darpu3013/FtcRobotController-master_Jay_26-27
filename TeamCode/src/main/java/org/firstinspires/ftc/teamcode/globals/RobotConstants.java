package org.firstinspires.ftc.teamcode.globals;

import com.pedropathing.math.Pose;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class RobotConstants {

    public enum RobotTeam{
        RED, BLUE
    }
    public static RobotTeam robotTeam = RobotTeam.RED;

    public static Pose redCloseGoal = new Pose(58, 58);
    public static Pose redFarGoal = new Pose(58, 84);

    public static Pose blueCloseGoal = new Pose(84, 58);
    public static Pose blueFarGoal = new Pose(84, 84);
    public static final double goalSwitchY = 75;
    public static double goalHeight = 53.5;

    //intake
    public static final String intakeName = "intake";
    public static double flowerMin;
    public

    //flower intake
    public static final String flowerIntakeName = "flowerIntake";

    //stopper
    public static final String stopperName = "stopper";
    public static double stopperMin;
    public static double stopperMax;

    //turret
    public static final String turretName = "turret";
    public static final Motor.GoBILDA turretMotType = Motor.GoBILDA.RPM_312;
    public static boolean turretReversed = false;
    public static double turretPCoeff = 0.02, turretDCoeff = 0.0;
    public static double turretTolerance = 1.0;
    public static final double turretRatio = 2/1;
    public static final double turretTicksPerDegree = (turretMotType.getCPR() * turretRatio) / 360;

    //hood
    public static final String hoodName = "hood";
    public static double hoodMin = 0.0, hoodMax = 1.0;
    public static double hoodMinDist = 43.7; // Tune to Closest Shooting Spot - telemetry.addData("dist", hood.getDistance(follower.getPose()));
    public static double hoodMaxDist = 160.3; // Tune to Farthest Shooting Spot


    public static Pose getGoal(Pose robotPose){
        boolean far =  robotPose.y() > goalSwitchY;
        if(robotTeam == RobotTeam.RED){
            return far ? redFarGoal : redCloseGoal;
        }
        else {
            return far ? blueFarGoal : blueCloseGoal;
        }
    }

}
