package day13.exercise;

public class Person {
    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name : " + name + "age :" + age;
    }
}

class Student extends Person {
    protected String school = "PKU";

    public String getInfo() {
        return "Name : " + name + " age :" + age + " School : " + school;
    }
}


class Graduate extends Student {
    public String major = "IT";

    public String getInfo() {
        return "Name : " + name + " age :" + age + " School : " + school + " Major : " + major;
    }
}