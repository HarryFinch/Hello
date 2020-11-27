package day14.block;

/*
    类的成员之四：代码块（初始化块）
    1、代码块的作用：用来初始化类或者对象
    2、代码块只能使用static修饰
    3、分类：
        3.1 静态代码块：
            -- 随着类的加载而执行，只执行一次
            -- 可以初始化类的静态属性进行赋值
            -- 多个静态代码块，按照声明先后顺序执行
            -- 静态代码块的执行优先于非静态代码块（因为静态随着类走，跟对老大很重要）
            -- 内部只能调用静态的属性和方法（非静态还未加载）
        3.2 非静态代码块：
            -- 随着对象的创建而执行，，每创建一个对象就执行一次
            -- 可以在创建对象时，可以对对象的属性进行初始化
            -- 多个非静态代码块，也是按照声明的先后顺序执行
            -- 内部可以调用静态和非静态的属性和方法（后加载的都可以调用）
    4、属性赋值顺序问题：
        -- 默认初始化
        -- 显示初始化  / 代码块
        -- 构造器初始化
        -- 通过"对象.属性"赋值
 */
public class Block {
    public static void main(String[] args) {
        //证明静态代码块随着类的加载而执行
        String desc = Person.desc;
        //证明非静态代码块随着对象的创建而执行
        new Person();
    }
}


class Person {
    String name;
    int age;
    static String desc = "A person";

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void info(){
        System.out.println("I am a happy person");
    }

    //代码块
    {
        System.out.println("Hello Block");
    }

    //静态代码块
    static {
        System.out.println("Hello static Block");
    }


    public void eat() {
        System.out.println("eating");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}