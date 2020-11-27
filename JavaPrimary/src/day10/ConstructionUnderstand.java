package day10;

/*
    类的结构之三：构造器（别名构造方法、constructor）的使用
    constructor：建设、建造。constructor：CCB  constructor：建设者

    一、构造器的作用：
        1. 创建对象
        2. 初始化对象属性
    二、说明：
        如果没有显示定义类的构造器，系统提供一个默认的构造器；如果显示地定义了构造器，系统便不在提供默认的构造器
 */
public class ConstructionUnderstand {

    String name;
    int age;

    public void eat() {
        System.out.println("eating");
    }

    public void sleep() {
        System.out.println("sleeping");
    }

    public static void main(String[] args) {
        //创建类的对象，new Constructor（）;
        ConstructionUnderstand c = new ConstructionUnderstand() ;
        c.eat();
        c.sleep();
    }
}
