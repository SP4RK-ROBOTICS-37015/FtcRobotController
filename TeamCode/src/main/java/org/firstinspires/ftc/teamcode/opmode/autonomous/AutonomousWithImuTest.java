package org.firstinspires.ftc.teamcode.opmode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hardware.Imu;
import org.firstinspires.ftc.teamcode.hardware.Motors;

@Autonomous(name = "AutonomousImu", group = "autonomous")
public class AutonomousWithImuTest extends OpMode {

    private Motors motors;
    private Imu autoImu;

    @Override
    public void init(){
        motors = new Motors();
        motors.init(hardwareMap);
        autoImu = new Imu(hardwareMap);
    }

    @Override
    public void loop(){
        autoImu.update();

        double speed = 0.5;

        if (autoImu.posY <= 300) {
            motors.moveForward(speed);
        } else {
            motors.stopMotors();
        }
    }
}
