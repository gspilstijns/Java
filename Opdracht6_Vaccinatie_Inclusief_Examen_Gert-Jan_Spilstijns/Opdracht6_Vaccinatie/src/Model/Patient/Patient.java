package Model.Patient;

import Model.Vaccinatie.Vaccinatie;

import java.util.List;

public class Patient {
    private String naam;
    private List<Vaccinatie> vaccinatieList;
    private int leeftijd;
    private String riziv;


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Vaccinatie> getVaccinatieList() {
        return vaccinatieList;
    }

    public void setVaccinatieList(List<Vaccinatie> vaccinatieList) {
        this.vaccinatieList = vaccinatieList;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getRiziv() {
        return riziv;
    }

    public void setRiziv(String riziv) {
        this.riziv = riziv;
    }

    public Patient(String naam, int leeftijd, String riziv) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.riziv = riziv;

    }
    public Patient(Vaccinatie vaccinatie){
        this.vaccinatieList.add(vaccinatie);
    }
}
