import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCartDaoTest {
    TestCartDao testcartdao;

    @BeforeEach
    void setUp() {
        testcartdao = new TestCartDao();
    }

    @Test
    void addItem() {
        ArrayList<Integer> exp_values = new ArrayList<Integer>();
        assertEquals(exp_values, testcartdao.getItemIds(1));
        testcartdao.addItem(1,3);
        exp_values.add(1);
        assertEquals(exp_values, testcartdao.getItemIds(1));

    }

    @Test
    void deleteItem() {
        testcartdao.addItem(2,2); testcartdao.addItem(2,3);
        ArrayList<Integer> exp_values = new ArrayList<Integer>(){{add(1); add(2);}};
        assertEquals(exp_values, testcartdao.getItemIds(2));
        testcartdao.deleteItem(2,3);
        exp_values.remove(1);
        assertEquals(exp_values,testcartdao.getItemIds(2));
    }

    @Test
    void getCartPrice() {
        Inventory inventory_Item = new Inventory(1, "Bedsheet", "Home",20,10,10,0,0);
        ArrayList<Integer> cart_item1 = new ArrayList<Integer>(){{add(1); add(2); add(1);}};
        ArrayList<Integer> cart_item2 = new ArrayList<Integer>(){{add(2); add(3); add(1);}};
        ArrayList<ArrayList<Integer>> items_in_cart = new ArrayList<>(){{add(cart_item1); add(cart_item2);}};
        ArrayList<Inventory> items_in_inventory = new ArrayList<>(){{add(inventory_Item);}};
        TestCartDao testcartdao1 = new TestCartDao(items_in_cart, items_in_inventory);
        assertEquals(20.0,testcartdao1.getCartPrice(2));
    }

    @Test
    void getItemIds() {
        ArrayList<Integer> exp_values = new ArrayList<Integer>();
        assertEquals(exp_values, testcartdao.getItemIds(2));
        testcartdao.addItem(2,2); testcartdao.addItem(2,3); testcartdao.addItem(1,2);
        ArrayList<Integer> exp_values2 = new ArrayList<Integer>(){{add(1); add(2);}};
        assertEquals(exp_values2, testcartdao.getItemIds(2));
    }

    @Test
    void clearCart() {
        testcartdao.addItem(1,3); testcartdao.addItem(2,2);
        ArrayList<Integer> exp_values = new ArrayList<Integer>(){{add(1);}};
        assertEquals(exp_values, testcartdao.getItemIds(1));
        ArrayList<Integer> exp_values2 = new ArrayList<Integer>(){{}};
        testcartdao.clearCart(1);
        assertEquals(exp_values2, testcartdao.getItemIds(1));
    }
}