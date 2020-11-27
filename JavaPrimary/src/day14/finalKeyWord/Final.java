package day14.finalKeyWord;

/*
    final : 最终的
    1、final可以修饰的结构 ： 类、方法、变量
    2、final修饰类
        2.1 此类不能被继承，如String类、System类、StringBuffer类
    3、final修饰方法表明方法不能重写，如Object类中的getClass方法就是final的
    4、final修饰变量：final一修饰变量变为了常量
        4.1 final修饰属性：可以考虑赋值的位置：显示初始化、代码块中初始化、构造器中初始化
        4.2 final修饰形参表示形参是一个常量，调用方法时给形参赋值，但是不能对形参进行更改

    5、static final 修饰属性：全局常量
    6、static final 修饰方法：不能重写
 */
public class Final {

    final int WIDTH = 10;
    final int LEFT;
    final int RIGHT;
//    final int DOWN;

    {
        LEFT = 20;
    }

    public Final() {
        this.RIGHT = 2;
    }

    public Final(int RIGHT) {
        this.RIGHT = 2;
    }
/*
    方法中不能给final属性赋值
    因为构造器是对象生成的最后一步
    对象生成时，方法未必执行
    public void setDOWN(int down) {
        this.DOWN = down;
    }
*/
}

//final类不能被继承，String类
final class FinalA {

}


