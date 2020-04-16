import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestCartDao {

    Map<Integer, ArrayList<Integer>> cart = new HashMap<Integer, ArrayList<Integer>>();
    Map<Integer, Inventory> inventory = new HashMap<>();
    int cart_item_id = 1;

    private Double price = 0.00;

    /**
     * @author Pragyee Nepal
     */
    public void addItem(int userId, int prodId){
        ArrayList<Integer> values = new ArrayList<Integer>(){{add(cart_item_id); add(userId); add(prodId);}};
        cart.put(cart_item_id, values);
        cart_item_id++;
    }

    /**
     * @author Pragyee Nepal
     */
    public void deleteItem(int userId, int prodId){
        Iterator<Integer> it = cart.keySet().iterator();
        while (it.hasNext()){
            Integer key = it.next();
            ArrayList<Integer> values = new ArrayList<Integer>(){{add(key);add(userId); add(prodId);}};
            if(cart.get(key).equals(values)){
                it.remove();
            }
        }
    }

    /**
     * @author Amran Hassan
     */
    public Double getCartPrice(int userId) {
        //Make an arrayList of prodIds that were found in the specifed user's cart
        ArrayList productIds = new ArrayList<ArrayList<Integer>>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : this.cart.entrySet()) {
            if (entry.getValue().get(1) == userId) {
                productIds.add(entry.getValue().get(2));
            }
        }
        //iterate through the arrayList of productIds, match them to Inventory Class and then get total price
        ArrayList productPrices = new ArrayList<ArrayList<Inventory>>();
        for (Map.Entry<Integer, Inventory> entry2 : this.inventory.entrySet()) {
            Iterator it = productIds.listIterator();
            while (it.hasNext()) {
                Integer key = (Integer) it.next();
                if (entry2.getValue().getProductId() == key) {
                    price += entry2.getValue().getProductPrice();
                    productPrices.add(entry2.getValue().getProductPrice());
                }
            }
        }
   return price;
}


    /**
     * @author Amran Hassan
     */
    public ArrayList<ArrayList<Integer>> getItemIds(int userId) {
        ArrayList cartItemsIds = new ArrayList<ArrayList<Integer>>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : this.cart.entrySet()) {
            if(entry.getValue().get(1)== userId) {
                cartItemsIds.add(entry.getKey());
            }
        }
    return cartItemsIds;
    }
}
