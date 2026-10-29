package org.firstinspires.ftc.teamcode.Mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motors {

    DcMotor motorFrontLeft, motorFrontRight, motorBackLeft, motorBackRight;

    public void init(HardwareMap hwMap) { /* Qui ho dichiarato le variabili per ciascun motore con la funzione hwMap.get
    ovviamente i nomi dei motori li cambierò in base a quelli che verrano inseriti nel configuration file sul Driver Hub (sperando che funzioni)*/


        motorFrontLeft = hwMap.get(DcMotor.class, "frontLeft");
        motorFrontRight = hwMap.get(DcMotor.class, "frontRight");
        motorBackLeft = hwMap.get(DcMotor.class, "backLeft");
        motorBackRight = hwMap.get(DcMotor.class, "backRight");

    }

    /* Qui sotto ho creato i due metodi movef (forward) -> avanti e moveb (moveback) -> indietro. La logica, ovviamente, va rvista in base
    al posizionamento dei motori*/

    public void movef(double speed) {

        motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

        motorFrontLeft.setPower(speed);
        motorFrontRight.setPower(speed);
        motorBackLeft.setPower(speed);
        motorBackRight.setPower(speed);


    }

    public void moveb(double speed) {

       // motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackRight.setDirection(DcMotor.Direction.REVERSE);

        motorFrontLeft.setPower(speed);
        motorFrontRight.setPower(speed);
        motorBackLeft.setPower(speed);
        motorBackRight.setPower(speed);



    }

    public void stopMotors(){
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);
    }
}
