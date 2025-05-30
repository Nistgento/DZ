package lesson2_4;

interface GeometricShape{
    double calculateArea();
    String getFillColor();
    String getBorberColor();

    default double calculatePerimeter(){
        System.out.println("Perimeter:");
                return 0;
    }
    default void printInfo(){
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Fill color: " + getFillColor());
        System.out.println("Borber color: " + getBorberColor());
        System.out.println("                                 ");
    }
}
class Circle implements GeometricShape{
    private final double radius;
    private final String fillColor;
    private final String borberColor;

    public Circle(double radius, String fillColor, String borberColor){
        this.radius = radius;
        this.fillColor = fillColor;
        this.borberColor = borberColor;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorberColor() {
        return borberColor;
    }
}
class Rectangle implements GeometricShape{
    private final double width;
    private final double height;
    private final String fillColor;
    private final String borberColor;

    public Rectangle(double width, double height, String fillColor, String borberColor){
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borberColor = borberColor;
    }
    @Override
    public double calculateArea() {
        return width * height;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * width * height;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorberColor() {
        return borberColor;
    }
}
class Triangle implements GeometricShape{
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final String fillColor;
    private final String borberColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borberColor){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borberColor = borberColor;
    }
    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorberColor() {
        return borberColor;
    }
}
public class Geometry {
    public static void main(String[] args) {
        GeometricShape circle = new Circle(5.0, "Green", "Black");
        GeometricShape rectangle = new Rectangle(4.0, 6.0, "White", "Yellow");
        GeometricShape triangle = new Triangle(3.0, 4.0, 5.0, "Red", "Blue");


        System.out.println("Circle:");
        circle.printInfo();
        System.out.println("Rectangle:");
        rectangle.printInfo();
        System.out.println("Triangle:");
        triangle.printInfo();
    }
}