package org.firstinspires.ftc.teamcode.localization;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // Importa la classe per creare un programma FTC sequenziale
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // Importa l'annotazione per registrare un TeleOp
import com.qualcomm.robotcore.hardware.DcMotor; // Importa la classe per controllare i motori

public class Odometry {
    @TeleOp(name = "Odometry Test") // Imposta il nome del programma che apparirà sul Driver Hub
    public class OdometryTest extends LinearOpMode { // Crea la classe del programma e la collega a LinearOpMode

        DcMotor leftMotor; // Dichiara il motore sinistro
        DcMotor rightMotor; // Dichiara il motore destro

        // PARAMETRI DEL ROBOT

        static final double TICKS_PER_REV = 537.7; // Numero di tick dell'encoder per un giro completo della ruota (valore da calibrare)
        static final double WHEEL_DIAMETER = 9.6; // Diametro della ruota espresso in centimetri
        static final double TRACK_WIDTH = 35.0; // Distanza tra il centro della ruota sinistra e quello della ruota destra, in cm

        // POSIZIONE INIZIALE DEL ROBOT

        double x = 0; // Coordinata orizzontale iniziale del robot
        double y = 0; // Coordinata verticale iniziale del robot
        double heading = 0; // Angolo iniziale del robot espresso in radianti

        int oldLeftTicks = 0; // Memorizza il valore precedente dell'encoder sinistro
        int oldRightTicks = 0; // Memorizza il valore precedente dell'encoder destro

        @Override // Indica che stiamo ridefinendo il metodo runOpMode della classe LinearOpMode
        public void runOpMode() { // Metodo principale che contiene il programma FTC

            leftMotor = hardwareMap.get( // Recupera il motore sinistro dalla configurazione hardware
                    DcMotor.class, "leftMotor"); // Cerca il motore chiamato leftMotor

            rightMotor = hardwareMap.get( // Recupera il motore destro dalla configurazione hardware
                    DcMotor.class, "rightMotor"); // Cerca il motore chiamato rightMotor

            leftMotor.setMode( // Imposta la modalità di funzionamento del motore sinistro
                    DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Ferma e azzera il contatore dell'encoder sinistro

            rightMotor.setMode( // Imposta la modalità di funzionamento del motore destro
                    DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Ferma e azzera il contatore dell'encoder destro

            leftMotor.setMode( // Imposta la modalità di funzionamento del motore sinistro
                    DcMotor.RunMode.RUN_WITHOUT_ENCODER); // Permette di utilizzare il motore senza controllo di velocità tramite encoder

            rightMotor.setMode( // Imposta la modalità di funzionamento del motore destro
                    DcMotor.RunMode.RUN_WITHOUT_ENCODER); // Permette di utilizzare il motore senza controllo di velocità tramite encoder

            telemetry.addLine("Odometry pronta"); // Mostra sul Driver Hub il messaggio Odometry pronta
            telemetry.update(); // Aggiorna la schermata del Driver Hub mostrando il messaggio

            waitForStart(); // Attende che venga premuto il pulsante START sul Driver Hub

            while (opModeIsActive()) { // Ripete continuamente il codice finché il programma è attivo

                // LETTURA DEGLI ENCODER

                int leftTicks = leftMotor.getCurrentPosition(); // Legge il numero attuale di tick dell'encoder sinistro
                int rightTicks = rightMotor.getCurrentPosition(); // Legge il numero attuale di tick dell'encoder destro

                // CALCOLO DEI TICK DALL'ULTIMO AGGIORNAMENTO

                int deltaLeftTicks = leftTicks - oldLeftTicks; // Calcola quanti tick ha percorso la ruota sinistra dall'ultima lettura
                int deltaRightTicks = rightTicks - oldRightTicks; // Calcola quanti tick ha percorso la ruota destra dall'ultima lettura

                oldLeftTicks = leftTicks; // Salva il valore attuale dell'encoder sinistro per il prossimo aggiornamento
                oldRightTicks = rightTicks; // Salva il valore attuale dell'encoder destro per il prossimo aggiornamento

                // CONVERSIONE DEI TICK IN CENTIMETRI

                double cmPerTick = // Crea una variabile che indica quanti centimetri corrispondono a un tick
                        (Math.PI * WHEEL_DIAMETER) / TICKS_PER_REV; // Calcola la circonferenza della ruota e la divide per i tick per giro

                double deltaLeft = deltaLeftTicks * cmPerTick; // Converte i tick della ruota sinistra in centimetri percorsi
                double deltaRight = deltaRightTicks * cmPerTick; // Converte i tick della ruota destra in centimetri percorsi

                // CALCOLO DELLO SPOSTAMENTO E DELLA ROTAZIONE

                double deltaDistance = // Crea una variabile per lo spostamento medio del robot
                        (deltaLeft + deltaRight) / 2.0; // Calcola la media dello spostamento delle due ruote

                double deltaHeading = // Crea una variabile per la variazione dell'angolo del robot
                        (deltaRight - deltaLeft) / TRACK_WIDTH; // Calcola la rotazione in radianti usando la differenza degli spostamenti

                // AGGIORNAMENTO DELLA POSIZIONE

                double middleHeading = heading + deltaHeading / 2.0; // Calcola l'orientamento medio durante lo spostamento

                x += deltaDistance * Math.cos(middleHeading); // Aggiorna la coordinata X usando lo spostamento e il coseno dell'angolo medio
                y += deltaDistance * Math.sin(middleHeading); // Aggiorna la coordinata Y usando lo spostamento e il seno dell'angolo medio

                heading += deltaHeading; // Aggiorna l'angolo totale del robot sommando la nuova rotazione

                // VISUALIZZAZIONE DEI DATI SUL DRIVER HUB

                telemetry.addData("X", x); // Mostra la coordinata X attuale del robot
                telemetry.addData("Y", y); // Mostra la coordinata Y attuale del robot
                telemetry.addData("Heading (rad)", heading); // Mostra l'orientamento espresso in radianti
                telemetry.addData("Heading (deg)", // Prepara la visualizzazione dell'orientamento in gradi
                        Math.toDegrees(heading)); // Converte l'angolo da radianti a gradi

                telemetry.update(); // Aggiorna tutti i dati visualizzati sul Driver Hub

                sleep(20); // Attende 20 millisecondi prima di ripetere il ciclo
            }
        }
    }


}
