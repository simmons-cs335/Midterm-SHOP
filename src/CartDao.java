
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 Accesses the Shopping cart table using JDBC.
 */
public class CartDao{

    private Connection connection;

    // Constructor initializes database connection.
    CartDao(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_hassana?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Adding an item into a cart.
    public void addItem(String[] cols) {
        try {
            Statement insertItem = connection.createStatement();
            insertItem.execute(
                    "INSERT INTO ShoppingCart " +
                            "(cart_items_id, user_id, product_id)" +
                            " VALUES ('" + Integer.parseInt(cols[1]) + "', '" + Integer.parseInt(cols[2])
                            + "', '" + Integer.parseInt(cols[3])+ "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deleting an item from a cart.
    public void deleteItem(int id) {
        try {
            Statement deleteItem = connection.createStatement();
            deleteItem.execute(
                    "DELETE FROM ShoppingCart WHERE cart_items_id="+ id );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Getting Prices of Items in Cart
    public void itemPrice(int id) {
        try {
            Statement itemPrice = connection.createStatement();
            ResultSet rs = itemPrice.executeQuery(
                    "select ShoppingCart.user_id,ShoppingCart.cart_items_id, Inventory.product_id, Inventory.product_price" +
                            " from ShoppingCart, Inventory where ShoppingCart.product_id= Inventory.product_id AND user_id=" + id);
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt(1));
                System.out.println("CartItem ID: " + rs.getInt(2));
                System.out.println("Product ID: " + rs.getInt(3));
                System.out.println("Product Price: " + rs.getDouble(4));
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // Reads and prints all ro the Cart taws inble.
    public void list() {
        try {
            Statement selectItems = connection.createStatement();
            ResultSet rs = selectItems.executeQuery(
                    "SELECT cart_items_id, user_id, product_id FROM ShoppingCart");
            while (rs.next()) {
                System.out.println("Item: " + rs.getInt(1));       // Item Index
                System.out.println("UserID: " + rs.getInt(2));      // UserID
                System.out.println("ProductID: " + rs.getInt(3));  // Product ID
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }}}