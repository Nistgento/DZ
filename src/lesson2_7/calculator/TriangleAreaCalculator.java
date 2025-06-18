package lesson2_7.calculator;

public class TriangleAreaCalculator {
    public static double calculateArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("The base and height must be positive numbers.");
        }
        return (base * height) / 2;
    }
}