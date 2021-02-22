package sms;

import Model.Patient.PatientGenerator;
import sms.campaign.CampaignGenerator;
import sms.campaign.SmsCampaign;
import sms.persoon.Persoon;

import java.util.ArrayList;
import java.util.Random;

public class startSms {
    public static void main(String[] args) {
        var patientGen = new PatientGenerator();
        var campaignGen = new CampaignGenerator();
        var campaignsList = new ArrayList<SmsCampaign>();

        for (int i = 0;i<new Random().nextInt(30);i++){
            SmsCampaign campaign = new SmsCampaign(campaignGen.GetRandomCampaign());
            campaignsList.add(campaign);
            for (int j = 0; j<new Random().nextInt(200); j++) {
                //voor naam generatie, de generator uit de template oefening hergebruikt
                var naam = patientGen.GetPatientName();
                //voor locatie nieuwe generator in CampaignGenerator gezet
                var locatie = campaignGen.GetRandomLocation();
                new Persoon(campaign,naam,locatie);
            }
        }

        //verzenden van sms-en door status van sms campaigns op true te zetten (random generated)
        for (int i = 0;i<campaignsList.size();i++){
            var send = new Random().nextBoolean();
            if (send){
            System.out.println(campaignsList.get(i).toString());
            campaignsList.get(i).setState(true);
            }
        }


    }
}
