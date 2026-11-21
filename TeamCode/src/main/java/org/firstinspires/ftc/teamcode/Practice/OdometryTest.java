
package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Odometry Test")

public class OdometryTest extends LinearOpMode {

    DcMotor leftFrontMotor;
    DcMotor leftBackMotor;
    DcMotor rightFrontMotor;
    DcMotor rightBackMotor;

    // PARAMETRI DEL ROBOT

    static final double TICKS_PER_REV = 537.7;
    static final double WHEEL_DIAMETER = 9.6;
    static final double TRACK_WIDTH = 35.0;

    // POSIZIONE INIZIALE

    double x = 0;
    double y = 0;
    double heading = 0;

    // TICK PRECEDENTI

    int oldLeftFrontTicks = 0;
    int oldLeftBackTicks = 0;
    int oldRightFrontTicks = 0;
    int oldRightBackTicks = 0;

    @Override
    public void runOpMode() {

        // CONFIGURAZIONE MOTORI

        leftFrontMotor = hardwareMap.get(
                DcMotor.class, "frontLeft");

        leftBackMotor = hardwareMap.get(
                DcMotor.class, "backLeft");

        rightFrontMotor = hardwareMap.get(
                DcMotor.class, "frontRight");

        rightBackMotor = hardwareMap.get(
                DcMotor.class, "backRight");

        // RESET ENCODER

        leftFrontMotor.setMode(
                DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftBackMotor.setMode(
                DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightFrontMotor.setMode(
                DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightBackMotor.setMode(
                DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // MODALITA' ENCODER

        leftFrontMotor.setMode(
                DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftBackMotor.setMode(
                DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightFrontMotor.setMode(
                DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightBackMotor.setMode(
                DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addLine("Odometry Test Pronto!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // LETTURA ENCODER

            int leftFrontTicks =
                    leftFrontMotor.getCurrentPosition();

            int leftBackTicks =
                    leftBackMotor.getCurrentPosition();

            int rightFrontTicks =
                    rightFrontMotor.getCurrentPosition();

            int rightBackTicks =
                    rightBackMotor.getCurrentPosition();

            // CALCOLO DELTA TICKS

            int deltaLeftFront =
                    leftFrontTicks - oldLeftFrontTicks;

            int deltaLeftBack =
                    leftBackTicks - oldLeftBackTicks;

            int deltaRightFront =
                    rightFrontTicks - oldRightFrontTicks;

            int deltaRightBack =
                    rightBackTicks - oldRightBackTicks;

            // AGGIORNAMENTO TICK PRECEDENTI

            oldLeftFrontTicks = leftFrontTicks;
            oldLeftBackTicks = leftBackTicks;

            oldRightFrontTicks = rightFrontTicks;
            oldRightBackTicks = rightBackTicks;

            // MEDIA DEI TICK PER LATO

            double deltaLeftTicks =
                    (deltaLeftFront + deltaLeftBack) / 2.0;

            double deltaRightTicks =
                    (deltaRightFront + deltaRightBack) / 2.0;

            // CONVERSIONE TICK IN CENTIMETRI

            double cmPerTick =
                    (Math.PI * WHEEL_DIAMETER) / TICKS_PER_REV;

            double deltaLeft =
                    deltaLeftTicks * cmPerTick;

            double deltaRight =
                    deltaRightTicks * cmPerTick;

            // CALCOLO SPOSTAMENTO E ROTAZIONE

            double deltaDistance =
                    (deltaLeft + deltaRight) / 2.0;

            double deltaHeading =
                    (deltaRight - deltaLeft) / TRACK_WIDTH;

            // AGGIORNAMENTO POSIZIONE

            double middleHeading =
                    heading + deltaHeading / 2.0;

            x += deltaDistance * Math.cos(middleHeading);

            y += deltaDistance * Math.sin(middleHeading);

            heading += deltaHeading;

            // TELEMETRIA

            telemetry.addData("X (cm)", x);
            telemetry.addData("Y (cm)", y);

            telemetry.addData("Heading (rad)", heading);

            telemetry.addData(
                    "Heading (deg)",
                    Math.toDegrees(heading)
            );

            telemetry.addData("Front left -> ", leftFrontTicks);
            telemetry.addData("Back left -> ", leftBackTicks);
            telemetry.addData("Front right -> ", rightFrontTicks);
            telemetry.addData("Back right -> ", rightBackTicks);

            telemetry.update();

            sleep(20);
        }
    }
}
