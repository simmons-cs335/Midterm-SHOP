//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

public class User {

    private UserDao userData = new UserDao("carletoc", "1683864");
    private String name;
    private Cart cart;
    private String address;
    private String email;


    User(int id){
        name = userData.name(id);
        cart = new Cart(id);
        address = userData.address(id);
        email = userData.email(id);
    }



    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }

    public Cart getCart(){
        return cart;
    }

    public String toString(){
        return (name + ", " + address);
    }
}
