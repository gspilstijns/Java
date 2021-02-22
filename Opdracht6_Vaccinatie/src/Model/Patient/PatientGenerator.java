package Model.Patient;

import java.util.Random;

public class PatientGenerator {
    //namen komen van https://statbel.fgov.be/nl/open-data
    private static String[] name = {"Agnes","Albert","Alexander","Alfons","André","Anita","Ann","Anna","Annie","Bart",
            "Bruno","Caroline","Charlotte","Christel","Christiane","Denise","Diana","Diane","Dirk","Eddy","Elisabeth",
            "Ellen","Els","Emma","Eric","Erik","Filip","François","Frank","Frans","Freddy","Geert","Gerda","Godelieve",
            "Greta","Guido","Guy","Hanne","Herman","Hilda","Hilde","Hugo","Ilse","Inge","Ingrid","Jan","Jean",
            "Jeannine","Jeroen","Joanna","Johan","Joseph","Jozef","Julie","Karel","Karen","Karin","Kelly","Kevin",
            "Kim","Koen","Kris","Kristel","Laura","Lea","Leo","Liliane","Linda","Lisette","Louis","Luc","Ludo",
            "Magdalena","Marc","Marcel","Maria","Marie","Marina","Marleen","Martine","Matthias","Michel","Monique",
            "Nadine","Nancy","Nathalie","Nick","Nicole","Patricia","Patrick","Paul","Paula","Peter","Raymond","René",
            "Rita","Robert","Robin","Roger","Ronny","Rudi","Sam","Sandra","Sarah","Sofie","Sonja","Steven","Sven",
            "Thomas","Tim","Tom","Veerle","Vera","Vincent","Walter","Willy","Wim" };

    private static Random random = new Random();
    public String GetPatientName(){
        var rnd = name[getRandom().nextInt(name.length)];
       return rnd;
    }
    public int GetPatientLeeftijd(){
        return getRandom().nextInt(100);
    }
    public String GetPatientRiziv(){
        return (getRandom().nextInt(90000) + 10000) + "-" + (getRandom().nextInt(90000) + 10000);
    }
    public static Random getRandom(){
        return random;
    }
}
