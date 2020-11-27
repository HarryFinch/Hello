package day16.error;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    异常处理：抓抛模型

    过程一（抛出异常）：
           1、程序正常执行的过程，一旦出现异常，就在异常代码除生成一个对应的异常类对象
              并将对象抛出。一旦抛出对象以后，异常处后的代码不再执行（自动生成异常对象）
            2、手动生成一个异常对象，并抛出（throw）


    过程二（抓取异常） ：可以理解为异常的处理方式
        1、try-catch-finally的使用
            try｛
                //可能出现异常的代码
            ｝catch（异常类型  变量名）｛
                //处理异常的方式
            ｝catch（异常类型  变量名）｛
                //处理异常的方式
            ｝finally｛
                //一定会执行的代码,但是结构是可选的
            ｝
            try-catch中一张对象匹配到某一个catch是，就进入catch中进行异常处理。
            一旦处理完成，就跳出当前的try-catch结构（在没有写finally的情况下），
            继续执行其后的代码

        2、catch中的异常类型若没有子父类关系就没有先后顺序
            若有子父类关系，则子类一定要声明在父类上面
        3、常用的异常帝乡处理方式
            3.1 String getMessage()
            3.2 printStackTrace()
        4、在try结构中声明的变量，在try结构外不能使用
        5、使用try-catch-finally处理编译时异常，但运行仍可能出错
 */
public class ExceptionDemo {

    //FileNotFoundException
    @Test
    public void test7()  {
        File file = new File("hello.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int data = inputStream.read();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException  e) {
            e.printStackTrace();
        }

    }



    @Test
    public void test1() {
        String string = "123";
        string = "abc";
        try{
            int num = Integer.parseInt(string);
            System.out.println("Hello -----1");
        }catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println("Hello -----1");
    }
}
