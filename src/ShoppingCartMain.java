public class ShoppingCartMain {
    public static void main(String[] args) {

        UserDao userdao = new UserDao("carletoc", "1683864");
        userdao.list(); //Print out users
        userdao.delete(2); //Delete a user
        userdao.list(); //Print out users
        String[] columns =
                {"2","Clara","300 The Fenway","Boston", "MA", "02115", "clara@gmail.com"};
        userdao.save(columns); //Delete a user
        userdao.list(); //Print out users

        //Print out inventory
        /*
        InventoryDao inventorydao = new InventoryDao("carletoc", "1683864");
        inventorydao.list();
         */
    }
}
