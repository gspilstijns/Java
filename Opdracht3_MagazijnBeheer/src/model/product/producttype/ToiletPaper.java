package model.product.producttype;

import factory.StockFactory;
import model.product.Product;
import model.product.Stock;

public class ToiletPaper extends Product {
    private static ToiletPaper instance;

    static {
        try {
            instance = new ToiletPaper(StockFactory.createRandomStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ToiletPaper getInstance()
    {
        return instance;
    }

    @Override
    public String productType() {
        return "ToiletPaper";
    }

    public ToiletPaper(int critical, int minimum, int maximum) {
        super(critical, minimum, maximum);
    }

    public ToiletPaper(Stock stock) {
        super(stock);
    }
}
