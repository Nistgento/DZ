package lesson2_7.operations;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) {
            return a + " more " + b;
        } else if (a < b) {
            return a + " less " + b;
        } else {
            return "equally";
        }
    }
}