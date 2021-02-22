package Model.Factory;

import Model.Vaccinatie.*;

public class VaccinatieFactory {
    private Vaccinatie vaccinatie;



    public Vaccinatie getVaccinatie(String vaccinatieType) {
        if(vaccinatieType == null){
            return null;
        }
        if(vaccinatieType.equalsIgnoreCase("COVID-19")){
            return new Covid19();

        } else if(vaccinatieType.equalsIgnoreCase("DTP")){
            return new DTP();

        } else if(vaccinatieType.equalsIgnoreCase("HEPATITIS-B")){
            return new HepatitisB();

        } else if(vaccinatieType.equalsIgnoreCase("INFLUENZA")){
        return new Influenza();

    }

        return null;
    }


}
