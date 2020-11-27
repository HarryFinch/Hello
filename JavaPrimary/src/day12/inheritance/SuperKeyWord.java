package day12.inheritance;

/*
    一、super关键字的使用
        1、super可以理解为  父类的
        2、super可以用来调用  属性、方法、构造器
            2.1 super.属性
                    --- 调用父类属性
            2.2 super()  -
                    -- 调用父类构造器，必须声明在子类构造器首行
                    -- 没有显示声明调用父类构造器的情况下，默认调用父类无参构造器
            2.3 super.方法名()
                    --- 调用父类方法（一般调用父类中被重写的方法）
        3、类的多个构造器中，至少有一个类使用super关键字调用了父类的构造器
 */
public class SuperKeyWord {

    String name;
    int age;
    int id;

    public SuperKeyWord() {
    }

    public SuperKeyWord(String name) {
        this.name = name;
    }

    public SuperKeyWord(String name, int age) {
        this(name);
        this.age = age;
    }

    public void eat() {
        System.out.println("eating");
    }

    public void walk() {
        System.out.println("walking");
    }
}
