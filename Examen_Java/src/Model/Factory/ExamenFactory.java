package Model.Factory;

import Model.Examen.Examen;

public class ExamenFactory {
    private Examen examen;

    public Examen getExamen(String examenType) {
        if(examenType == null){
            return null;
        }
        if(examenType.equalsIgnoreCase("examen1")){
            return new Examen1();

        } else if(examenType.equalsIgnoreCase("examen2")){
            return new Examen2();

        } else if(examenType.equalsIgnoreCase("examen3")){
            return new Examen3();

        }

        return null;
    }
}
