package day08;

/**
 * @Description
 * @Author Pang Wenjian
 * @Date 13:45$ 2019 / 9 / 26  $
 */
/*
    一、设计类，其实就是设计类的成员
        1、属性 = 成员变量 = field = 域、字段
        2、方法 = 成员方法 = 函数 = method 就是实现某一功能
    二、对象构造
        -> 类 对象名 = new 类（） ；
        -> 对象名.方法()
        -> 对象名.属性
    三、堆（heap）：此区域的唯一目的就是存放对象实例，所有的对象实例以及数组都要在堆上分配
        栈（stack）：只虚拟机栈，用于存储局部变量。局部变量表存放了编译期可知长度的各种基本数据类型、对象引用类型
                    它不等同于对象本身，是对象在堆内存放的首地址。方法执行完，自动释放
        方法区：用于存储已被虚拟机加载的类信息、常量、静态变量、及时编译器编译后的代码等数据
 */
public class Person {

    String name;
    int age;
    boolean isMale;

    public void eat() {
        System.out.println("Can eat " + name);
    }

    public void sleep(){
        System.out.println("sleep");
    }

    public void talk(String language){
        System.out.println("talk");
    }

    public static void main(String[] args) {
        Person person = new Person() ;
        person.name = "Tom" ;
        person.isMale = true ;

        person.eat();
        person.sleep();
        person.talk("Chinese");
    }
}
