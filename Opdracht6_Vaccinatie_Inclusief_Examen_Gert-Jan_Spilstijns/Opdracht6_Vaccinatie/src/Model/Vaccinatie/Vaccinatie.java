package Model.Vaccinatie;

import Model.Patient.Patient;

public abstract class Vaccinatie {
    abstract void registreren(Patient patient) ;
    abstract void informeren();
    abstract void voorbereiden();
    abstract void toedienen();
    abstract void nazorgen();
    //Template method
    public final void Vaccineren(Patient patient){

        registreren(patient);
        informeren();
        voorbereiden();
        toedienen();
        nazorgen();
    }

}
