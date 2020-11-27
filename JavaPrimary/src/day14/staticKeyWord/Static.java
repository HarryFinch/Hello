package day14.staticKeyWord;
/*
    static 关键字的使用
    1、static  静态的
    2、static 可以用来修饰：属性、方法、代码块、内部类

    3、使用static修饰属性：静态变量
        3.1 属性按是否使用修饰分为：静态属性和非静态属性（实例变量）
            实例变量：当创建了类的多个对象，每个对象都独立地拥有一套类中实例变量
                        修改其中一个对象的非静态属性时，不会导致其它对象中同样的属性值的修改
            静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一对象修改静态变量时，
                        会导致其他对象调用词静态变量时，是某一对象修改过的值
        3.2 static 修饰属性的其他说明：
            3.2.1 静态变量随着类的加载而加载
            3.2.2 静态变量的加载早于对象的创建
            3.2.3 通过 "类.静态属性" 的方式调用静态属性
            3.2.4 类在内存中只加载一次，则静态变量在内存中也只会加载一份
            3.2.5 静态属性调用
                    类变量  实例变量
              类      yes      no
              对象    yes      yes

        3.3 静态属性举例： ①System.out   ②Math.PI
    4、使用static修饰方法：静态方法
        4.1 随着类的加载而加载，可以通过类调用
        4.2 静态方法的调用
                    静态方法  非静态方法
              类      yes         no
              对象    yes         yes
        4.3 静态方法中只能调用静态方法或属性
            非静态方法中，既可以调用非静态的方法和属性，也可以调用静态的方法属性
    5、static注意点
        5.1 静态方法内不能使用this super关键字
        5.2 静态属性和方法的使用从生命周期的角度去理解
    6、开发中，如何确定属性或者方法是否要声明为static
        6.1 属性：可以被多个对象共享的，不会随着对象不同而不同的
        6.2 方法：
            -- 操作静态属性的方法通常设置为静态的
            -- 工具类中方法，习惯上声明为静态的
 */
public class Static {
    public static void main(String[] args) {
        Chinese chinese1 = new Chinese();
        chinese1.nation = "CHN" ;//

        Chinese chinese2 = new Chinese();
        chinese2.nation = "CHINA";
    }
}

class Chinese {
    String name ;
    int age ;
    static String nation ;
}





