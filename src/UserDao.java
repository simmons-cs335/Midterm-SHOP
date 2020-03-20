import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Clara Carleton
 */

public class UserDao {

    private Connection connection;
    private String address;
    private String name;
    private ArrayList<User> users;
    boolean useDb = true;

    //Constructor
    UserDao(String user, String password){
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
     * Constructor that accepts a list of Users.
     * @param users list of books
     */
    UserDao(ArrayList<User> users) {
        this.useDb = false;
        this.users = users;
    }

    /**
     * Empty constructor to support adding users one-by-one.
     */
    UserDao() {
        this.useDb = false;
        this.users = new ArrayList<User>();
    }

    //Add user
    public void save(String[] cols){
        try {
            Statement insertUser = connection.createStatement();
            insertUser.execute(
                    "INSERT INTO Users " +
                            "(user_id, user_name, shipping_address, city, state, zip_code, email)" +
                            " VALUES ('" + cols[0] + "', '" + cols[1] + "', '" + cols[2] + "', '" + cols[3] + "', '" +
                            cols[4] + "', '" + cols[5] + "', '" + cols[6] + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Remove user
    public void delete(int id){
        try {
            Statement deleteUser = connection.createStatement();
            deleteUser.execute(
                    "DELETE from Users WHERE user_id="+ id
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Retrieve name
    public String name(int id){
        try {
            Statement getUserName = connection.createStatement();
            ResultSet rs = getUserName.executeQuery(
                    "SELECT Users.user_name FROM Users WHERE user_id="+id
            );
            while (rs.next()) {
                name = (rs.getString(1));
            }
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Return user's credit card number
    public String credit_num(int id){
        try {
            Statement getCreditNum = connection.createStatement();
            ResultSet rs = getCreditNum.executeQuery(
                    "SELECT card_number " +
                            "FROM PaymentMethod WHERE user_id="+id
            );
            while (rs.next()) {
                address = (rs.getString(1));
            }
            return address;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Return email
    public String email(int id){
        try {
            Statement getUserEmail = connection.createStatement();
            ResultSet rs = getUserEmail.executeQuery(
                    "SELECT Users.email FROM Users WHERE user_id="+id
            );
            while (rs.next()) {
                address = (rs.getString(1));
            }
            return address;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Read and print all users in USER
    public void list() {
        try {
            Statement selectUsers = connection.createStatement();
            ResultSet rs = selectUsers.executeQuery(
                    "SELECT user_id, user_name, shipping_address, city, state, zip_code, email FROM Users");
            // Iterate over result set and print each user's info.
            while (rs.next()) {
                System.out.println("User Id: " + rs.getInt(1));
                System.out.println("User Name: " + rs.getString(2));
                System.out.println("Shipping Address: " + rs.getString(3));
                System.out.println("City: " + rs.getString(4));
                System.out.println("State: " + rs.getString(5));
                System.out.println("Zip Code: " + rs.getString(6));
                System.out.println("Email: " + rs.getString(7));
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
