package pti.gyak;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testResult() {
        assertEquals(6.0, (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getResult());
    }

    @Test
    public void testHistory() {
        assertEquals("5 + 1 = 6", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getHistory());
    }

    @Test
    public void testSubstract() {
        assertEquals(2.0, (new Calculator()).enter(4).enter(Operation.SUBSTRACT).enter(2).getResult());
    }

    @Test
    public void testMultiply() {
        assertEquals(4.0, (new Calculator()).enter(2).enter(Operation.MULTIPLY).enter(2).getResult());
    }

    @Test
    public void testRemainder() {
        assertEquals(1.0, (new Calculator()).enter(5).enter(Operation.REMAINDER).enter(2).getResult());
    }

    @Test
    public void testPower() {
        assertEquals(9.0, (new Calculator()).enter(3).enter(Operation.POWER).enter(2).getResult());
    }

    @Test
    public void testDiviveZero() {
        assertEquals(Infinity, (new Calculator()).enter(6).enter(Operation.DIVIDE).enter(0).getResult());
    }

    @Test
    public void testZeroDivide() {
        assertEquals(0.0, (new Calculator()).enter(0).enter(Operation.DIVIDE).enter(5).getResult());
    }

    @Test
    public void testClear() {
        assertEquals(0, (new Calculator()).enter(2).enter(Operation.CLEAR).enter(5).enter(Operation.CLEAR).getResult());
    }
}