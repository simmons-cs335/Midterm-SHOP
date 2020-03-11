import java.util.ArrayList;

public class runProgram {
    public runProgram(){

    }
    public void runIt(){
        int max = 4;
        int min = 1;
        int id = (int)(Math.random()*(max-min+1)+min);
        User user = new User(id);
        Cart cart = user.getCart();
        System.out.println(cart.getItems(id));
        ArrayList<Integer> prod_id_of_cart = new ArrayList<>();
        String exit = "N";
        while (exit.equals("N")){
            //adding items to the cart - 10 items
            for (int i = 0; i < 10; i++) {
                int rand = (int) (Math.random() * 10);
                System.out.println(rand); //remove this line
                cart.add(id, rand);
                System.out.println("You have added item "+rand+" to your cart");
                prod_id_of_cart.add(rand);
            }
            System.out.println("The items in your cart are: \n"+cart.getItems(id));
            //removing items from the cart- 3 items
            int i = 0;
            int rand1 = (int) (Math.random() * 3);
            while (prod_id_of_cart.contains(rand1) && i<3){
                cart.remove();//cart.remove(id, rand1);
                System.out.println("You have removed item "+rand1+" from your cart");
                rand1 = (int) (Math.random() * 3);
                i++;
            }

            System.out.println("You are proceeding towards checkout");
            Validations validate = new Validations(id);
            if (validate.validateAll()){
                System.out.println("Your address, email address and payment has been validated");
                Checkout checkOut = new Checkout(cart.getItems(id));
                System.out.println("Sub Total: "+ cart.getCartPrice(id));//+ checkOut.calcTotal());
                System.out.println("Tax: "+cart.getSalesTax(id));//+checkOut.taxCalc());
                System.out.println("Total: "+ cart.getFinalPrice(id));
                System.out.println(checkOut.orderConfirmation(user,id));
                System.out.println(checkOut);
                exit = "Y";
            }
            else{
                System.out.println("Your address, email address or the payment didn't validate");
                System.out.println("Terminating checkout process");
                exit = "Y";
            }

        }
    }
}
