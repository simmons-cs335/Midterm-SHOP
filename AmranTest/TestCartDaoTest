import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartDAOTest {

   private int user_id = 1;

   Inventory inventoryItem1 = new Inventory(9,"ToothBrush", "Health", 5.77, 10, 5, 12 );
   Inventory inventoryItem2 = new Inventory(6 , "Necklace","Jewelry", 22, 10, 10, 0 );
   Inventory inventoryItem3 = new Inventory(9, "Heated blanket" ,"Home", 39.99, 10, 10, 0);
   Inventory inventoryItem4 = new Inventory(10, "Hair ties","Fashion", 5.59, 10, 10, 0);
   ArrayList<Integer> cartItem1 = new ArrayList<>(Arrays.asList(1,1,6));
   ArrayList<Integer> cartItem2 = new ArrayList<>(Arrays.asList(2,1,9));
   ArrayList<Integer> cartItem3 = new ArrayList<>(Arrays.asList(3,1,10));

   ArrayList<Inventory> inventoryItems = new ArrayList<Inventory>();
   ArrayList<ArrayList<Integer>> cartItems = new ArrayList<>();

   TestCartDao testCart;

   @BeforeEach
   void Setup(){
       inventoryItems = new ArrayList<Inventory>();
       cartItems = new ArrayList<>();
       inventoryItems.add(inventoryItem1);
       inventoryItems.add(inventoryItem2);
       inventoryItems.add(inventoryItem3);
       inventoryItems.add(inventoryItem4);
       cartItems.add(cartItem1);
       cartItems.add(cartItem2);
       cartItems.add(cartItem3);
       testCart= new TestCartDao(cartItems, inventoryItems);
   }

    @Test
    void testAddItem(){
        assertEquals(3, testCart.getItemIds(1).size());
        testCart.addItem(1,29);
        assertEquals(4, testCart.getItemIds(1).size());

    }

    @Test
    void testDeleteItem(){
        assertEquals(3, testCart.getItemIds(1).size());
        testCart.deleteItem(1,9);
        assertEquals(2, testCart.getItemIds(1).size());

    }

    @Test
    void testGetCartPrice(){
        assertEquals(67.58, testCart.getCartPrice(1));

    }

    @Test
    void testGetItemIds(){
       assertEquals(3, testCart.getItemIds(1).size());
       assertEquals(Arrays.asList(1,2,3),testCart.getItemIds(1));
    }

    @Test
    void testClearCart(){
        assertEquals(3, testCart.getItemIds(1).size());
        testCart.clearCart(1);
        assertEquals(0, testCart.getItemIds(1).size());
    }


}
