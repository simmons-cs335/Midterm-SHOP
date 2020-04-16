/**
 * @author Amran Hassan & Lila Crum
 */
public class Inventory {

    private InventoryDao productData = new InventoryDao("carletoc", "1683864");
    private String productName;
    private String productDepartment;
    private double productPrice;
    private int initialQuantity;
    private int soldUnits;
    private int stockQuantity;
    private int numberOfProducts;
    private int productID;


    Inventory(int prodId){
        productName = productData.productName(prodId);
        productDepartment = productData.productDepartment(prodId);
        productPrice = productData.productPrice(prodId);
        initialQuantity = productData.checkInitialQuantity(prodId);
        soldUnits = productData.checkSoldAmount(prodId);
        stockQuantity = productData.checkStockLeft(prodId);
        numberOfProducts = productData.numberOfProducts(prodId);
        productID = prodId;
    }

    /**
     * @author Clara Carleton
     */
    Inventory(int pi, String pn, String pd, double pp, int iq, int su, int sq, int np){
        productID = pi;
        productName = pn;
        productDepartment = pd;
        productPrice = pp;
        initialQuantity = iq;
        soldUnits = su;
        stockQuantity = sq;
        numberOfProducts = np;
    }

    /**
     * @author Lila Crum
     */

    Inventory(int prodId, String name, String dept, double price){
        productID = prodId;
        productName = name;
        productDepartment = dept;
        productPrice = price;
        initialQuantity = 10;
        soldUnits = 0;
        stockQuantity = 10;
        numberOfProducts = 10;
    }

    /**
     * @author Lila Crum
     */
    public void increaseStockQuantity(int additionalProduct) {
        this.stockQuantity += additionalProduct;
    }

    /**
     * @author Amran Hassan
     */
    public void addStock(int prodId){ productData.addStock(prodId); }

    /**
     * @author Amran Hassan
     */
    public String getProductName(){ return productName; }

    public int getProductID() { return productID; }

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
