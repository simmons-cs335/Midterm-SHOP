/*
  Created by Bob Zwolinski 2019-03-30
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 Accesses the Shopping cart table using JDBC.
 */
public class StateTaxDao{
    private Connection connection;

    // Constructor initializes database connection.
    StateTaxDao(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_hassana?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Getting StateTaxRate from the stateInitial
    // variable taxRate = salestax
    public void stateTax(String initial) {
        try {
            Statement state= connection.createStatement();
            ResultSet taxRate =state.executeQuery(
                    "select state_tax_rate from StateSalesTax where state_initial=" + initial
            );
            while (taxRate.next()) {
                System.out.println("The State Tax for " + initial+ " is: "+taxRate.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Reads and prints all of the stateTax table info.
    public void list() {
        try {
            Statement selectItems = connection.createStatement();
            ResultSet rs;
            rs = selectItems.executeQuery(
                    "SELECT state_id, state_initial, state_name, state_tax_rate FROM StateSalesTax");
            while (rs.next()) {
                System.out.println("state_id: " + rs.getInt(1));       // Item Index
                System.out.println("state_initial: " + rs.getString(2));       // Item Index
                System.out.println("state_name: " + rs.getString(3));      // UserID
                System.out.println("state_tax_rate: " + rs.getDouble(4));  // Product ID
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }}}
