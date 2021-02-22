package model.exception;

import model.product.StockMovement;

public class MaximumStockException extends Exception {
    public MaximumStockException() {
        super("Stock assignment detected that would exceed the maximum. Too much stock is not allowed.");
    }

    public MaximumStockException(StockMovement stockMovement) {
        super("Stock assignment detected that would exceed the maximum by means of a stock movement (" +
                stockMovement.toString() + ") Too much stock is not allowed.");
    }
}
