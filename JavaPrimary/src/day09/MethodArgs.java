package day09;

/*
 * 方法的重载（overload） loading
 * 1、定义：在同一个类中，允许存在一个以上的同名方法，只要他们的参数个数或者参数类型不同即可
              签名不同而已
 * 2、举例：
 * Arrays类中有sort的重载方法

 * 3.可变个数形参的方法
 *  3.1 jdk5.0 新增内容
 *  3.2 具体使用：当调用可变形参的方法时，传入的参数个数可以是0个 、1个以及多个
 *  3.3 可变个数形参的方法于本类中方法名相同，形参不同的方法之间构成重载
 *  3.4 可变个数参数方法  不能和 数组参数 方法同时出现，会被编译器认定为相同方法，不是重载方法
 *           可变个数形参方法于本类中相同类型数组形参方法不能共存，会被认定为相同方法
 *            方法调用过程可以和调用数组方法一样，不会报错
 *  3.5 可变个数形参必须声明在形参的末尾，作为最后一个参数
 *  3.6 可变个数形参一个方法中只能存在一个
 *
 */
public class MethodArgs {
    public void show(int i) {
        System.out.println("use the interge");
    }

    public void show(String string) {
        System.out.println("use the String");
    }

    //可变个数形参
    public void show(String... strings) {
        System.out.println("use the variational");
    }

    public void show(int... nums){}

//    public void show(String[] strings) {
//
//    }

    public void showTest() {
        show(12);
        show("Hello");
        //调用可变形参的方法，数据类型为指定类型即可
        show("Hello", "World");
    }
}
