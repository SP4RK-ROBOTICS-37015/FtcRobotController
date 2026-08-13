package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class ifPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;

        if(!gamepad1.a){
            motorSpeed *= 0.5;
        }

        telemetry.addData("Left Stick value", motorSpeed);

/*
        if(leftY < 0.1 && leftY > -0.1) {
            telemetry.addData("Left Stick", "In Dead Zone");

        }
*/
/*
        if(leftY < 0){
            telemetry.addData("Left Stick","is Negative");
        } else if(leftY > 0.5) {
            telemetry.addData("Left Stick", "Greater than 50%");
        } else if(leftY>0) {
            telemetry.addData("Left Stick", "Is greater than 0");
        } else {
            telemetry.addData("Left Stick", "is Zero!");
        }
        telemetry.addData("Left Stick value", leftY);
    }

 */
    }
}
