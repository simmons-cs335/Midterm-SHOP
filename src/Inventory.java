/**
 * @author Amran Hassan
 */
public class Inventory {

    private InventoryDao productData = new InventoryDao("carletoc", "1683864");
    private String productName;
    private String productDepartment;
    // private void addStock;
    private double productPrice;
    private int initialQuantity;
    private int soldUnits;
    private int stockQuantity;
    private int numberOfProducts;


    Inventory(int prodId){
        productName = productData.productName(prodId);
        productDepartment = productData.productDepartment(prodId);
        productPrice = productData.productPrice(prodId);
        initialQuantity = productData.checkInitialQuantity(prodId);
        soldUnits = productData.checkSoldAmount(prodId);
        stockQuantity = productData.checkStockLeft(prodId);
        numberOfProducts = productData.numberOfProducts(prodId);

    }

    /**
     * @author Amran Hassan
     */
    public void addStock(int prodId){ productData.addStock(prodId); }

    /**
     * @author Amran Hassan
     */
    public String getProductName(){ return productName; }

    /**
     * @author Amran Hassan
     */
    public Integer getNumberOfProducts(){ return numberOfProducts; }

    /**
     * @author Amran Hassan
     */
    public String getProductDepartment(){ return productDepartment; }

    /**
     * @author Amran Hassan
     */
    public Double getProductPrice(){ return productPrice; }

    /**
     * @author Amran Hassan
     */
    public Integer getInitialQuantity(){ return initialQuantity;}

    /**
     * @author Amran Hassan
     */
    public Integer getSoldUnits() { return soldUnits;}

    /**
     * @author Amran Hassan
     */
    public Integer getStockQuantity(){ return stockQuantity; }

}
