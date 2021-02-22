package sms.campaign;

import java.util.Random;

public class CampaignGenerator {
    private static String[] campaign = {"COVID19","INFLUENZA","HOEST" };
    private static String[] locaties = {"Tongeren", "Bilzen","Hoeselt","Hasselt"};
    private static Random random = new Random();
    public String GetRandomCampaign(){
       return campaign[getRandom().nextInt(campaign.length)];
    }
    public static Random getRandom(){
        return random;
    }

    public String GetRandomLocation() {

        return locaties[getRandom().nextInt(locaties.length)];
    }
}
