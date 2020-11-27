package day09.exercise;

public class PassObject {

    public void printArea(Circle c, int time) {
        System.out.println("Raduis\tArea");
        for (int i = 1; i <= time; i++) {
            c.radius = i ;
            System.out.println("radius = " + c.radius + "\t" + c.findaArea());
        }
    }
}
