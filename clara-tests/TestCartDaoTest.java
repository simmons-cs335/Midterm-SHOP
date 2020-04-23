import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartDaoTest {

    private int userId = 1;

    private Inventory inventoryitem1 = new Inventory(1, "USB thumb drive", "Electronics", 22.63, 10, 10, 0,0);
    private ArrayList<Integer> cartitem1 = new ArrayList<>(Arrays.asList(21,1,1));
    private ArrayList<Integer> cartitem2 = new ArrayList<>(Arrays.asList(22,2,1));

    private ArrayList<Inventory> inventoryItems;
    private ArrayList<ArrayList<Integer>> cartItems;

    TestCartDao cart;

    @BeforeEach
    void setup(){
        inventoryItems = new ArrayList<Inventory>();
        cartItems = new ArrayList<>();
        inventoryItems.add(inventoryitem1);
        cartItems.add(cartitem1);
        cartItems.add(cartitem2);
        cart = new TestCartDao(cartItems, inventoryItems);
    }

    @Test
    void testAddItem(){
        assertEquals(1, cart.getItemIds(1).size());
        cart.addItem(1,1);
        assertEquals(2, cart.getItemIds(1).size());
    }

    @Test
    void testDeleteItem(){
        assertEquals(1, cart.getItemIds(1).size());
        cart.deleteItem(1,1);
        assertEquals(0, cart.getItemIds(1).size());
    }

    @Test
    void testGetCartPrice(){
        assertEquals(22.63, cart.getCartPrice(1));
    }

    @Test
    void testGetItemIds(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(21));
        ArrayList<Integer> actual = cart.getItemIds(1);

        assertEquals(1, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void testClearCart(){
        assertEquals(1, cart.getItemIds(1).size());
        cart.clearCart(userId);
        assertEquals(0, cart.getItemIds(1).size());
    }
}
