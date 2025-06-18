package lesson2_7.operations;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {
    @Test
    public void testCompare() {
        assertEquals(NumberComparator.compare(5, 3), "5 more 3");
        assertEquals(NumberComparator.compare(7, 7), "equally");
    }
}