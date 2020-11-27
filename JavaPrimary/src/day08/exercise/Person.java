package day08.exercise;

public class Person {
    String name ;
    int age ;
    int sex ;

    public void Study() {
        System.out.println("Studying");
    }

    public void showAge() {
        System.out.println("age = " + age);
        System.out.println("addAge = " + addAge(2)); ;
    }

    public int addAge(int i ) {
        age = age + i ;
        return age ;
    }
}
