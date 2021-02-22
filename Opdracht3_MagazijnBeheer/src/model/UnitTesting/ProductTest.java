package model.UnitTesting;

import model.exception.MaximumStockException;
import model.exception.MovementNotAllowedException;
import model.exception.NegativeStockException;
import model.product.Product;
import model.product.StockMovement;
import model.product.movement.MoveIn;
import model.product.movement.MoveOut;
import model.product.producttype.ToiletPaper;
import model.product.states.ProductState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;
    private StockMovement stockMovement;

    @BeforeEach
    public void setUp() throws MovementNotAllowedException {
        product = new ToiletPaper(5,10,20);
        stockMovement = new StockMovement(5,MoveIn.Production);
    }
    @Test
    public void test_Accepted_Stock_Movement_MoveIn() throws MovementNotAllowedException {
        stockMovement = new StockMovement(5, MoveIn.Production);
        assertEquals(5,stockMovement.getAmmount());

    }
    @Test
    public void test_Stock_Movements_Not_Blocked() throws MovementNotAllowedException {
        stockMovement = new StockMovement(5, MoveIn.Production);
        assertFalse(stockMovement.isBlocked());
    }

    @Test
    public void test_Stock_Movements() throws MovementNotAllowedException, NegativeStockException, MaximumStockException {
        ProductState.moveStock(product,new StockMovement(15, MoveIn.Production));
        assertFalse(product.getStockMovements().getLast().isBlocked());
    }
    @Test
    public void test_Add_Movement_To_Product() throws MaximumStockException, NegativeStockException {
        ProductState.moveStock(product,stockMovement);
        assertEquals(5, product.calculateTotalStock());
    }
    @Test
    public void test_Calculate_Total_Stock() throws MaximumStockException, NegativeStockException {
        ProductState.moveStock(product,stockMovement);
        ProductState.moveStock(product,stockMovement);
        assertEquals(10, product.calculateTotalStock());
    }
}
