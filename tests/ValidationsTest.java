import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Pragyee Nepal
 */
public class ValidationsTest {
    Validations valid;

    @BeforeEach
    void setUp() {
        valid = new Validations();
    }

    @Test
    void isvalid_streetAddress_AllValidOnes() {
        assertTrue(valid.isvalid_streetAddress("54 Pilgrim rd"));
        assertTrue(valid.isvalid_streetAddress("300 The Fenway"));
        assertTrue(valid.isvalid_streetAddress("1000 Pennsylvania Ave"));
        assertTrue(valid.isvalid_streetAddress("1 High Street"));
        assertTrue(valid.isvalid_streetAddress("100 Federal Avenue"));

    }

    @Test
    void isvalid_streetAddress_AllInvalidOnes() {
        assertFalse(valid.isvalid_streetAddress("Pilgrim rd"));
        assertFalse(valid.isvalid_streetAddress("The Fenway"));
        assertFalse(valid.isvalid_streetAddress("Pennsylvania"));
        assertFalse(valid.isvalid_streetAddress("High Street"));
        assertFalse(valid.isvalid_streetAddress("Federal Broadway"));
    }

    @Test
    void isvalid_city_AllValidOnes() {
        assertTrue(valid.isvalid_city("Boston"));
        assertTrue(valid.isvalid_city("Santa Fe"));
        assertTrue(valid.isvalid_city("Milton-Freewater"));
        assertTrue(valid.isvalid_city("Dover-Foxcroft"));
        assertTrue(valid.isvalid_city("City of Dovewater"));
    }

    @Test
    void isvalid_city_AllInvalidOnes() {
        assertFalse(valid.isvalid_city("125 High Street"));
        assertFalse(valid.isvalid_city("300 The Fenway"));
        assertFalse(valid.isvalid_city("-Boston"));
        assertFalse(valid.isvalid_city("Chicago."));
    }

    @Test
    void isvalid_state_AllValidOnes() {
        assertTrue(valid.isvalid_state("MA"));
        assertTrue(valid.isvalid_state("Alabama"));
        assertTrue(valid.isvalid_state("PA"));
        assertTrue(valid.isvalid_state("Pennsylvania"));
    }

    @Test
    void isvalid_state_AllInvalidOnes() {
        assertFalse(valid.isvalid_state("Denver"));
        assertFalse(valid.isvalid_state("Boston"));
        assertFalse(valid.isvalid_state("Mass"));
        assertFalse(valid.isvalid_state("Pensylvania"));
    }

    @Test
    void isvalid_zipcode() {
        //Valid ones
        assertTrue(valid.isvalid_zipcode("02215"));
        assertTrue(valid.isvalid_zipcode("11111"));
        //Invalid ones
        assertFalse(valid.isvalid_zipcode("977"));
        assertFalse(valid.isvalid_zipcode("-2345"));
    }

    @Test
    void isvalid_email_AllValidOnes() {
        assertTrue(valid.isvalid_email("nepal@simmons.edu"));
        assertTrue(valid.isvalid_email("firstname.lastname@live.com"));
        assertTrue(valid.isvalid_email("name_name2@simmons.net"));
        assertTrue(valid.isvalid_email("abcdf1234@hotmail.com"));
        assertTrue(valid.isvalid_email("simmonsfinancialaid@simmons.edu"));
    }
    @Test
    void isvalid_email_AllInvalidOnes() {
        assertFalse(valid.isvalid_email("nepal@simmons"));
        assertFalse(valid.isvalid_email("nepal@simmons.c"));
        assertFalse(valid.isvalid_email("abcdef1234.com"));
        assertFalse(valid.isvalid_email("firstname.lastname@live.hey"));
    }

    @Test
    void isvalid_payment_AllValidOnes() {
        assertTrue(valid.isvalid_payment("440098483928376"));
        assertTrue(valid.isvalid_payment("579282916463729"));
        assertTrue(valid.isvalid_payment("379328101832747"));
        assertTrue(valid.isvalid_payment("6823876538292776"));
        assertTrue(valid.isvalid_payment("6238765382927"));
    }

    @Test
    void isvalid_payment_AllInvalidOnes() {
        assertFalse(valid.isvalid_payment("36947309498237")); //doesn't start with 37
        assertFalse(valid.isvalid_payment("440087652845")); //length<13
        assertFalse(valid.isvalid_payment("2345678321345")); //invalid first number
        assertFalse(valid.isvalid_payment("5678927461527436789")); //length>16
    }

}
