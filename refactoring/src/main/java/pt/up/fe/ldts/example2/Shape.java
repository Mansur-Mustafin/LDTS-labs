package pt.up.fe.ldts.example2;

public abstract class Shape {

    private double x;
    private double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Shape(double x, double y, double radius) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void draw(GraphicFramework graphics);

}
