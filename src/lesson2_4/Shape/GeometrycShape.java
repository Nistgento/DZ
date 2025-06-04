package lesson2_4.Shape;

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