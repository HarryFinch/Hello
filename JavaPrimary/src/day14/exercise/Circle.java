package day14.exercise;

public class Circle {
    private double radius;
    private int id;
    private double area;

    private static int total = 0; //记录创建对象的个数
    private static int init = 1001;//static 所有对象共享

    public Circle(double radius) {
        this.radius = radius;
        id = init++;
        total++;
    }

    public int getId() {
        return id;
    }

    public double findArea() {
        return radius * radius * Math.PI;
    }
}
