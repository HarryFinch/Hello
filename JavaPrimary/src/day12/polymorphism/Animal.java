package day12.polymorphism;

import java.sql.Connection;

//多态性的使用举例1
public class Animal {

    public static void main(String[] args) {
        Animal ani = new Animal();
        ani.func(new Dog());
    }

    public void func(Animals animal) {
        animal.eat();
        animal.shout();
    }
}

class Animals {
    public void eat() {
        System.out.println("eating");
    }

    public void shout() {
        System.out.println("shouting");
    }
}

class Dog extends Animals {
    public void eat() {
        System.out.println("eating dog food");
    }

    public void shout() {
        System.out.println("shouting wang");
    }
}

class Cat extends Animals {
    public void eat() {
        System.out.println("eating cat food");
    }

    public void shout() {
        System.out.println("shouting miao");
    }
}

//举例2 ，Object对象全Java通用了
class Order {
    public void method(Object object) {

    }
}

//举例3
class Driver {

    public void doDate(Connection connection) {
        //new  = MySQLConnection() 规范的步骤去操作数据
//        connection.method1();

    }
}





