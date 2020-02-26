import java.util.Hashtable;

public class Cart {

    private CartDao cartData = new CartDao("carletoc", "1683864");
    private Hashtable<String, Double> items;
    private double totalPrice;

    Cart(int id){
        items = cartData.items(id);
        totalPrice = 0;
    }


    public void add(){

    }

    public void remove(){

    }

    public Hashtable<String, Double> getItems(){
        return items;
    }

    public void checkout(){

    }
}
