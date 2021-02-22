package Model.Vaccinatie;

import Logging.VaccinatieLogger;
import Model.Patient.Patient;

public class Influenza extends Vaccinatie {
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    void registreren(Patient patient) {
        setPatient(patient);
        //System.out.println("\tPatiënt: " + patient.getNaam());
        //System.out.println("\tLeeftijd: " + patient.getLeeftijd());
        //System.out.println("\tRIZIV: " + patient.getRiziv());
        VaccinatieLogger.log().info("\tPatiënt: " + patient.getNaam());
        VaccinatieLogger.log().info("\tLeeftijd: " + patient.getLeeftijd());
        VaccinatieLogger.log().info("\tRIZIV: " + patient.getRiziv());
    }

    @Override
    void informeren() {
        //System.out.println("\tInformeer: Informatiebrocure Influenza aan " + getPatient().getNaam() + " overhandigd");
        VaccinatieLogger.log().info("\tInformeer: Informatiebrocure Influenza aan " + getPatient().getNaam() + " overhandigd");
    }

    @Override
    void voorbereiden() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tVoorbereiden:\n\t\t");
        //sb.append("Ontdooi vaccin\n\t\t");
        //sb.append("Vaccin opwarmen\n\t\t");
        //sb.append("Oplossen in serum\n\t\t");
        sb.append("Vaccin optrekken in spuitje\n\t\t");
        sb.append("Bovenarm van patient ontsmetten");
        //System.out.println(sb);
        VaccinatieLogger.log().info(sb);
    }

    @Override
    void toedienen() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tToedienen:\n\t\t");
        sb.append("Spuitje wordt toegediend");
        //System.out.println(sb);
        VaccinatieLogger.log().info(sb);
    }

    @Override
    void nazorgen() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tNazorg:\n\t\t");
        sb.append("Pleister wordt geplakt\n\t\t");
        sb.append(getPatient().getNaam()+" mag onmiddelijk vertrekken naar huis\n\t\t");
        sb.append("Dokter voltooid de registratie van de Influenza vaccinatie\n");
        sb.append("-------------------------------------------------------------------------");
        //System.out.println(sb);
        VaccinatieLogger.log().info(sb);
    }
}
