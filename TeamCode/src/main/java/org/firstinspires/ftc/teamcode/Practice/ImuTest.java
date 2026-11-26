package org.firstinspires.ftc.teamcode.Practice;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Hardware.Imu;

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

        telemetry.addData("Posizione X -> ", robotImu.posX);
        telemetry.addData("Posizione Y -> ", robotImu.posY);
        telemetry.addData("Angolo di rotazione -> ", robotImu.angGradi);

    }
}