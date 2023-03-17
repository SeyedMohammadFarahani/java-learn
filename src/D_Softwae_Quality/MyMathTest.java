package D_Softwae_Quality;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {

    @Test
    public void division() {
        MyMath math = MyMath.getInstance();
        assertNotNull(math);
        assertEquals(math.division(4, 2), 2);
        assertEquals(math.division(5, 3), 1);
        try {
            math.division(5, 0);

            //The test should never reach this line:
            fail();
        } catch (Exception e) {
            // The Exception is OK
            assertTrue(e instanceof ArithmeticException);
        }

    }
}