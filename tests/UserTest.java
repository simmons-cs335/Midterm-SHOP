import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User(1);
    }

    @Test
    void isvalid_streetAddress_AllValidOnes() {
        assertTrue(user.isvalid_streetAddress("54 Pilgrim rd"));
        assertTrue(user.isvalid_streetAddress("300 The Fenway"));
        assertTrue(user.isvalid_streetAddress("1000 Pennsylvania Ave"));
        assertTrue(user.isvalid_streetAddress("1 High Street"));
        assertTrue(user.isvalid_streetAddress("100 Federal Avenue"));

    }

    @Test
    void isvalid_streetAddress_AllInvalidOnes() {
        assertFalse(user.isvalid_streetAddress("Pilgrim rd"));
        assertFalse(user.isvalid_streetAddress("The Fenway"));
        assertFalse(user.isvalid_streetAddress("Pennsylvania"));
        assertFalse(user.isvalid_streetAddress("High Street"));
        assertFalse(user.isvalid_streetAddress("Federal Broadway"));
    }

    @Test
    void isvalid_city_AllValidOnes() {
        assertTrue(user.isvalid_city("Boston"));
        assertTrue(user.isvalid_city("Santa Fe"));
        assertTrue(user.isvalid_city("Milton-Freewater"));
        assertTrue(user.isvalid_city("Dover-Foxcroft"));
        assertTrue(user.isvalid_city("City of Dovewater"));
    }

    @Test
    void isvalid_city_AllInvalidOnes() {
        assertFalse(user.isvalid_city("125 High Street"));
        assertFalse(user.isvalid_city("300 The Fenway"));
        assertFalse(user.isvalid_city("-Boston"));
        assertFalse(user.isvalid_city("Chicago."));
    }

    @Test
    void isvalid_state_AllValidOnes() {
        assertTrue(user.isvalid_state("MA"));
        assertTrue(user.isvalid_state("Alabama"));
        assertTrue(user.isvalid_state("PA"));
        assertTrue(user.isvalid_state("Pennsylvania"));
    }

    @Test
    void isvalid_state_AllInvalidOnes() {
        assertFalse(user.isvalid_state("Denver"));
        assertFalse(user.isvalid_state("Boston"));
        assertFalse(user.isvalid_state("Mass"));
        assertFalse(user.isvalid_state("Pensylvania"));
    }

    @Test
    void isvalid_zipcode() {
        //Valid ones
        assertTrue(user.isvalid_zipcode("02215"));
        assertTrue(user.isvalid_zipcode("11111"));
        //Invalid ones
        assertFalse(user.isvalid_zipcode("977"));
        assertFalse(user.isvalid_zipcode("-2345"));
    }

    @Test
    void isvalid_email_AllValidOnes() {
        assertTrue(user.isvalid_email("nepal@simmons.edu"));
        assertTrue(user.isvalid_email("firstname.lastname@live.com"));
        assertTrue(user.isvalid_email("name_name2@simmons.net"));
        assertTrue(user.isvalid_email("abcdf1234@hotmail.com"));
        assertTrue(user.isvalid_email("simmonsfinancialaid@simmons.edu"));
    }
    @Test
    void isvalid_email_AllInvalidOnes() {
        assertFalse(user.isvalid_email("nepal@simmons"));
        assertFalse(user.isvalid_email("nepal@simmons.c"));
        assertFalse(user.isvalid_email("abcdef1234.com"));
        assertFalse(user.isvalid_email("firstname.lastname@live.hey"));
    }

    @Test
    void isvalid_payment_AllValidOnes() {
        assertTrue(user.isvalid_payment("440098483928376","Visa"));
        assertTrue(user.isvalid_payment("579282916463729","Mastercard"));
        assertTrue(user.isvalid_payment("379328101832747","American Express"));
        assertTrue(user.isvalid_payment("6823876538292776","Discover"));
        assertTrue(user.isvalid_payment("6238765382927","Discover"));
    }

    @Test
    void isvalid_payment_AllInvalidOnes() {
        assertFalse(user.isvalid_payment("36947309498237","American Express")); //doesn't start with 37
        assertFalse(user.isvalid_payment("440087652845","Visa")); //length<13
        assertFalse(user.isvalid_payment("2345678321345","Discover")); //invalid first number
        assertFalse(user.isvalid_payment("5678927461527436789", "Discover")); //length>16
    }
}