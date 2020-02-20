import java.sql.*;

public class UserDao {

    private Connection connection;
    private String address;

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

    //View User Cart
    public void cart(String user) {
        try {
            Statement viewUserCart = connection.createStatement();
            ResultSet rc = viewUserCart.executeQuery(
                    "SELECT " +
                            "FROM " +
                            "INNER JOIN "
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Return street address
    public String address(String name){
        try {
            Statement getUserAddress = connection.createStatement();
            ResultSet rs = getUserAddress.executeQuery(
                    "SELECT Users.shipping_address FROM Users WHERE user_name="+name
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

    //Return city
    /*
    public String city(int id) {

    }
     */

    //Return state

    //Return zipcode

    //Return email

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
