package model.product.producttype;

import factory.StockFactory;
import model.product.Product;
import model.product.Stock;

public class Soap extends Product {
    private static Soap instance;

    static {
        try {
            instance = new Soap(StockFactory.createRandomStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Soap getInstance()
    {
        return instance;
    }

    public Soap(int critical, int minimum, int maximum) {
        super(critical, minimum, maximum);
    }

    public Soap(Stock stock) {
        super(stock);
    }

    @Override
    public String productType() {
        return "Soap";
    }
}
