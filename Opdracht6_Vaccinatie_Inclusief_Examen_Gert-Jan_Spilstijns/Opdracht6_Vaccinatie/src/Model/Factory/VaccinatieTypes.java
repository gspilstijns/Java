package Model.Factory;

import Model.Patient.Patient;
import Model.Vaccinatie.*;

import java.util.Random;

public class VaccinatieTypes {
    private static String[] vaccinaties = {"COVID-19","DTP","HEPATITIS-B","INFLUENZA" };

    private static Random random = new Random();

    public static Random getRandom() {
        return random;
    }

    public String getRandomVaccinatie() {
        var vaccinatie = vaccinaties[getRandom().nextInt(vaccinaties.length)];
        return vaccinatie;
    }

}

