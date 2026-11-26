package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// classi importate
import org.firstinspires.ftc.teamcode.hardware.Motors;
import org.firstinspires.ftc.teamcode.hardware.Imu;

@TeleOp(name = "Test", group = "TeleOp")
public class TeleopRobot extends OpMode {

    private Motors motors;
    private Imu robotImu;

    @Override
    public void init() {
        robotImu = new Imu(hardwareMap);
        motors = new Motors(hardwareMap);
        telemetry.addData("INIT", "Pronto!");
    }

    @Override
    public void loop() {
        // Se il trigger non è premuto (valore ~0), imposta la velocità di default a 1.0
        double speed = gamepad1.right_trigger;

        robotImu.update();

        telemetry.addData("Speed", speed);

        telemetry.addData("Up", gamepad1.dpad_up);
        telemetry.addData("Down", gamepad1.dpad_down);
        telemetry.addData("Left", gamepad1.dpad_left);
        telemetry.addData("Right", gamepad1.dpad_right);

        telemetry.addData("TurnLeft", gamepad1.left_bumper);
        telemetry.addData("TurnRight", gamepad1.right_bumper);

        telemetry.addData("Posizione robot asseX:", robotImu.posX);
        telemetry.addData("Posizione robot asseY:", robotImu.posY);
        telemetry.addData("Angolo rotazione:", robotImu.Ang_Gradi);

        if (gamepad1.left_stick_y < -0.1) {
            if (gamepad1.right_stick_x < -0.1) {
                motors.moveForwardTurnLeft(speed);
            } else if (gamepad1.right_stick_x > 0.1) {
                motors.moveForwardTurnRight(speed);
            } else {
                motors.moveForward(speed);
            }
        } else if (gamepad1.left_stick_y > 0.1) {
            motors.moveBack(speed);
        } else if (gamepad1.left_stick_x < -0.1) {
            motors.moveLeft(speed);
        } else if (gamepad1.left_stick_x > 0.1) {
            motors.moveRight(speed);
        } else if (gamepad1.right_stick_x > 0.1 && Math.abs(gamepad1.left_stick_x) < 0.1) {
            motors.turnRight(speed);
        } else if (gamepad1.right_stick_x < -0.1 && Math.abs(gamepad1.left_stick_x) < 0.1) {
            motors.turnLeft(speed);
        } else {
            motors.stopMotors();
        }
    }
}