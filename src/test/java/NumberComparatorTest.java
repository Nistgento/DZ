import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    @Test
    void testCompare() {
        assertEquals("5 more 3", NumberComparator.compare(5, 3));
        assertEquals("2 less 4", NumberComparator.compare(2, 4));
        assertEquals("equally", NumberComparator.compare(7, 7));
    }
}