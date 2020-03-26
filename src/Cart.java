import java.text.DecimalFormat;
import java.util.ArrayList;
 
/**
 * @author Amran Hassan & Clara Carleton & Lila Crum
 */


public class Cart {

    private static DecimalFormat df = new DecimalFormat("#.##");

    private CartDao cartData = new CartDao("carletoc", "1683864");
    private double totalPrice;

    private StateSalesTaxDao taxData = new StateSalesTaxDao("carletoc", "1683864");
    private ArrayList<Integer> item_ids;
 
    private OrderConfirmationDAO OrderConfirmationData = new OrderConfirmationDAO("carletoc", "1683864");
    
    /**
     * @author Amran Hassan
     */
    public void add(int userId, int prodId){
        cartData.addItem(userId, prodId);
    }

    /**
     * @author Amran Hassan
     */
    public void remove(int userId, int prodId){cartData.deleteItem(userId, prodId); }

    /**
     * @author Amran Hassan
     */
    public void price(int userId) {cartData.itemPrice(userId);}

    /**
     * @author Amran Hassan
     */
    public Double getCartPrice(int userId) {
        return cartData.itemPrice(userId);
    }

    /**
     * @author Amran Hassan
     */
    public Double getSalesTax(int userId) {
        return taxData.salesTax(userId);
    }

    /**
     * @author Amran Hassan
     */
    public Double getFinalPrice(int userId) {
        return getCartPrice(userId) + (getSalesTax(userId)*getCartPrice(userId));
    }

    /**
     * @author Amran Hassan
     */
    public void list(int userId) {cartData.list(userId);}

    /**
     * @author Clara Carleton
     */
    public ArrayList<Integer> getItemIds(int user_id) {return item_ids = cartData.getItemIds(user_id);}

    /**
     * @author Clara Carleton & Lila Crum & Amran Hassan
     */
    public void checkout(int user_id){
        User user = new User(user_id);
        Validations v = new Validations(user_id);
        System.out.println("*****"+user.getName() + " is now checking out"+"*****");
        if(v.validateAll()){
            System.out.println("Hello, " + user.getName() + ",\n\t Thank you for shopping with us! Your order " +
                    "for $" + df.format(getFinalPrice(user_id)) + " has gone through. \nYour purchases are on their way to " +
                    user.getAddress() + ". A receipt has been sent to " + user.getEmail());
            list(user_id);
            order.save(user_id, getFinalPrice(user_id)); //Transfers the data to OrderConfirmationTable
            cartData.clearCart(user_id);
        }else{
            System.out.println(user.getName() + ", please update your information");
        }
    }
}
