package lesson2_4.Shape;

import lesson2_4.Circle;
import lesson2_4.Rectangle;
import lesson2_4.Triangle;

public interface GeometricShape{
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