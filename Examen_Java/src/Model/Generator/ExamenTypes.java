package Model.Generator;

import java.util.Random;

public class ExamenTypes {
    private static String[] examenTypes = {"examen1","examen2","examen3"};

    private static Random random = new Random();

    public static Random getRandom() {
        return random;
    }

    public String getRandomExamen() {
        var examen = examenTypes[getRandom().nextInt(examenTypes.length)];
        return examen;
    }
}
