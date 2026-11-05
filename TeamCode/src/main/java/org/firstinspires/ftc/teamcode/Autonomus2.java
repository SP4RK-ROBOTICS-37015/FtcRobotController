package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name = "Autonomus esempio" , group="Robot")
public class Autonomus2 extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    @Override //serve a riscrivere un metodo
    public void runOpMode() { //indica il punto di inizio obbligatorio in cui il robot entra quando si preme "Init". Collega i motori
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addLine("Robot pronto");
        telemetry.addLine("Premi per iniziare");
        telemetry.update();
        waitForStart();
        if (opModeIsActive()) {
            return;
        }
        //prima fase: Avanza per due secondi
        frontLeft.setPower(0.4);
        frontRight.setPower(0.4);
        backLeft.setPower(0.4);
        backRight.setPower(0.4);
        sleep(2000);
        //ferma i motori
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        if (opModeIsActive()) {
            return;
        }
        //gira a destra
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);
        backLeft.setPower(-0.3);
        backRight.setPower(-0.3);
        sleep(700);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        if (opModeIsActive()) {
            return;
        }
    }
}

