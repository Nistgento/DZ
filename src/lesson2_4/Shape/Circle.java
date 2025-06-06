package lesson2_4.Shape;

class Circle implements GeometricShape {
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