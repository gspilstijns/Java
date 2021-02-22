package View;

import Logging.VaccinatieLogger;
import Model.Patient.Patient;
import Model.Patient.PatientGenerator;
import Model.Factory.VaccinatieFactory;
import Model.Factory.VaccinatieTypes;
import Model.Vaccinatie.Vaccinatie;



import java.util.Random;

public class Vaccineren {
    public static void main(String[] args) {

        var vaccinatieType = new VaccinatieTypes();
        var vaccinatieFactory = new VaccinatieFactory();
        var patientGenerator = new PatientGenerator();

        for (int i = 0; i<new Random().nextInt(200); i++){
            var rndVaccinatieType = vaccinatieType.getRandomVaccinatie();
            VaccinatieLogger.log().debug("Random vaccinatietype: "+ rndVaccinatieType);
            System.out.println("Vaccinatie "+ (i+1) +": "+ rndVaccinatieType);
            Vaccinatie vaccinatie = vaccinatieFactory.getVaccinatie(rndVaccinatieType);
            vaccinatie.Vaccineren(new Patient(patientGenerator.GetPatientName(),patientGenerator.GetPatientLeeftijd(),patientGenerator.GetPatientRiziv()));


        }
    }
}
