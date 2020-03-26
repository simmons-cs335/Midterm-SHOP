import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/**
 * @author Pragyee Nepal
 */

class UserDaoTest {

    @Test
    void ConstructorTest() {
        //UserDao dao = new UserDao();
        UserDao dao = new UserDao("carletoc","1683864");
        assertEquals("Pragyee", dao.name(3));
        assertEquals("pragyee@live.com", dao.email(3));
    }

   /* @Test
    void save() {
        String [] newUser = {"5", "Bob", "2 Mission St", "Boston", "MA", "02120", "bob@simmons.edu"};
        //UserDao dao = new UserDao();
        UserDao dao = new UserDao("carletoc","1683864");
        dao.save(newUser);
        assertEquals("Bob", dao.name(5));
    }*/

    @Test
    void delete() {
        //UserDao dao = new UserDao();
        UserDao dao = new UserDao("carletoc","1683864");
        //assertEquals("Bob", dao.name(5));
        dao.delete(5);
        assertNotEquals("Bob", dao.name(5));
    }

    @Test
    void name() {
        //UserDao dao = new UserDao();
        UserDao dao = new UserDao("carletoc","1683864");
        assertEquals("Pragyee", dao.name(3));
    }

    @Test
    void credit_num() {
        //UserDao dao = new UserDao();
        UserDao dao = new UserDao("carletoc","1683864");
        assertEquals("6011806038402271", dao.credit_num(3));
    }

    @Test
    void email() {
        //UserDao dao = new UserDao();
        UserDao dao = new UserDao("carletoc","1683864");
        assertEquals("pragyee@live.com", dao.email(3));
    }
}