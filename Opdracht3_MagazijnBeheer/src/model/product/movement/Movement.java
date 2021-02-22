package model.product.movement;

import java.util.Random;

public interface Movement {
    boolean checkAmmount(int ammount);
    int randomAmmount();
    static Movement getRandomMovement(){
        int randomValue = new Random().nextInt(MoveIn.values().length + MoveOut.values().length);
        if (randomValue<MoveIn.values().length)
        {
            return MoveIn.values()[randomValue];
        }
        else {
            return MoveOut.values()[randomValue - MoveIn.values().length];
        }
    }
}
