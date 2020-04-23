import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lila Crum
 */

class TestCartDaoTest {

    private TestCartDao cartData;

    @BeforeEach
    void setUp() {
        ArrayList<ArrayList<Integer>> cartItems = new ArrayList<ArrayList<Integer>>();
        ArrayList<Inventory> inventoryItems = new ArrayList<Inventory>();
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

        inventoryItems.add(prod1);
        inventoryItems.add(prod2);
        inventoryItems.add(prod3);
        inventoryItems.add(prod4);
        inventoryItems.add(prod5);
        inventoryItems.add(prod6);
        inventoryItems.add(prod7);
        inventoryItems.add(prod8);
        inventoryItems.add(prod9);
        inventoryItems.add(prod10);

        cartData = new TestCartDao(cartItems,inventoryItems);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void addItem() {
        Map <Integer, ArrayList<Integer>> currentCart = cartData.cart;
        int currentItemID = cartData.cart_item_id;

        assertTrue(currentCart.isEmpty());
        assertEquals(currentItemID,1);

        cartData.addItem(1,1);
        ArrayList<Integer> values = new ArrayList<Integer>(){{add(1); add(1); add(1);}};

        assertEquals(cartData.cart.get(1), values);
        assertEquals(2,cartData.cart_item_id);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void deleteItem() {
        cartData.addItem(1,2);
        assertFalse(cartData.cart.isEmpty());

        cartData.deleteItem(1,2);
        assertTrue(cartData.cart.isEmpty());
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getCartPrice() {
        cartData.addItem(1,3);
        cartData.addItem(1,4);

        assertEquals(cartData.getCartPrice(1),36.0);

    }

    /**
     * @author Lila Crum
     */
    @Test
    void getItemIds() {
        cartData.addItem(1,5);
        ArrayList<Integer> itemIds = cartData.getItemIds(1);
        assertEquals(itemIds.get(0),1);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void clearCart() {
        cartData.addItem(1,6);
        assertTrue(cartData.cart.containsKey(1));

        cartData.clearCart(1);

        assertFalse(cartData.cart.containsKey(1));
    }
}
