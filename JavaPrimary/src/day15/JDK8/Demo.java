package day15.JDK8;

public interface Demo {
    //静态方法
    static void method1(){
        System.out.println("CompareA : Beijing");
    }

    //默认方法
    default void method2(){
        System.out.println("CompareA : ShangHai");
    }
}
