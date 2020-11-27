package day13.exercise1;

public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius , String color , double weight) {
        super(color , weight);
        this.radius = radius;
    }

    public double findArea() {
        return radius * radius * Math.PI;
    }
}
