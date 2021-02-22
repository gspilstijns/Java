package model.product.producttype;

import factory.StockFactory;
import model.product.Product;
import model.product.Stock;

public class Milk extends Product {
    private static Milk instance;

    static {
        try {
            instance = new Milk(StockFactory.createRandomStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Milk getInstance()
    {
        return instance;
    }
    @Override
    public String productType() {
        return "Milk";
    }

    public Milk(int critical, int minimum, int maximum) {
        super(critical, minimum, maximum);
    }

    public Milk(Stock stock) {
        super(stock);
    }


}
