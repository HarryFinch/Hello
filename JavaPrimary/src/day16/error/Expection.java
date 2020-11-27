package day16.error;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Struct;
import java.util.Date;
import java.util.Scanner;

/*
    一、异常的体系结构
        1、java.lang.Throwable
            |-- java.lang.Error : 一般不编写针对性的代码进行处理
            |-- java.lang.Exception ： 可以进行异常的处理
                |-- 编译时异常（checked）
                    |--IOException
                        |--FileNotFoundException
                    |-- ClassNotFoundException
                |-- 运行时异常（unchecked）
                    |-- NullPointerException
                    |-- ArrayIndexOutOfBoundException
                    |-- ClassCastException
                    |-- NumberFormatException
                    |-- InputMismatchException
                    |-- ArithmeticException


 */
public class Expection {

    //FileNotFoundException
/*    @Test
    public void test7() throws FileNotFoundException {
        File file = new File("hello.txt");
        FileInputStream inputStream = new FileInputStream(file);
        int data = inputStream.read();
    }*/

    /*-------------------运行时异常-----------------------------*/
    //ArithmaticException
    @Test
    public void test6() {
        int a = 1;
        int b = 0;
        //算数表达式不能除0，算术异常
        System.out.println(a / b );
    }

    //InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        //不输入整型，出现异常
        int score = scanner.nextInt();
        System.out.println(score);

    }



    //NumberFirmatException
    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        Integer.parseInt(str);
    }

    @Test
    public void test3() {
        /*
        NullPointer
        int[] arr = null;
        System.out.println(arr);
        */
        String str = "abc";
//        str = null ;//空指针异常
        System.out.println(str.charAt(0));
    }

    @Test
    public void test2() {
        int[] arr = new int[3];
        String[] str = new String[3];
        System.out.println(arr[3]);//ArrayIndexoutOfBoundException
        System.out.println(str[3]);//ArrayIndexoutOfBoundException
    }


    // ClassCastException
    @Test
    public void test1() {
        Object object = new Date();
        String str = (String) object;
    }
}
