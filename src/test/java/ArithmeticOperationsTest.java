import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {
    @Test
    void testAdd() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(-1, ArithmeticOperations.subtract(2, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(0.666, ArithmeticOperations.divide(2, 3), 0.001);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(2, 0);
        });
    }
}