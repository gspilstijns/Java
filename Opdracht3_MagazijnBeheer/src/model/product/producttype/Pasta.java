package model.product.producttype;

import factory.StockFactory;
import model.product.Product;
import model.product.Stock;

public class Pasta extends Product {
    private static Pasta instance;

    static {
        try {
            instance = new Pasta(StockFactory.createRandomStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Pasta getInstance()
    {
        return instance;
    }

    @Override
    public String productType() {
        return "Pasta";
    }

    public Pasta(int critical, int minimum, int maximum) {
        super(critical, minimum, maximum);
    }

    public Pasta(Stock stock) {
        super(stock);
    }
}
