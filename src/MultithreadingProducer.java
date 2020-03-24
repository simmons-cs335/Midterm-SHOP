import java.util.ArrayList;
import java.util.Random;

/**
 * @author Amran Hassan
 */

public class MultithreadingProducer extends Thread {
    private int prod_id;

    public MultithreadingProducer(int prod_id){
        this.prod_id = prod_id;
    }
    public void run() {
        Inventory product = new Inventory(prod_id);
        try {
            System.out.println("***** PRODUCER has STARTED looking at " + product.getProductName()+" in Inventory*****");

            System.out.println( "There are currently " + product.getNumberOfProducts() + " items listed in Inventory");

            System.out.println("Producer is currently looking at "+ product.getProductName() );
            System.out.println( product.getProductName()+ "  is located in the " + product.getProductDepartment() + " Department");
            System.out.println("It's current selling price is at $ " + product.getProductPrice() );
            //System.out.println("The Initial Stock was: " + product.getInitialQuantity() );
            System.out.println( "The Amount of units Sold is: " + product.getSoldUnits() );
            System.out.println( "Current Stock Left is: " + product.getStockQuantity() );

            //restocking if there
            int max = product.getNumberOfProducts();
            int min = 1;
            int random_item = (int)(Math.random()*(max-min+1)+min);
            int currentStockQuantity = product.getStockQuantity();
            Random rand = new Random();

            int idealStockQuantity = rand.nextInt(50); //Random Number to determine the producer's idealStockQuant
            System.out.println("The Producer wants to have a current of amount of "+ idealStockQuantity +" "+ product.getProductName());
            System.out.println( "Currently there are " + product.getStockQuantity() + " units left in stock");
            if( currentStockQuantity <= idealStockQuantity){
                product.addStock(prod_id);
                System.out.println("There are less " + product.getProductName()+ " than desired in stock, therefore we have added more in stock!");
                //System.out.println("Now there is " + product.getStockQuantity() + " units left in stock"); // For some reason will actually update the last number but doesn't display the new quantity...
            }
            else{
                System.out.println("There are enough products in inventory right now!") ;

            }


        } catch (Exception e){
            System.out.println("***** PRODUCER has been interrupted while looking at Inventory*****");

        }
        System.out.println("***** PRODUCER has STOPPED looking at " + product.getProductName()+" in Inventory*****");

    }
}