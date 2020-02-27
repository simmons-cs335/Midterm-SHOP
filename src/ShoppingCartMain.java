public class ShoppingCartMain {
    public static void main(String[] args) {
        int max = 4;
        int min = 1;
        int id = (int)(Math.random()*(max-min+1)+min);
        User user = new User(id);
        Cart cart = user.getCart();
        System.out.println(cart.getItems(id));
        cart.add(id, 10);
        System.out.println(cart.getItems(id));
    }
    
}
