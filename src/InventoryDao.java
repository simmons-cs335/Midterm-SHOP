import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InventoryDao {

    private Connection connection;

    //Constructor
    InventoryDao(String user, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_carletoc?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Add product
    public void save(String[] cols){
        try {
            Statement insertUser = connection.createStatement();
            insertUser.execute(
                    "INSERT INTO Inventory " +
                            "(PRODUCT_ID, PRODUCT_NAME, PRODUCT_DEPARTMENT, PRODUCT_PRICE, INITIAL_QUANTITY, STOCK_QUANTITY, SOLD_UNITS)" +
                            " VALUES ('" + cols[0] + "', '" + cols[1] + "', '" + cols[2] + "', '" + cols[3] + "', '" +
                            cols[4] + "', '" + cols[5] + "', '" + cols[6] + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Remove product
    /*
    public void delete(){

    }
     */

    //Read and print all products in INVENTORY
    public void list() {
        try {
            Statement selectProducts = connection.createStatement();
            ResultSet rs = selectProducts.executeQuery(
                    "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DEPARTMENT, PRODUCT_PRICE, INITIAL_QUANTITY, STOCK_QUANTITY, SOLD_UNITS FROM Inventory");
            // Iterate over result set and print each book description.
            while (rs.next()) {
                System.out.println("Product Id: " + rs.getInt(1));
                System.out.println("Product Name: " + rs.getString(2));
                System.out.println("Product Department: " + rs.getString(3));
                System.out.println("Product Price: " + rs.getDouble(4));
                System.out.println("Initial Quantity: " + rs.getInt(5));
                System.out.println("Stock Quantity: " + rs.getInt(6));
                System.out.println("Sold Units: " + rs.getInt(7));
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
