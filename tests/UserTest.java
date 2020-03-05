import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testGetAddress() {
        assertEquals("300 The Fenway", user.getAddress());
    }

    /*
    @Test
    void testCorrectCity(){
        assertEquals("Boston", user.getCity());
    }

    @Test
    void testCorrectState(){
        assertEquals("MA", user.getState());
    }

    @Test
    void testCorrectZipCode(){
        assertEquals("02115", user.getState());
    }
     */

}