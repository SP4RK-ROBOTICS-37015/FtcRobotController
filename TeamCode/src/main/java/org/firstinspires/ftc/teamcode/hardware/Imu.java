package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class Imu {
    public GoBildaPinpointDriver pinpoint; //Dichiarazione di un nuovo oggetto. Nome dell'oggetto: pinpoint

    //Dichiarazione variabili
    public double posX;
    public double posY;
    public double Ang_Gradi;

    //costrutore: "dettagli" dell'oggetto pinpoint
    public Imu(HardwareMap hardwareMap ){

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections(
                GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD
        );
        pinpoint.resetPosAndIMU();
    }
    // metodo per aggiornare la posizione
    public void update(){

        Pose2D posizione = pinpoint.getPosition();
        if(posizione != null)
        {
            posX = posizione.getX(DistanceUnit.MM); //posizione sull'asse delle x in MM -> millimetri
            posY = posizione.getY(DistanceUnit.MM); //posizione sull'asse delle y in MM -> millimetri
            Ang_Gradi = posizione.getHeading(AngleUnit.DEGREES); //angolo di rotazione in DEGREES -> gradi
        }
    }

}
