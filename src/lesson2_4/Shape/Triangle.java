package lesson2_4.Shape;

class Triangle implements GeometricShape {
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