package Model.Vaccinatie;

import Logging.VaccinatieLogger;
import Model.Patient.Patient;

public class DTP extends Vaccinatie {

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
        //System.out.println("\tInformeer: Informatiebrocure DTP aan " + getPatient().getNaam() + " overhandigd");
        VaccinatieLogger.log().info("\tInformeer: Informatiebrocure DTP aan " + getPatient().getNaam() + " overhandigd");
    }

    @Override
    void voorbereiden() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tVoorbereiden:\n\t\t");
        sb.append("Vaccin optrekken in spuit\n\t\t");
        sb.append("Vermeng vaccin met serum\n\t\t");
        sb.append("Vermengd vaccin optrekken in spuitje\n\t\t");
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
        sb.append(getPatient().getNaam()+" blijft nog 5 min wachten en mag dan naar huis\n\t\t");
        sb.append("Dokter voltooid de registratie van de DTP vaccinatie\n");
        sb.append("-------------------------------------------------------------------------");
        //System.out.println(sb);
        VaccinatieLogger.log().info(sb);
    }
}
