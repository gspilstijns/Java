package factory;

import model.exception.MaximumStockException;
import model.exception.MovementNotAllowedException;
import model.exception.NegativeStockException;
import model.product.Product;
import model.product.producttype.*;

import java.util.Random;

public class ProductFactory {

    private static Product product;
    public static Product createProduct(ProductType productType){
        switch (productType) {
            case Milk:
                product = Milk.getInstance();
                break;
            case Pasta:
                product = Pasta.getInstance();
                break;
            case ToiletPaper:
                product = ToiletPaper.getInstance();
                break;
            case Rice:
                product = Rice.getInstance();
                break;
            case Soap:
                product = Soap.getInstance();
                break;
        }
        return product;
    }
    public static Product createRandomProduct() throws NegativeStockException, MovementNotAllowedException, MaximumStockException {
        // random product with default product type-settings
        int randomValue = new Random().nextInt(ProductType.values().length);
        Product randomProduct = createProduct(ProductType.values()[randomValue]);

        // add random stock movements
        for (int i = 0; i < new Random().nextInt(10); i++) {
            randomProduct.moveStock(StockMovementFactory.createRandomStockMovement());
        }

        return randomProduct;
    }
}
