package day09Reflection.java1;

import java.util.Comparator;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description :
 */

@MyAnnotation("Hello-World")
public class Person extends Creature<String> implements Comparator<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "asdf")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是 : " + nation);
        return nation;
    }

    public String display(String interets, int age) throws NullPointerException,ClassCastException {
        return interets + age;
    }

    private static void showDesc() {
        System.out.println("showDesc");
    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
