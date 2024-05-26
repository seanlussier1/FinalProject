import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    public void testIsPostalCodeValid1() {
        String postalCode = "A1A1A1";
        Assertions.assertTrue(Address.isPostalCodeValid(postalCode));
    }

    @Test
    public void testIsPostalCodeValid2() {
        String postalCode = "A1A 1A1";
        Assertions.assertTrue(Address.isPostalCodeValid(postalCode));
    }

    @Test
    public void testIsPostalCodeValid3() {
        String postalCode = "A1A151";
        Assertions.assertFalse(Address.isPostalCodeValid(postalCode));
    }

    @Test
    public void testIsPostalCodeValid4() {
        String postalCode = "A1A  1A1";
        Assertions.assertFalse(Address.isPostalCodeValid(postalCode));
    }

    @Test
    public void testIsPostalCodeValid5() {
        String postalCode = "";
        Assertions.assertFalse(Address.isPostalCodeValid(postalCode));
    }

    @Test
    public void testIsPostalCodeValid6() {
        String postalCode = null;
        Assertions.assertFalse(Address.isPostalCodeValid(postalCode));
    }
}
