package day13.exercise1;

public class GeometricTest {
    public static void main(String[] args) {

        GeometricTest geometricTest = new GeometricTest() ;

        GeometricObject geo1 = new GeometricObject("NULL", 0.0);

        GeometricObject geo2 = new Circle(10.0, "Red", 10.0);

        GeometricObject geo3 = new MyRectangle("Blue", 20.0, 5, 5);

        System.out.println(geometricTest.equalsArea(geo2, geo3));
        geometricTest.displayGeometricObject(geo1);
        geometricTest.displayGeometricObject(geo2);
        geometricTest.displayGeometricObject(geo3);

    }

    public boolean equalsArea(GeometricObject g1, GeometricObject g2) {
        return g1.findArea() == g2.findArea() ;
    }

    public void displayGeometricObject(GeometricObject object) {

        if (object instanceof Circle) {
            System.out.println("Circle Area = " + object.findArea());
            System.out.println("Circle color = " + object.color);
        } else {
            System.out.println("Retangle Area = " + object.findArea());
            System.out.println("Retangle color = " + object.color);
        }

    }
}
