package org.firstinspires.ftc.teamcode.Practice;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Hardware.Imu;
import org.firstinspires.ftc.teamcode.Hardware.Motors;

@Disabled
@Autonomous(name = "AutonomousImu", group = "autonomous")

public class AutonomousWithImuTest extends OpMode {

    private Motors motors;
    private Imu autoImu;

    @Override
    public void init() {

        motors = new Motors();
        motors.init(hardwareMap);
        autoImu = new Imu(hardwareMap);

    }

    @Override
    public void loop() {

        autoImu.update();

        double speed = 0.3;

        if (autoImu.posY <= 30) {

            motors.moveForward(speed);

        }

        else {

            motors.stopMotors();

        }
    }
}
