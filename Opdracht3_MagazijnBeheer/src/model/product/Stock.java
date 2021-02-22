package model.product;

import model.exception.MaximumStockException;
import model.exception.NegativeStockException;

public class Stock {
    private int minimumLevel;
    private int criticalLevel;
    private int maximumLevel;
    private int stock;

    public int getMinimumLevel() {
        return minimumLevel;
    }

    public void setMinimumLevel(int minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public int getCriticalLevel() {
        return criticalLevel;
    }

    public void setCriticalLevel(int criticalLevel) {
        this.criticalLevel = criticalLevel;
    }

    public int getMaximumLevel() {
        return maximumLevel;
    }

    public void setMaximumLevel(int maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws NegativeStockException, MaximumStockException {
        if (stock<0){
            throw new NegativeStockException();
        }
        else if (stock >getMaximumLevel()){
            throw new MaximumStockException();
        }
        this.stock = stock;

    }

    public Stock() {
        this.stock = 0;
    }

    public Stock(int minimumLevel, int criticalLevel, int maximumLevel) {
        this.minimumLevel = minimumLevel;
        this.criticalLevel = criticalLevel;
        this.maximumLevel = maximumLevel;
        this.stock = 0;
    }

    public boolean validateMovementAmount(StockMovement stockMovement) throws MaximumStockException, NegativeStockException
    {
        if (!((getStock() + stockMovement.getAmmount()) <= getMaximumLevel()))
        {
            throw new MaximumStockException(stockMovement);
        }
        else if ((getStock() + stockMovement.getAmmount()) <0)
        {
            throw new NegativeStockException(stockMovement);
        }
        return ((getStock() + stockMovement.getAmmount()) <= getMaximumLevel()) && ((getStock() + stockMovement.getAmmount()) >= getCriticalLevel() ||
                        (stockMovement.getAmmount() > 0));

    }

    @Override
    public String toString() {
        return String.format("critical: %5d, minimum: %5d, maximum: %5d", getCriticalLevel(), getMinimumLevel(), getMaximumLevel());
    }
}
