package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariableExamples extends OpMode {

    @Override
    public void init() {
        int teamNumber = 23451;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "Spark Robotics";
        int motorAngle = 90;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", teamNumber);
        telemetry.addData("clawClosed", teamNumber);
        telemetry.addData("Team Name", teamNumber);

    }

    @Override
    public void loop() {

    }
}
