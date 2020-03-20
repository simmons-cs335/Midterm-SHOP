import java.lang.String;

/**
 * @ author Clara Carleton
 */

public class User {

    private UserDao userData = new UserDao("carletoc", "1683864");
    private String name;
    private Cart cart;
    private Address address;
    private String c_num;
    private String email;


    User(int id){
        name = userData.name(id);
        cart = new Cart(id);
        address = new Address(id);
        email = userData.email(id);
        c_num = userData.credit_num(id);
    }

    public String getName(){ return name; }

    public String getEmail(){ return email; }

    public Address getAddress(){ return address;}

    public String getCredit() { return c_num;}

    public Cart getCart(){ return cart; }
}
