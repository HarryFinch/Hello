package day15.interfaceDemo;

/*
    接口的使用
    1、interface定义接口
    2、Java语言中接口和类是并列的结构
    3、定义接口就是定义接口中的成员
        3.1 JDK7及以前 ：接口中只能定义常量和抽象方法
            public static final 编码时可以不写
            public abstract
        3.2 JDK8 除了常量和抽象方法，还可以定义静态方法、默认方法（略）
    4、接口中不能定义构造器，因此接口不能实例化

    5、Java开发中通过类实现接口来使用接口，如果实现类实现了类中的所有抽象方法就可以实例化对象
        如果没有实现所有的抽象方法，那么该实例类仍旧是一个抽象类
        (实现接口的类必须重写所有的抽象方法，否则不能构造对象)

    6、Java类可以实现多个接口，实现多个接口弥补了单继承的缺陷

    7、接口与接口之间可以继承，而且可以多继承
        interface extends AA,BB
-----------------------------------------------------------------------------
    8、接口的具体使用体现在多态性
    9、接口实际上可以看作一种规范
    10、开发中慢慢体会面向接口编程

 */
public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIX_SPEED);

        Plane plane = new Plane();
        plane.fly();
        plane.stop();

        Bullet bullet = new Bullet();
        bullet.fly();
        bullet.attack();
        bullet.stop();

    }
}

class ExtendsDemo implements CC {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }
}

interface AA {
    void method1();
}

interface BB {
    void method2();
}

interface CC extends AA, BB {
    void method3();
}

class Bullet implements Attack, Flyable {

    @Override
    public void attack() {
        System.out.println("子弹杀人了~！");
    }

    @Override
    public void fly() {
        System.out.println("让子弹飞吧");
    }

    @Override
    public void stop() {
        System.out.println("飞太久了，别累着");
    }
}


interface Attack {
    void attack();
}


class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("飞机起飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机着陆");
    }
}


interface Flyable {
    //全局常量
    int MAX_SPEED = 7900;
    int MIX_SPEED = 1;

    //抽象方法
    void fly();

    void stop();
}
