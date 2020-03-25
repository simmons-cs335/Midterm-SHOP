import java.util.Calendar;
/**
 * @ author Amran Hassan
 */
public class OrderConfirmation {

    private OrderConfirmationDAO OrderConfirmationData = new OrderConfirmationDAO("carletoc", "1683864");

    /**
     * @ author Amran Hassan
     */
    OrderConfirmation(int user_id){
    }
    
    /**
     * @ author Amran Hassan
     */
    public void save(int user_id, double final_price){
        OrderConfirmationData.save(user_id, final_price);
    }

    /**
     * @ author Amran Hassan
     */
    public static java.sql.Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
        return date;
    }
    
    /**
     * @ author Amran Hassan
     */
    public void list() {
        OrderConfirmationData.list();
    }

}
