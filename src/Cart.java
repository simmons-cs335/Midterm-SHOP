import java.util.Hashtable;

public class Cart {

    private CartDao cartData = new CartDao("carletoc", "1683864");
    private Hashtable<String, Double> items;
    private double totalPrice;

    Cart(int userId){
        totalPrice = 0;
    }


    public void add(int userId, int prodId){
        cartData.addItem(userId, prodId);
    }

    public void remove(){

    }

    public Hashtable<String, Double> getItems(int userId){
        items = cartData.items(userId);
        return items;
    }

    public void checkout(){

    }
}
