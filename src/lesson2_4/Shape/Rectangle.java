package lesson2_4.Shape;

class Rectangle implements GeometricShape {
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