import java.util.ArrayList;

/**
 * @ author Clara Carleton
 */

public class Multithreading extends Thread{
    private int user_id;
    public Multithreading(int user_id){
        this.user_id = user_id;
    }
    public void run() {
        User user = new User(user_id);
        Cart cart = user.getCart();
        try {
            System.out.println("*****"+user.getName() + " has started shopping"+"*****");
            //adding or removing items
            for(int i=0; i<8; i++){
                int random_item = (int)(Math.random()*(10-1+1)+1);
                cart.add(user_id, random_item);
                System.out.println("+++ " + user.getName() + " added an item...");
            }
            for(int j=0; j<3; j++){
                ArrayList<Integer> cart_items = cart.getItemIds(user_id);
                int random_item = (int)(Math.random()*(cart_items.size()+1));
                cart.remove(user_id, cart_items.get(random_item));
                System.out.println("--- " + user.getName() + " removed an item...");
            }
            cart.checkout(user_id);
        } catch (Exception e){
            System.out.println("*****"+user.getName() + " was interrupted"+"*****");
        }
        System.out.println("*****"+user.getName() + " has stopped shopping"+"*****");
    }
}
