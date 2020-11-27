package day13.exercise1;

public class MyRectangle extends GeometricObject{
    private double width ;
    private double height ;

    public MyRectangle (String color , double weight , double width , double height ) {
        super(color , weight);
        this.width = width ;
        this.height = height ;
    }

    public double findArea() {
        return height * width ;
    }
}
