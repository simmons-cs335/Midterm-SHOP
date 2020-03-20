import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

public class Cart {

    private static DecimalFormat df = new DecimalFormat("#.##");

    private CartDao cartData = new CartDao("carletoc", "1683864");
    private Hashtable<String, Double> items;
    private double totalPrice;

    private StateSalesTaxDao taxData = new StateSalesTaxDao("carletoc", "1683864");
    private Double taxRate;
    private Double finalPrice;
    private ArrayList<Integer> item_ids;

    Cart(int id){
    }


    public void add(int userId, int prodId){
        cartData.addItem(userId, prodId);
    }

    public void remove(int userId, int prodId){cartData.deleteItem(userId, prodId); }

    public Hashtable<String, Double> getItems(int userId){
        items = cartData.items(userId);
        return items;
    }
    public void price(int userId) {cartData.itemPrice(userId);}

    public Double getCartPrice(int userId) {
        /*
        totalPrice = cartData.itemPrice(userId);
        return totalPrice;
         */
        return cartData.itemPrice(userId);
    }

    public Double getSalesTax(int userId) {
        /*
        taxRate= taxData.salesTax(userId);
        return taxRate;
         */
        return taxData.salesTax(userId);
    }

    public Double getFinalPrice(int userId) {
        //finalPrice = totalPrice + (taxRate*totalPrice);
        return getCartPrice(userId) + (getSalesTax(userId)*getCartPrice(userId));
    }

    public void list(int userId) {cartData.list(userId);}

    public ArrayList<Integer> getItemIds(int user_id) {return item_ids = cartData.getItemIds(user_id);}

    public void checkout(int user_id){
        User user = new User(user_id);
        Validations v = new Validations(user_id);
        System.out.println("*****"+user.getName() + " is now checking out"+"*****");
        if(v.validateAll()){
            System.out.println("Hello, " + user.getName() + ",\n\t Thank you for shopping with us! Your order " +
                    "for $" + df.format(getFinalPrice(user_id)) + " has gone through. \nYour purchases are on their way to " +
                    user.getAddress() + ". A receipt has been sent to " + user.getEmail());
            list(user_id);
            cartData.clearCart(user_id);
        }else{
            System.out.println(user.getName() + ", please update your information");
        }
    }
}
