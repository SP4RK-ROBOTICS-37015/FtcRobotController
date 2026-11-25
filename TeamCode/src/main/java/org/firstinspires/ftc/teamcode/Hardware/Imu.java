package org.firstinspires.ftc.teamcode.Hardware;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;


public class Imu {
    public GoBildaPinpointDriver pinpoint; // Dichiarazione di un nuovo oggetto. Nome dell'oggetto: pinpoint

    // Dichiarazione variabili
    public double posX;
    public double posY;
    public double angGradi;

    //Metodo costrutore: i "dettagli" dell'oggetto "pinpoint"
    public Imu(HardwareMap hardwareMap){

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "Pinpoint");

        pinpoint.setOffsets(2, -2, DistanceUnit.MM);

        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections( // Le direzioni del Pinpoint hanno bisogno di essere ricontrollate

                GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD
        );

        pinpoint.resetPosAndIMU();
    }

    // Metodo per aggiornare la posizione
    public void update(){

        Pose2D posizione = pinpoint.getPosition();

        if(posizione != null)

        {
            posX = posizione.getX(DistanceUnit.MM); // Posizione sull'asse delle x in MM -> Millimetri
            posY = posizione.getY(DistanceUnit.MM); // Posizione sull'asse delle y in MM -> Millimetri
            angGradi = posizione.getHeading(AngleUnit.DEGREES); // Angolo di rotazione in DEGREES -> Gradi
        }

    }

}