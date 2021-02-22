package model.product.movement;

import java.util.Random;

public enum MoveOut implements Movement {
    Sale, Reservation, Quarantine, Destruction ;
    private Random rnd = new Random();

    @Override
    public boolean checkAmmount(int ammount) {
        return ammount <= 0;
    }

    @Override
    public int randomAmmount() {
        return -1 * rnd.nextInt(24);
    }
}
