package factory;

import model.product.Stock;

import java.util.Random;

public class StockFactory {
    public static Stock createRandomStock()
    {
        // generate a random stock setting
        int rndCritical = new Random().nextInt(12 );
        int rndMinimum = new Random().nextInt(24 ) + 1 + rndCritical;
        int rndMaximum = (new Random().nextInt(8 ) + 2) * rndMinimum; // maximum is x times larger than minimum
        Stock randomStockSetting = new Stock(rndCritical, rndMinimum, rndMaximum);

        return randomStockSetting;
    }
}
