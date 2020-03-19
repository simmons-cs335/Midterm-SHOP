import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @ author Clara Carleton
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private int id = 2;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User(id);
    }

    @Test
    void testCorrectName(){
        assertEquals("Clara", user.getName());
    }

    @Test
    void testCorrectEmail(){
        assertEquals("clara@gmail.com", user.getEmail());
    }


}