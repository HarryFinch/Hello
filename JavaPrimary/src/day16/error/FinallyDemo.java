package day16.error;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    try-catch-finally
    1、finally的使用：一定会执行的代码放在finally块中
    2、finally中声明的是一定会被执行的代码，即使catch中出现异常，try中出现return语句
        catch中有return语句
    3、finally的使用场景：
        像数据库链接、输入输出流、网络编程Socket等资源，JVM不能自动回收。需要我们自己手动进行资源的释放
        此时的资源释放就需要声明在finally中
    4、try-catch-finally结构可以嵌套使用
    5、实际开发中，运行时异常很少去做处理，但是编译时异常，必须处理，否则不能运行啊（没准就是推迟了该来的）

 */
public class FinallyDemo {

    @Test
    public void test2() {
        File file = new File("hello.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int data = inputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputStream.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void methos() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
//            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
//            return 2;
        } finally {
            System.out.println("执行");
        }
    }


    @Test
    public void test1() {

        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("hello");
        }
    }
}
