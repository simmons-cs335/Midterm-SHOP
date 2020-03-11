import java.util.Hashtable;

public class Cart {

    private CartDao cartData = new CartDao("carletoc", "1683864");
    private Hashtable<String, Double> items;
    private double totalPrice;

    private StateSalesTaxDao taxData = new StateSalesTaxDao("carletoc", "1683864");
    private Double taxRate;
    private Double finalPrice;

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

    public void checkout(int user_id){
        User user = new User(user_id);
        //If validation true
        System.out.println("Hello, " + user.getName() + ",\n\t Thank you for shopping with us! Your order " +
                "for $" + getFinalPrice(user_id) + " has gone through. \nYour purchases are on their way to " +
                user.getAddress() + ". A receipt has been sent to " + user.getEmail());
        cartData.clearCart(user_id);

        //If validation false
        //System.out.println("Please update your information");


    }
}
