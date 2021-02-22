package model.exception;

import model.product.movement.Movement;

public class MovementNotAllowedException extends Exception {
    public MovementNotAllowedException(int ammount, Movement movement) {
        super("The ammount given to change stock(" + ammount + ") is " +
                "not accepted for this movement(" + movement.toString());
    }
}
