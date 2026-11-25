package org.firstinspires.ftc.teamcode.OpMode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//classi importati
import org.firstinspires.ftc.teamcode.Hardware.Motors;
import org.firstinspires.ftc.teamcode.Hardware.Imu;

@TeleOp(name = "Test", group = "TeleOp")

public class Robot extends OpMode {

    private Motors motors;
    private Imu robotImu;

    @Override
    public void init() {

        robotImu = new Imu(hardwareMap);
        motors = new Motors();

        telemetry.addData("INIT", "Pronto!");

    }

    @Override
    public void loop() {

        double speed = gamepad1.right_trigger;

        robotImu.update();

        telemetry.addData("Speed", speed);

        telemetry.addData("Up", gamepad1.dpad_up);
        telemetry.addData("Down", gamepad1.dpad_down);
        telemetry.addData("Left", gamepad1.dpad_left);
        telemetry.addData("Right", gamepad1.dpad_right);

        telemetry.addData("TurnLeft", gamepad1.left_bumper);
        telemetry.addData("TurnRight", gamepad1.right_bumper);


        if(gamepad1.left_stick_y < -0.1) {

            motors.moveForward(speed);
        }

        else if(gamepad1.left_stick_y > 0.1) {
            motors.moveBack(speed);
        }

        else if(gamepad1.left_stick_x < -0.1) {
            motors.moveLeft(speed);
        }

        else if(gamepad1.left_stick_x > 0.1) {
            motors.moveRight(speed);
        }

        else if(gamepad1.right_stick_x > 0.1) {
            motors.turnRight(speed);
        }

        else if(gamepad1.right_stick_x < -0.1) {
            motors.turnLeft(speed);

        }

        else {
            motors.stopMotors();
        }
    }
}