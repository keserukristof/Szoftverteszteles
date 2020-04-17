package pti.gyak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComplexTest {

    @Test
    public void testBalAg() {
        Complex complex = new Complex();
        assertEquals(354, complex.func(354, 400, 300));
    }

    @Test
    public void testCase698() {
        Complex complex = new Complex();
        assertEquals(-698, complex.func(698, 400, 300));
    }

    @Test
    public void testBMoreC() {
        Complex complex = new Complex();
        assertEquals(300, complex.func(654, 400, 300));
    }

    @Test
    public void testBNotMoreC() {
        Complex complex = new Complex();
        assertEquals(300, complex.func(654, 300, 400));
    }
}