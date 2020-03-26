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
        //System.out.println( "*****There are currently " + product.getNumberOfProducts() + " items listed in Inventory *****");
        try {
            System.out.println("*****PRODUCER has STARTED looking at " + product.getProductName()+" in Inventory*****");

            /*
            System.out.printf("%s belongs to the %s " + " department. \n" +
                            "\tIt's current selling price is at $%s . \n" +
                            "\tSo far, you have sold %s" + " units of this item. \n" +
                            "\tAnd there are currently %s" + " left in stock \n",
                            product.getProductName(), product.getProductDepartment(),
                            product.getProductPrice(),  product.getSoldUnits(), product.getStockQuantity());
             */
            System.out.printf("\tItem: %s," + "\tDepartment: %s," + "\tPrice: $%s," + "\tSold Units: %s," + "\tStock Qty: %s\n",
                    product.getProductName(), product.getProductDepartment(),
                    product.getProductPrice(),  product.getSoldUnits(), product.getStockQuantity());

            //addStock if there isn't enough stock
            int currentStockQuantity = product.getStockQuantity();
            Random rand = new Random();
            int idealStockQuantity = rand.nextInt(100); //Random Number to determine the producer's idealStockQuant
            System.out.println("The Producer wants to have a current of amount of "+ idealStockQuantity +" "+ product.getProductName());
            if( currentStockQuantity <= idealStockQuantity){
                product.addStock(prod_id);
                System.out.printf("+++!!!STOCKED ADDED producer wants to have a current of amount of %s %s 's\n" +
                                "\tThere is less than desired in stock, PRODUCER has added more in stock\n ",
                                idealStockQuantity,product.getProductName());
            }
            else{
                System.out.println("----!!!STOCK LEFT ALONE, Producer believes there are enough products of this item in inventory right now!!!----") ;
            }
        } catch (Exception e){
            System.out.println("***** PRODUCER has been interrupted while looking at Inventory*****");
        }
        System.out.println("***** PRODUCER has STOPPED looking at " + product.getProductName()+" in Inventory*****");

    }
}