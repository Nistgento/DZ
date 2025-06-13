package tetsng.operations;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import main.java.operations.ArithmeticOperations;

public class ArithmeticOperationsTestNG {
    @Test
    public void testAdd() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test
    public void testDivide() {
        assertEquals(ArithmeticOperations.divide(2, 3), 0.666, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(2, 0);
    }
}