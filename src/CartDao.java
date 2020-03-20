
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

public class CartDao{

    private static DecimalFormat df = new DecimalFormat("#.##");

    private Connection connection;
    private double price;
    private double totalPrice;

    // Constructor initializes database connection.
    CartDao(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_carletoc?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Adding an item into a cart.
    public void addItem(int userId, int prodId) {
        try {
            Statement insertItem = connection.createStatement();
            insertItem.execute(
                    "INSERT INTO ShoppingCart (user_id, product_id)" +
                            "VALUES ("+ userId + "," + prodId +")"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deleting an item from a cart.
    public void deleteItem(int userId, int prodId) {
        try {
            Statement deleteItem = connection.createStatement();
            deleteItem.execute(
                    "DELETE FROM ShoppingCart WHERE (product_id = '" + prodId +
                            "' AND user_id = '" + userId + "') ORDER BY cart_items_id ASC LIMIT 1 "
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Getting Prices of Items in Cart
    public Double itemPrice(int id) {
        try {
            Statement itemPrice = connection.createStatement();
            ResultSet rs = itemPrice.executeQuery(
                    "SELECT Inventory.product_price FROM Inventory INNER JOIN ShoppingCart " +
                            "ON Inventory.product_id=ShoppingCart.product_id WHERE ShoppingCart.user_id= "+ id);
            while (rs.next()) {
                price = (rs.getDouble(1));
                totalPrice += price;
            }
            return totalPrice;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @ author Clara Carleton
     */
    //Returns an arraylist of the item ids
    public ArrayList<Integer> getItemIds(int user_id){
        ArrayList<Integer> item_ids = new ArrayList<>();
        try {
            Statement getItemsIds = connection.createStatement();
            ResultSet rs = getItemsIds.executeQuery(
                    "SELECT ShoppingCart.cart_items_id " +
                            "FROM ShoppingCart WHERE ShoppingCart.user_id="+user_id
            );
            while (rs.next()) {
                item_ids.add(rs.getInt(1));
            }
            return item_ids;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @ author Clara Carleton
     */
    //Clears user's cart after completing the purchase
    public void clearCart(int user_id){
        try {
            Statement clearCart = connection.createStatement();
            clearCart.execute(
                    "DELETE FROM ShoppingCart WHERE user_id =" + user_id
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Put items in a HashTable
    public Hashtable<String, Double> items(int id){
        Hashtable<String, Double> items = new Hashtable();
        try {
            Statement getItems = connection.createStatement();
            ResultSet rs = getItems.executeQuery(
                    "SELECT Inventory.product_name, Inventory.product_price " +
                            "FROM Inventory INNER JOIN ShoppingCart " +
                            "ON Inventory.product_id=ShoppingCart.product_id WHERE ShoppingCart.user_id="+id
            );
            while (rs.next()) {
                items.put(rs.getString(1),rs.getDouble(2));
            }
            return items;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Reads and prints all items in a user's cart
    public void list(int id) {
        try {
            Statement selectItems = connection.createStatement();
            ResultSet rs = selectItems.executeQuery(
                    "SELECT Inventory.product_name, Inventory.product_price " +
                            "FROM Inventory INNER JOIN ShoppingCart " +
                            "ON Inventory.product_id=ShoppingCart.product_id WHERE ShoppingCart.user_id="+id);
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println("$"+df.format(rs.getDouble(2)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}