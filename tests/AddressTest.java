import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Clara Carleton
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private Address address;
    private int user_id = 2;

    @BeforeEach
    void setUp(){ address = new Address(user_id);}

    @Test
    void testCorrectCity(){
        assertEquals("Boston", address.getCity());
    }

    @Test
    void testCorrectState(){
        assertEquals("MA", address.getState());
    }

    @Test
    void testCorrectZipCode(){
        assertEquals("02115", address.getZipcode());
    }

    @Test
    void testGetStreet() {
        assertEquals("300 The Fenway", address.getStreet());
    }
}
