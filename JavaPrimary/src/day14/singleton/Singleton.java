package day14.singleton;

/*
     单例设计模式：一个类只能有一个对象
     实现：
        1、构造器权限为private，这样就不能通过new操作符在类的外部获得对象，可以获得类内对象
        2、调用该类的某个静态方法返回类内部创建的对象
        3、返回对象的方法得是静态的

    实现方式 1、懒汉式 2、饿汉式
    两者区别：
        懒汉式：延时创建对象，节省内存，但是线程不安全，多线程会改进
        饿汉式：对象加载时间过长，占用内存，但是线程安全
 */
public class Singleton {
}

//饿汉式
class Bank {
    //私有化构造器
    private Bank() {
    }

    //内部创建类的对象(静态)
    private static Bank instance = new Bank();

    //提供公共的方法（静态），返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}

//懒汉式
class Order {
    //私有构造器
    private Order() {
    }

    //声明对象
    private static Order instance = null;

    //提供公共的方法（静态），返回类的对象
    public static Order getInstance() {
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }

}
