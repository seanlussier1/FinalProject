import Util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUtil {

    @Test
    public void testToTitleString1() {
        String strIn = "hello world";
        String expected = "Hello World";
        String actual = Util.toTitleCase(strIn);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToTitleString2() {
        String strIn = "heLlo";
        String expected = "Hello";
        String actual = Util.toTitleCase(strIn);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToTitleString3() {
        String strIn = "heLlo woRld";
        String expected = "Hello World";
        String actual = Util.toTitleCase(strIn);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToTitleString4() {
        String strIn = "";
        String expected = "";
        String actual = Util.toTitleCase(strIn);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToTitleString5() {
        String strIn = null;
        String expected = null;
        String actual = Util.toTitleCase(strIn);
        Assertions.assertEquals(expected, actual);
    }
}
