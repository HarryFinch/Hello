package day08;

/*
    1、类中方法的声明和使用
       1.1、方法：描述用该具有的功能
                比如：Math类
    2、方法的声明
        2.1权限修饰符 返回值类型 方法名（形参列表）｛
                    方法体
           ｝
           注意：static、final、abstract来修饰的方法
    3、说明
        3.1 关于权限修饰符：
            Java规定的四种权限修饰符：private、public（出现频率高）、protected、缺省（出现频率低）
        3.2返回值类型：
            3.2.1 有返回值：声明方法时必须指定返回值的类型；方法之须有关键字return
            3.2.2 无返回值：一般使用void声明方法，使用无需使用return；如果使用的话，return没有表达式仅写一个return即可
            3.2.3 返回值根据具体需求决定
        3.3方法名：
            属于标识符，遵循标识符的命名规范
        3.4 方法体：
            方法功能的体现，方法的灵魂
    4、return关键字的使用：
        4.1 使用范围：使用再方法体中
        4.2 作用：
            ①结束方法
            ②针对有返回值类型的方法，使用“return 数据”返回所需要的数据
        4.3 注意： return关键字后面不可以声明执行语句
    5.方法的使用：
        5.1、通过类对象调用方法
        5.2 可以调用当前类的属性或方法，递归慎用
        5.3
 */
public class Customer {
    //属性
    String name;
    int age;
    boolean isMale;

    //method
    public void eat() {
        System.out.println("eat");
    }

    public void sleep(int hour) {
        System.out.println("sleep" + hour);
    }

    public String getName() {
        return name;
    }

    public String getNation(String nation) {
        String info = "My country is " + nation;
        return info;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {

        }
        long t2 = System.currentTimeMillis();
        System.out.println("time :" + (t2 - t1));
    }

}
