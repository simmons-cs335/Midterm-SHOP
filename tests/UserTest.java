import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Clara Carleton
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {

    private int user_id = 2;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User(user_id);
    }

    @Test
    void testGetName(){
        assertEquals("Clara", user.getName());
    }

    @Test
    void testGetEmail(){ assertEquals("clara@gmail.com", user.getEmail());}

    @Test
    void testGetAddress(){ assertNotNull(user.getAddress());}

    @Test
    void testGetCredit() {assertEquals("5417608342653934", user.getCredit());}

    @Test
    void testGetCart(){assertNotNull(user.getCart());}

}