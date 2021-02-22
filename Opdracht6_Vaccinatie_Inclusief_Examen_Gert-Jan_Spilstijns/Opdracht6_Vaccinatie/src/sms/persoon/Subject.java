package sms.persoon;

import sms.persoon.SmsObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<SmsObserver> smsObservers = new ArrayList<>();
    private boolean state;

    public List<SmsObserver> getSmsObservers() {
        return smsObservers;
    }

    public void setSmsObservers(List<SmsObserver> smsObservers) {
        this.smsObservers = smsObservers;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
        if (state) {
            notifyAllObservers();
        }
    }

    public void addSmsObserver(SmsObserver smsObserver) {
        smsObservers.add(smsObserver);
    }

    public void notifyAllObservers() {
        for (SmsObserver smsObserver : smsObservers) {
            smsObserver.sendSMS();
        }
    }


}
