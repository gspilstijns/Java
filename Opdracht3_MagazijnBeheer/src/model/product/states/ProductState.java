package model.product.states;

import model.exception.MaximumStockException;
import model.exception.NegativeStockException;
import model.product.Product;
import model.product.Stock;
import model.product.StockMovement;

public interface ProductState {
    String toString();
    static ProductState checkProductState(Stock stock)
    {
        if (stock.getStock() <= stock.getCriticalLevel())
        {
            return new Critical();
        } else if (stock.getStock() <= stock.getMinimumLevel())
        {
            return new Minimum();
        } else if (stock.getStock() < stock.getMaximumLevel())
        {
            return new Normal();
        } else {
            return new Maximum();
        }
    }


    static Boolean moveStock(Product product, StockMovement stockMovement) throws MaximumStockException, NegativeStockException {
      try {
          stockMovement.setBlocked(!product.getStock().validateMovementAmount(stockMovement));
      }
      catch (Exception e){
          stockMovement.setBlocked(true);
      }
      finally {
          product.getStockMovements().add(stockMovement);

          if (!stockMovement.isBlocked()) {
              product.getStock().setStock(product.getStock().getStock() + stockMovement.getAmmount());
              product.setProductState(ProductState.checkProductState(product.getStock()));
              return true;
          } else {
              return false;
          }
      }
    }
}
