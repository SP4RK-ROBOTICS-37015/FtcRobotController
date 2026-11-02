package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanism.Motors;

@TeleOp(name = "Robot", group = "TeleOp")

public class Robot extends OpMode {

    Motors motors = new Motors();

    @Override
    public void init() {

        motors.init(hardwareMap);
        telemetry.addData("INIT", "Pronto!");

    }

    @Override
    public void loop() {

        // Si legge il valore di pressione del Trigger Destro (da 0.0 a 1.0) per la variabile speed (per regolare la velocità)
        double speed = gamepad1.right_trigger;

        // double slowing = gamepad1.left_trigger;
        // speed -= slowing; Prova dell'uso della frenata, gestita dal left trigger

        /* if(speed < -1) {

        speed = -1;

        } Serve a normalizzare la velocità a -1 nel caso (frenata - accelerazione) < -1 */

        telemetry.addData("Speed", speed);
        telemetry.addData("Up", gamepad1.dpad_up);
        telemetry.addData("Down", gamepad1.dpad_down);
        telemetry.addData("Left", gamepad1.dpad_left);
        telemetry.addData("Right", gamepad1.dpad_right);
        telemetry.addData("TurnLeft", gamepad1.left_bumper);
        telemetry.addData("TurnRight", gamepad1.right_bumper);

        // Controllo del movimento attraverso le freccette ed i bumper.

        if (gamepad1.dpad_up) {
            motors.moveForward(speed);
        } else if (gamepad1.dpad_down) {
            motors.moveBack(speed);
        } else if (gamepad1.dpad_left) {
            motors.moveLeft(speed);
        } else if (gamepad1.dpad_right) {
            motors.moveRight(speed);
        } else if (gamepad1.left_bumper) {
            motors.turnLeft(speed);
        } else if (gamepad1.right_bumper) {
            motors.turnRight(speed);
        } else {
            motors.stopMotors();
        }

        // Prova dell'uso dei joysticks al posto delle freccette per controllare i movimenti del robot

        /* if(gamepad1.left_stick_y < 0) {
            motors.moveForward(speed);
        }
        else if(gamepad1.left_stick_y > 0) {
            motors.moveBack(speed);
        }
        else if(gamepad1.left_stick_x < 0) {
            motors.moveLeft(speed);
        }
        else if(gamepad1.left_stick_x > 0) {
            motors.moveRight(speed);
        }
        else if(gamepad1.right_stick_x > 0) {
            motors.turnRight(speed);
        }
        else if(gamepad1.right_stick_x < 0) {
            motors.turnLeft(speed);
        }
        else {
            motors.stopMotors();
        } */

    }

}