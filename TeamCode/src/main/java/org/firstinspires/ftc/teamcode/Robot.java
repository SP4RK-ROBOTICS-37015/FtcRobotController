package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanism.Motors;

@TeleOp
public class Robot extends OpMode {

Motors Motors = new Motors();

    @Override
    public void init() {
        Motors.init(hardwareMap);
        telemetry.addData("Funziona?", "Si assolutamente!");
    }

    @Override
    public void loop() {

        /* Qui nel loop ho creato un if e, qualora viene premuto il right trigger, in base a quanto esso viene premuto
         si immagazzina la velocità nella variabile speed. Inoltre, se viene premuta la freccetta sopra, si andrà a richiamare il metodo
         per il movimento avanti, nel caso venga premuta la freccetta in basso, invece, in robot si muoverà indietro sempre con la velocità in funzione
         al right trigger */

        while(gamepad1.right_trigger_pressed) {
            Motors.movef(gamepad1.right_trigger);
        }Motors.stopMotors();

        while(gamepad1.left_trigger_pressed) {
            Motors.movef(gamepad1.left_trigger);
        }Motors.stopMotors();
        /*
            double speed = gamepad1.right_trigger;
            telemetry.addData("speed", speed);

            while(gamepad1.dpad_up) {
                Motors.movef(speed);
            } Motors.stopMotors();

            while(gamepad1.dpad_down) {
                Motors.moveb(speed);
            }Motors.stopMotors();
        }*/
    }
}
