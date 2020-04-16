import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestInventoryDaoTest {

    /**
     * @author Lila Crum
     */

    private TestInventoryDao productData;

    @BeforeEach
    void setUp(){
        ArrayList<Inventory> productList = new ArrayList<Inventory>();

        Inventory prod1 = new Inventory(1,"USB thumb drive","Electronics",22.63);
        Inventory prod2 = new Inventory(2,"Tooth brush","Health",4.99);
        Inventory prod3 = new Inventory(3,"Bed sheet","Home",20);
        Inventory prod4 = new Inventory(4,"Woman's belt","Fashion",16);
        Inventory prod5 = new Inventory(5,"Iron","Home",39.99);
        Inventory prod6 = new Inventory(6,"Necklace","Jewelry",22);
        Inventory prod7 = new Inventory(7,"Cardigan","Fashion",40);
        Inventory prod8 = new Inventory(8,"Laptop","Electronics",700);
        Inventory prod9 = new Inventory(9,"Heated blanket","Home",39.99);
        Inventory prod10 = new Inventory(10,"Hair ties","Fashion",5.59);

        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);
        productList.add(prod5);
        productList.add(prod6);
        productList.add(prod7);
        productList.add(prod8);
        productList.add(prod9);
        productList.add(prod10);

        productData = new TestInventoryDao(productList);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void numberOfProducts() { assertEquals(10,productData.numberOfProducts(1)); }

    /**
     * @author Lila Crum
     */
    @Test
    void addStock() {
        int currentStock = productData.checkStockLeft(2);
        assertEquals(10,currentStock);
        productData.addStock(2);
        currentStock+=3;
        assertEquals(currentStock, productData.checkStockLeft(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void productName() { assertEquals("Heated blanket", productData.productName(9)); }

    /**
     * @author Lila Crum
     */
    @Test
    void productDepartment() {
        assertEquals("Home",productData.productDepartment(5));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void productPrice() {
        assertEquals(20, productData.productPrice(3));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void checkInitialQuantity() {
        assertEquals(10,productData.checkInitialQuantity(6));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void checkStockLeft() {
        assertEquals(10,productData.checkStockLeft(8));
        productData.addStock(8);
        assertEquals(13,productData.checkStockLeft(8));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void checkSoldAmount() { assertEquals(0,productData.checkSoldAmount(7)); }

}
