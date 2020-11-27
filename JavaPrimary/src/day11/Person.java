package day11;

public class Person extends Creature {

    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name ;
        this.age  = age  ;
    }

    public void eat() {
        System.out.println("eating");
    }

    public void sleep() {
        System.out.println("sleeping");
    }




}
