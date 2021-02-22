package ui;

import factory.ProductFactory;
import model.exception.MaximumStockException;
import model.exception.MovementNotAllowedException;
import model.exception.NegativeStockException;
import model.product.Product;
import model.product.producttype.ProductType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class WareHouse {
    public static void main(String[] args) {
        HashSet<Product> products = createRandomProducts();
        System.out.println(products.stream().count());
        System.out.printf(
                "Warehouse inventory : \n" + "-".repeat(80) + "\n" +
                        products.stream().map(p -> p.toString()).collect(Collectors.joining("\n " + "-".repeat(80) + "\n"))
        );

        //System.out.println(products.stream().count());
        //System.out.println(ProductType.values().toString());

    }
    public static HashSet<Product> createRandomProducts() {
        HashSet<Product> products = new HashSet<Product>();

        for (int i = 0; i < 10; i++) {

            try {
                products.add(ProductFactory.createRandomProduct());
            } catch (MaximumStockException e) {
                System.out.println(e);
            } catch (NegativeStockException e) {
                System.out.println(e);
            } catch (MovementNotAllowedException e) {
                System.out.println(e);
            }
        }
        return products;
    }
}
