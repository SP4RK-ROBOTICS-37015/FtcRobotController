package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
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
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("clawClosed", clawClosed);
        telemetry.addData("Team Name", teamName);
        telemetry.addData("Motor Angle", motorAngle);

    }

    @Override
    public void loop() {

    }
}
