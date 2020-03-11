public class ShoppingCartMain {
    public static void main(String[] args) {
        User user = new User(1);
        Cart cart = user.getCart();
        cart.list(1);
        cart.checkout(1);
        cart.list(1);



    }
}

