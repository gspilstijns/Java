package model.product;

import model.exception.MaximumStockException;
import model.exception.MovementNotAllowedException;
import model.exception.NegativeStockException;
import model.product.movement.Movement;
import model.product.states.Critical;
import model.product.states.ProductState;
import java.util.LinkedList;

public abstract class Product {

    private ProductState productState;
    private LinkedList<StockMovement> stockMovements;
    private Stock stock;


    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public LinkedList<StockMovement> getStockMovements() {
        return stockMovements;
    }

    public void setStockMovements(LinkedList<StockMovement> stockMovements) {
        this.stockMovements = stockMovements;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public abstract String productType();

    public Product(int critical,int minimum, int maximum) {
        setStock(new Stock(critical,minimum,maximum));
        setStockMovements(new LinkedList<StockMovement>());
        setProductState(new Critical());
    }

    public Product(Stock stock) {
        setStock(stock);
        setStockMovements(new LinkedList<StockMovement>());
        setProductState(new Critical());
    }
    // Not in use anymore
    //public boolean moveStock(int amount, Movement movement) throws MovementNotAllowedException, NegativeStockException, MaximumStockException {
    //   return ProductState.moveStock(this, new StockMovement(amount, movement));
    //}

      public Boolean moveStock(StockMovement randomStockMovement) throws NegativeStockException, MaximumStockException {
        return ProductState.moveStock(this,randomStockMovement);
    }
    public Integer calculateTotalStock(){
        var stocklevel = 0;
        for (var stockMovement:stockMovements) {
            if (!stockMovement.isBlocked()){stocklevel +=stockMovement.getAmmount();}
        }
        return stocklevel;
    }
    public StringBuilder printStockMovements(){
        StringBuilder sB = new StringBuilder();
        var stockCount = 0;
        for (var stockMovement:stockMovements) {
            if (!stockMovement.isBlocked()){stockCount +=stockMovement.getAmmount();}
            sB.append(stockMovement.toString());
            sB.append(" || current stocklevel:"+stockCount);
            sB.append("\n");
        }
        return sB;
    }
    @Override
    public String toString() {
        return "Product " + productType() + "\n" +
                "stock levels   = " + getStock().toString() + "\n" +
                "Current total stock level  = " + calculateTotalStock() + "\n" +
                "product state   = " + productState.toString() + "\n" +
                "stock movements =\n" + printStockMovements() + "\n";
    }


}
