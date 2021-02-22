package model.product.movement;

import java.util.Random;

public enum MoveIn implements Movement {
    Purchase, Production, Return;

    private Random rnd = new Random();
    @Override
    public boolean checkAmmount(int ammount) {
        return ammount >= 0;
    }

    @Override
    public int randomAmmount() {
        return rnd.nextInt(24);
    }



}
