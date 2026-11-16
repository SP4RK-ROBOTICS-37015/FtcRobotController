package org.firstinspires.ftc.teamcode.opmode.autonomus;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // Importa i comandi necessari per creare la parte autonoma.
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // Importa la struttura che permette al codice di essere eseguito riga per riga.
import com.qualcomm.robotcore.hardware.DcMotor;// Importa le istruzioni per poter controllare i motori.
@Autonomous(name = "Autonomus Test" , group = "Robot") // Dice che questo è un programma automomo e imposta il nome sul display.

public class AutonomusTest extends LinearOpMode { // Definizione del programma che segue una logica.
    private DcMotor motoreSinistroAnteriore; // Crea la variabile (casella vuota) per gestire il motore sinistro.
    private DcMotor motoreDestroAnteriore; // Lo stesso della variabile di prima con il motore destro.
    private DcMotor motoreSinistroPosteiore;
    private DcMotor motoreDestroPosteriore;

    @Override // Serve a riscrivere un metodo preesistente

    public void runOpMode() {// Indica il punto di inizio obbligatorio in cui il robot entra quando si preme "Init". Collega i motori

        motoreSinistroAnteriore = hardwareMap.get(DcMotor.class, "left_front");
        // Collega la variabile del codice al motore fisico configurato come "left_drive".
        motoreDestroAnteriore = hardwareMap.get(DcMotor.class, "right_front");
        // Collega la variabile del codice al motore
        motoreSinistroPosteiore = hardwareMap.get(DcMotor.class, "left_back");
        motoreDestroPosteriore = hardwareMap.get(DcMotor.class, "right_back");

        // Direzione dei motori
        motoreSinistroAnteriore.setDirection(DcMotor.Direction.FORWARD);
        motoreSinistroPosteiore.setDirection(DcMotor.Direction.FORWARD);
        motoreDestroAnteriore.setDirection(DcMotor.Direction.REVERSE);
        motoreDestroPosteriore.setDirection(DcMotor.Direction.REVERSE);

        // Comunicazione sulla Driver Station che il robot è pronto
        telemetry.addLine("Robot pronto");
        telemetry.addLine("Premi per iniziare");
        telemetry.update();

        // Aspetta il comando START
        waitForStart();
        if (opModeIsActive()) {
            return;
        }

        // Prima fase: avanza per due secondi
        motoreSinistroAnteriore.setPower(0.4);
        motoreDestroAnteriore.setPower(0.4);
        motoreSinistroPosteiore.setPower(0.4);
        motoreDestroPosteriore.setPower(0.4);
        sleep(2000);

        // Ferma i motori
        motoreSinistroAnteriore.setPower(0);
        motoreDestroAnteriore.setPower(0);
        motoreSinistroPosteiore.setPower(0);
        motoreDestroPosteriore.setPower(0);
        if (opModeIsActive()) {
            return;
        }

        // Gira a destra
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

