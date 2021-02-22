package sms.campaign;

import sms.persoon.Subject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmsCampaign extends Subject {

    private String description;
    private LocalDateTime datetime;

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SmsCampaign(String description) {
        this.description = description;
        this.datetime = LocalDateTime.now();
    }

    @Override
    public void notifyAllObservers() {
        super.notifyAllObservers();


    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");

        return "\nSmsCampaign verzonden {" +
                "Vaccinatie ='" + description + '\'' +
                ", Verzenddatum=" + formatter.format(getDatetime()) +
                '}';
    }
}
