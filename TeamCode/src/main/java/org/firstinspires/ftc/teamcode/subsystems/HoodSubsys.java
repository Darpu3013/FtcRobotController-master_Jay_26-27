package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;
import com.seattlesolvers.solverslib.util.LUT;

import org.firstinspires.ftc.teamcode.globals.RobotConstants;

public class HoodSubsys extends SubsystemBase {

    private ServoEx hoodServo;
    private double hoodPos = 0.0;

    public HoodSubsys(final HardwareMap hwMap){
        hoodServo = new ServoEx(hwMap, RobotConstants.hoodName);
    }

    public void hoodTo(double postion){
        hoodPos = Math.max(RobotConstants.hoodMin, Math.min(RobotConstants.hoodMax, postion));
        hoodServo.set(hoodPos);
    }

    public double getPos(){
        return hoodPos;
    }

    public double getDistance(Pose robotPose){
        Pose goal = RobotConstants.getGoal(robotPose);
        double dx = goal.x() - robotPose.x();
        double dy = goal.y() - robotPose.y();
        double h = RobotConstants.goalHeight;
        return Math.sqrt(dx * dx + dy * dy + h * h);
    }

    public double distanceToPos(double distance){
        double t = (distance - RobotConstants.hoodMinDist) / (RobotConstants.hoodMaxDist - RobotConstants.hoodMinDist);
        return RobotConstants.hoodMin + t * (RobotConstants.hoodMax - RobotConstants.hoodMin);
    }

    public void hoodTrack(Pose robotPose){
        hoodTo(distanceToPos(getDistance(robotPose)));
    }


}
