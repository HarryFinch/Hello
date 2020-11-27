package day16.error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    异常处理的方式二：throws + 异常类型
    1、声明在方法末尾处  method() throws + 异常类型，出现异常时仍会生成一个异常类对象，异常后的代码就不再执行
        此时没有finally结构
    2、try-catch-finally真正地处理了异常
        throws将方法抛给了方法调用者，并没有处理异常
    3、开发中如何选择try-catch-finally还是使用throws
        3.1 父类中重写的方法没有抛出异常，那么子类只能使用try-catch-finally处理
        3.2 执行的方法中，先后调用了其他几个方法，几个方法是递进关系执行的，
            建议这几个方式使用throws方式处理，而执行方法可以使用try-catch方式处理
 */
public class ExceptionDemo2 {

    public static void main(String[] args) {

        method3();

        /*try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static void method3() {
        try {
            method2();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void method2() throws FileNotFoundException, IOException {
        method1();
    }


    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");

        FileInputStream inputStream = new FileInputStream(file);
        int data = inputStream.read();

        inputStream.close();
    }
}
