package model.exception;

import model.product.StockMovement;

public class NegativeStockException extends Exception{

    public NegativeStockException() {
        super("Negative stock assignment detected. Negative stock is not allowed.");
    }

    public NegativeStockException(StockMovement stockMovement) {
        super("Negative stock assignment detected by means of a stock movement (" +
                stockMovement.toString() + ") Negative stock is not allowed.");
    }
}
