package factory;

import model.exception.MovementNotAllowedException;
import model.product.StockMovement;
import model.product.movement.Movement;

public class StockMovementFactory {
    public StockMovement createStockMovement(int amount, Movement movement) throws MovementNotAllowedException {
        try
        {
            return new StockMovement(amount, movement);
        } catch (MovementNotAllowedException e) {
            e.printStackTrace();
            // decision, to create to object with zero amount which should not be added to the movement-list
            return new StockMovement(0, movement);
        }
    }

    public static StockMovement createRandomStockMovement() throws MovementNotAllowedException
    {
        // generate a random type of movement and use that random type to generate a correct but random amount
        Movement randomMovementType = Movement.getRandomMovement();
        return new StockMovement(randomMovementType.randomAmmount(), randomMovementType);
    }
}
