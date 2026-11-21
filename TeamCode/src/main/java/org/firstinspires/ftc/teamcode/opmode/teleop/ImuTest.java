package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.hardware.Imu;
@Disabled
@TeleOp
public class ImuTest extends OpMode {
    Imu robotImu;

    @Override
    public void init(){

        robotImu = new Imu(hardwareMap);
    }
    public void loop(){

        robotImu.update();

        telemetry.addData("posizione x ", robotImu.posX);
        telemetry.addData("posizione Y ", robotImu.posY);
        telemetry.addData("angolo di rotazione ", robotImu.Ang_Gradi);

    }
}
