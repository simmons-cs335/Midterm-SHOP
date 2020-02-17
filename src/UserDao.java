import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

    private Connection connection;

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

    //Add user
    public void save(String[] cols){
        try {
            Statement insertUser = connection.createStatement();
            insertUser.execute(
                    "INSERT INTO Users " +
                            "(USER_ID, USER_NAME, SHIPPING_ADDRESS, CITY, STATE, ZIP_CODE, EMAIL)" +
                            " VALUES ('" + cols[0] + "', '" + cols[1] + "', '" + cols[2] + "', '" + cols[3] + "', '" +
                            cols[4] + "', '" + cols[5] + "', '" + cols[6] + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Remove user
    /*
    public void delete(){

    }
     */

    //Read and print all users in USER
    public void list() {
        try {
            Statement selectUsers = connection.createStatement();
            ResultSet rs = selectUsers.executeQuery(
                    "SELECT USER_ID, USER_NAME, SHIPPING_ADDRESS, CITY, STATE, ZIP_CODE, EMAIL FROM Users");
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
