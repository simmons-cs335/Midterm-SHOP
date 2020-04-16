import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lila Crum
 */

public class TestInventoryDao extends InventoryDao {

    Map<Integer, Inventory> productMap = new HashMap<Integer, Inventory>();

    //constructor
    TestInventoryDao(ArrayList<Inventory> productList){
        //Loading in DB from outside
        for(Inventory inventory : productList){
            this.productMap.put(inventory.getProductID(), inventory);
        }
    }


    /**
     * @author Lila Crum
     */
    public Integer numberOfProducts(int prodId){
        return productMap.get(prodId).getNumberOfProducts();
    }

    /**
     * @author Lila Crum
     */
    public void addStock(int prodId){ productMap.get(prodId).increaseStockQuantity(3); }

    /**
     * @author Lila Crum
     */
    public String productName(int prodId){
        return productMap.get(prodId).getProductName();
    }

    /**
     * @author Lila Crum
     */
    public String productDepartment(int prodId){
        return productMap.get(prodId).getProductDepartment();
    }

    /**
     * @author Lila Crum
     */
    public Double productPrice(int prodId){
        return productMap.get(prodId).getProductPrice();
    }

    /**
     * @author Lila Crum
     */
    public Integer checkInitialQuantity(int prodId){
        return productMap.get(prodId).getInitialQuantity();
    }

    /**
     * @author Lila Crum
     */
    public Integer checkStockLeft(int prodId){
        return productMap.get(prodId).getStockQuantity();
    }

    /**
     * @author Lila Crum
     */
    public Integer checkSoldAmount(int prodId){
        return productMap.get(prodId).getSoldUnits();
    }

    /**
     * @author Lila Crum
     */
    public void list() {
        for(Map.Entry<Integer,Inventory> entry : this.productMap.entrySet()){
            System.out.println("Product Id: " + entry.getValue().getProductID());
            System.out.println("Product Name: " + entry.getValue().getProductName());
            System.out.println("Product Department: " + entry.getValue().getProductDepartment());
            System.out.println("Product Price: " + entry.getValue().getProductPrice());
            System.out.println("Initial Quantity: " + entry.getValue().getInitialQuantity());
            System.out.println("Stock Quantity: " + entry.getValue().getStockQuantity());
            System.out.println("Sold Units: " + entry.getValue().getSoldUnits());
            System.out.println("\n");
        }

    }

}
