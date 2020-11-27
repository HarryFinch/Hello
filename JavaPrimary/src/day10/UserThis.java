package day10;

/*
    this关键字的使用：
    1、this可以用来修饰属性、方法、构造器
    2、this可以修饰属性，this可以理解为当前对象

    3、在类的方法中，我们可以使用"this.属性" 或 "this.方法"的方法，调用当前对象属性或者方法，但是通常情况下都选择省略this关键字，
       如果形参和属性重名时，必须显示使用this关键词以表名此变量是属性，而非形参
    4、在类的构造器中，可以使用"this.属性" 或 "this.方法"的方法，调用当前对象属性或者方法，但是通常情况下都选择省略this关键字，
       如果构造器的形参和属性重名时，必须显示使用this关键词以表名此变量是属性，而非形参
    5、this用来修饰或者调用构造器
        5.1 在类的构造器中，可以显示使用"this(para)"方式，调用本类中制定的其他构造器
        5.2 构造器中不能通过this关键字调用自己
        5.3 类中有n个构造器，最多有n-1个构造器中使用了this关键字调用了其他构造器‘
        5.4 this调用构造器必须放在当前构造器的首行
        5.5 一个构造器内部通过this关键字调用一个本类中其他构造器
 */
public class UserThis {
    private int age;
    private String name;
    private String blog;

    public UserThis() {
        this.blog = "1111";
    }

    public UserThis(String name) {
        this.name = name;
    }

    public UserThis(String name, int age) {
        //this关键字调用构造器
        this(name);
//        this() ;

        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
