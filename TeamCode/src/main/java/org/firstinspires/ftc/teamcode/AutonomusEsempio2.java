package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous; //importa i comandi necessari per creare la parte autonoma.
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imorta la struttura che permette al codice di essere eseguito riga per riga.
import com.qualcomm.robotcore.hardware.DcMotor;//Importa le istruzioni per poter controllare i motori.
@Autonomous(name = "Autonomus esempio" , group="Robot")//dice che questo è un programma automomo e imposta il nome sul display.
public class AutonomusEsempio2 extends LinearOpMode { //definizione progtamma che segue una logica.
    private DcMotor motoreSinistroAnteriore; //crea la variabile (casella vuota) per gestire il motore sinistro.
    private DcMotor motoreDestroAnteriore;//lo stesso della variabile di prima con il motore destro.
    private DcMotor motoreSinistroPosteiore;
    private DcMotor motoreDestroPosteriore;

    @Override //serve a riscrivere un metodo
    public void runOpMode() {//indica il punto di inizio obbligatorio in cui il robot entra quando si preme "Init". Collega i motori
        motoreSinistroAnteriore = hardwareMap.get(DcMotor.class, "left_front");
        //collega la variabile del codice al motore fisico configurato come "left_drive".
        motoreDestroAnteriore = hardwareMap.get(DcMotor.class, "right_front");
        //collega la variabile del codice al motore
        motoreSinistroPosteiore = hardwareMap.get(DcMotor.class, "left_back");
        motoreDestroPosteriore = hardwareMap.get(DcMotor.class, "right_back");
        motoreSinistroAnteriore.setDirection(DcMotor.Direction.FORWARD);//direzione dei motori
        motoreSinistroPosteiore.setDirection(DcMotor.Direction.FORWARD);
        motoreDestroAnteriore.setDirection(DcMotor.Direction.REVERSE);
        motoreDestroPosteriore.setDirection(DcMotor.Direction.REVERSE);
        //comunicazione sul driver station che il robot è pronto
        telemetry.addLine("Robot pronto");
        telemetry.addLine("Premi per iniziare");
        telemetry.update();
        //Aspetta il comando START
        waitForStart();
        if (opModeIsActive()) {
            return;
        }
        //prima fase: Avanza per due secondi
        motoreSinistroAnteriore.setPower(0.4);
        motoreDestroAnteriore.setPower(0.4);
        motoreSinistroPosteiore.setPower(0.4);
        motoreDestroPosteriore.setPower(0.4);
        sleep(2000);
        //ferma i motori
        motoreSinistroAnteriore.setPower(0);
        motoreDestroAnteriore.setPower(0);
        motoreSinistroPosteiore.setPower(0);
        motoreDestroPosteriore.setPower(0);
        if (opModeIsActive()) {
            return;
        }
        //gira a destra
        motoreSinistroAnteriore.setPower(0.3);
        motoreDestroAnteriore.setPower(0.3);
        motoreSinistroPosteiore.setPower(-0.3);
        motoreDestroPosteriore.setPower(-0.3);
        sleep(700);
        motoreSinistroAnteriore.setPower(0);
        motoreDestroAnteriore.setPower(0);
        motoreSinistroPosteiore.setPower(0);
        motoreDestroPosteriore.setPower(0);
        if (opModeIsActive()) {
            return;
        }
    }
}

