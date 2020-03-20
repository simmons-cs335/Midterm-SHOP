import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Clara Carleton
 */

public class AddressDao {
    private Connection connection;
    private ArrayList<Address> addresses;
    boolean useDb = true;

    // Constructor initializes database connection.
    AddressDao(String user, String password) {
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
     * Constructor that accepts a list of Addresses.
     * @param addresses list of books
     */
    AddressDao(ArrayList<Address> addresses) {
        this.useDb = false;
        this.addresses = addresses;
    }

    /**
     * Empty constructor to support adding addresses one-by-one.
     */
    AddressDao() {
        this.useDb = false;
        this.addresses = new ArrayList<Address>();
    }

    public ArrayList<String> getAddress(int user_id){
        ArrayList<String> addressInfo = new ArrayList<String>();
        try {
            Statement getAddress = connection.createStatement();
            ResultSet rs = getAddress.executeQuery(
                    "SELECT shipping_address, city, state, zip_code " +
                            "FROM Address INNER JOIN Users " +
                            "ON Address.address_id=Users.address_id WHERE Users.user_id="+user_id
            );
            while (rs.next()) {
                addressInfo.add(rs.getString(1));
                addressInfo.add(rs.getString(2));
                addressInfo.add(rs.getString(3));
                addressInfo.add(rs.getString(4));
            }
            return addressInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
