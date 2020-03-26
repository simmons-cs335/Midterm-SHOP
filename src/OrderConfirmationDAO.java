import java.sql.*;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

/**
 * @ author Amran Hassan
 */

public class OrderConfirmationDAO {

    private Connection connection;

    // Constructor initializes database connection.
    OrderConfirmationDAO(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver" );
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_carletoc?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @ author Amran Hassan
     */
     
    //Inserts information to Order Confirmation Table
    public void save(int user_id, double final_price) {
        try {
            String query = ("INSERT INTO OrderConfirmation (user_id, final_price, purchase_date) " +
                    "VALUES (?,?,?)" );
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, user_id);
            st.setDouble(2, final_price);
            st.setDate(3, OrderConfirmation.getCurrentDate());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @ author Amran Hassan
     */
     
    //Reads and prints all products in Order
    public void list() {
        try {
            Statement OrderList = connection.createStatement();
            ResultSet rs = OrderList.executeQuery(
                    "SELECT order_id, user_id, final_price, purchase_date  FROM OrderConfirmation" );
            // Iterate over result set and print each book description.
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt(1));
                System.out.println("User ID: " + rs.getInt(2));
                System.out.println("Final Price: " + rs.getDouble(3));
                System.out.println("Date of Purchase: " + rs.getInt(4));
                System.out.println("\n" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
