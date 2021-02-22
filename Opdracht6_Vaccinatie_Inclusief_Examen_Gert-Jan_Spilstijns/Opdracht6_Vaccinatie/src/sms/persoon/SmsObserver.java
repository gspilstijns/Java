package sms.persoon;

public abstract class SmsObserver {
    protected Subject subject;
    public abstract void sendSMS();
}
