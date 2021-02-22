package model.product;

import model.exception.MovementNotAllowedException;
import model.product.movement.Movement;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class StockMovement {
    private LocalDateTime timestamp;
    private int ammount;
    private Movement movement;
    private boolean blocked;
    private int stock;


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public StockMovement(int ammount, Movement movement) throws MovementNotAllowedException {

        if (!movement.checkAmmount(ammount))
        {
            throw new MovementNotAllowedException(ammount, movement);
        }
        this.ammount = ammount;
        this.movement = movement;
        this.blocked = false;
        this.timestamp = LocalDateTime.now();
    }
    public StockMovement(int ammount, Movement movement, boolean blocked) throws MovementNotAllowedException
    {
        new StockMovement(ammount, movement);
        this.blocked = blocked;
    }


    public String blockedString()
    {
        String result;
        if(isBlocked()) { result = "is blocked"; }
        else { result = "is accepted";}
        return result;
    }

    @Override
    public String toString() {
        return "stock movement ammount: " + getAmmount() + " " + getMovement().toString() + " stockmovement " + blockedString();
    }

}
