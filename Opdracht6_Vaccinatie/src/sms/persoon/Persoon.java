package sms.persoon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Persoon extends SmsObserver {

    private String naam;
    private String locatie;
    private LocalDateTime datetime;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Persoon(String naam, String locatie) {
        this.naam = naam;
        this.locatie = locatie;
    }

    public Persoon(Subject subject, String naam, String locatie) {
        this.subject = subject;
        this.subject.addSmsObserver(this);
        this.datetime = LocalDateTime.now();
        this.naam = naam;
        this.locatie = locatie;
    }

    @Override
    public void sendSMS() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm:ss a");

        System.out.println("\tSMS sent to " + getNaam()+", wonende te "+ getLocatie() + " geregistreerd op " + formatter.format(getDatetime()));
    }
}
