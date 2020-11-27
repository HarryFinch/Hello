package day15.JDK8;

/*
    JDK8中，除了定义全局变量和抽象方法之外，还可以定义静态方法、默认方法
 */
public class CompareA {
    public static void main(String[] args) {
        Subclass subclass = new Subclass();
        subclass.method2();

        //接口中定义的静态方法，只能通过接口调用
        Demo.method1();

        //通过实现类重写了接口中的默认方法，调用时，仍然调用是重写的方法
        subclass.method2();

        /*
        子类（或实现类）继承的父类和实现的接口中实现了同名同参数的方法
        在没有重写的情况下，优先调用类中的方法
        */

        /*
        类继承了多个接口，接口实现了同名同参数的方法
        在没有重写的情况下，报错，接口冲突
        在实现类中必须要重写方法
        */
        subclass.method3();
    }
}

class Subclass extends SuperClass implements Demo, CompareB {
    public void method2() {
        System.out.println("CompareA : ShangHai1");
    }

    public void method3() {
        System.out.println("Compare : ShenZhen");
    }

    public void myMethod() {
//        如何在子类（或实现类）的方法中调用父类、接口中呗重写的方法，如下
        method3();
        super.method3();
        Demo.super.method2();
    }
}