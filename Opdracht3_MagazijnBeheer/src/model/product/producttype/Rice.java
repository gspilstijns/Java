package model.product.producttype;

import factory.StockFactory;
import model.product.Product;
import model.product.Stock;

public class Rice extends Product {
    private static Rice instance;

    static {
        try {
            instance = new Rice(StockFactory.createRandomStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Rice getInstance()
    {
        return instance;
    }

    @Override
    public String productType() {
        return "Rice";
    }

    public Rice(int critical, int minimum, int maximum) {
        super(critical, minimum, maximum);
    }

    public Rice(Stock stock) {
        super(stock);
    }
}
