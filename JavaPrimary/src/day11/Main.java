package day11;

/*
    面向对象的特征之二：继承性
    一、继承性的好处
        1、减少了代码的冗余，提高了代码的复用性
        2、便于功能的扩展
        3、为之后多态性的使用提供了前提
        4、子类继承父类后，就会获得父类的属性和方法（全部都继承，但是由于权限的影响，子类不能直接调用父类的私有结构)
        5、子类继承父类后，可以声明自己特有的属性和方法，实现功能的扩展
    二、Java中关于继承性的规定
        1、一个父类可以有多个子类
        2、一个类只能有一个父类
        3、子类、父类的概念是相对的，直接继承的称为直接父类，间接继承的称为间接父类
        4、Java语言不支持多继承，只支持单继承和多重继承
        5、如果没有显示声明一个类的父类，则此类继承于java.lang.Object
        6、Java中除Object类外，其他类都直接或间接继承于Object类
 */
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.age = 20;
        person1.sleep();

        Student student = new Student();
        student.major = "computer";

    }
}
