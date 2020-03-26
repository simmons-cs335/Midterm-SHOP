import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Amran Hassan
 */

public class InventoryDao {

    private Connection connection;
    private ArrayList<Inventory> products;
    boolean useDb = true;
    private String productName;
    private String productDepartment;
    private double productPrice;
    private int initialQuantity;
    private int soldUnits;
    private int stockQuantity;
    private int numberOfProducts;

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

    /**
     * Constructor that accepts a list of Products.
     */
    InventoryDao(ArrayList<Inventory> products) {
        this.useDb = false;
        this.products = products;
    }

    /**
     * Empty constructor to support adding users one-by-one.
     */
    InventoryDao() {
        this.useDb = false;
        this.products = new ArrayList<Inventory>();
    }

    /**
     * @author Amran Hassan
     */
    //Checks the Amount of Products listed in Inventory
    public Integer numberOfProducts(int prodId){
        try {
            Statement amountOfProducts = connection.createStatement();
            ResultSet rs = amountOfProducts.executeQuery(
                    "SELECT COUNT(product_id) FROM Inventory");
            while (rs.next()) {
                numberOfProducts = (rs.getInt(1));
            }
            return numberOfProducts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Adds Stock to a product
    public void addStock(int prodId){
        try {
            Statement addStock = connection.createStatement();
            addStock.execute(
                    "UPDATE Inventory SET stock_quantity = stock_quantity + 10 WHERE product_id = " + prodId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Amran Hassan
     */
    //Returns Product Name
    public String productName(int prodId){
        try {
            Statement getProductName = connection.createStatement();
            ResultSet rs = getProductName.executeQuery(
                    "SELECT PRODUCT_NAME FROM Inventory WHERE product_id =" + prodId );
            while (rs.next()) {
                productName = (rs.getString(1));
            }
            return productName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Amran Hassan
     */
    //Returns the Department the product belongs to
    public String productDepartment(int prodId){
        try {
            Statement getProductDepartment = connection.createStatement();
            ResultSet rs = getProductDepartment.executeQuery(
                    "SELECT PRODUCT_DEPARTMENT FROM Inventory WHERE product_id =" + prodId );
            while (rs.next()) {
                productDepartment = (rs.getString(1));
            }
            return productDepartment;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Amran Hassan
     */
    //Returns the Price of the Product
    public Double productPrice(int prodId){
        try {
            Statement getProductPrice = connection.createStatement();
            ResultSet rs = getProductPrice.executeQuery(
                    "SELECT PRODUCT_PRICE  FROM Inventory WHERE product_id =" + prodId );
            while (rs.next()) {
                productPrice = (rs.getDouble(1));
            }
            return productPrice;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Amran Hassan
     */
    //Returns the number of products initially given
    public Integer checkInitialQuantity(int prodId){
        try {
            Statement getInitialQuantity = connection.createStatement();
            ResultSet rs = getInitialQuantity.executeQuery(
                    "SELECT initial_quantity FROM Inventory WHERE product_id =" + prodId );
            while (rs.next()) {
                initialQuantity = (rs.getInt(1));
            }
            return initialQuantity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Amran Hassan
     */
    //Checks the amount of units left in stock
    public Integer checkStockLeft(int prodId){
        try {
            Statement getStockQuantity = connection.createStatement();
            ResultSet rs = getStockQuantity.executeQuery(
                    "SELECT STOCK_QUANTITY FROM Inventory WHERE product_id =" + prodId );
            while (rs.next()) {
                stockQuantity = (rs.getInt(1));
            }
            return stockQuantity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Amran Hassan
     */
    // checks amount of sold units
    public Integer checkSoldAmount(int prodId){
        try {
            Statement getSoldUnits = connection.createStatement();
            ResultSet rs = getSoldUnits.executeQuery(
                    "SELECT SOLD_UNITS FROM Inventory WHERE product_id =" + prodId );
            while (rs.next()) {
                soldUnits = (rs.getInt(1));
            }
            return soldUnits;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Amran Hassan
     */
    //Adds a new product to Inventory List
    public void addProduct(String[] cols){
        try {
            Statement deleteProduct = connection.createStatement();
            deleteProduct.execute(
                    "INSERT INTO Inventory " +
                            "(PRODUCT_ID, PRODUCT_NAME, PRODUCT_DEPARTMENT, PRODUCT_PRICE, INITIAL_QUANTITY, STOCK_QUANTITY, SOLD_UNITS)" +
                            " VALUES ('" + cols[0] + "', '" + cols[1] + "', '" + cols[2] + "', '" + cols[3] + "', '" +
                            cols[4] + "', '" + cols[5] + "', '" + cols[6] + "', '" +  cols[7] + "')"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Amran Hassan
     */
    //Removes a product from Inventory List
    public void delete(int prodId){
        try {
            Statement deleteProduct = connection.createStatement();
            deleteProduct.execute(
                    "DELETE PRODUCT_ID, PRODUCT_NAME, PRODUCT_DEPARTMENT, PRODUCT_PRICE, " +
                            "INITIAL_QUANTITY, STOCK_QUANTITY, SOLD_UNITS FROM Inventory WHERE user_id="+ prodId
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Amran Hassan
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




