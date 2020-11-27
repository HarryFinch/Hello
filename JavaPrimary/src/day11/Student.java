package day11;

public class Student extends Person {
    String name ;
    int age ;
    String major ;

    public Student () {

    }

    public Student(String name , int age , String major) {
        this.name = name ;
        this.age  = age  ;
        this.major = major ;
    }

    public void eat() {
        System.out.println("eating");
    }

    public void sleep(){
        System.out.println("sleeping");
    }

    public void study() {
        System.out.println("studying");
    }
}



