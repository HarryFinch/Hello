package day03CommonClass.StringClass;

import org.junit.Test;

/*
 * @Author: Harold
 * @Date: 2020/3/19 22:26
 * @Description : String字符串的使用
 *  1、String 字符串 使用一对""表示
 *  2、String声明为final的，不可被继承
 *  3、String实现了Serializable接口：表示字符串是支持序列化的
 *  4、String实现了Comparable接口，String是可以比较大小的
 *  5、String内部定义了final char[] value 用于存储字符串数据
 *  6、String代表不可变的字符序列。简称不可变性
 *      体现1 ： 当对字符串重新赋值时，需要重写指定内存区域，不能使用原有的value进行赋值
 *      体现2 ； 当对现有的字符串进行操作时，需要重新指定内存空间，不能在原有的数据上进行修改
 *      体现3 ： 当调用replace方式修改字符或字符串时，也必须重新构造字符串，不能在原有的上改动
 *  7、通过字面量方式（区别new）给一个字符串赋值，此时字符串值声明在字符串常量池中
 *  8、字符串常量池中是不会存储相同内容的字符串的
 */
public class StringDemo {

    @Test
    public void test3() {

        /*
            常量与常量的拼接结果在常量池，常量池中不会存储相同的内容
            只要出现变量了，就相当于是在堆空间中new了一个

            intern()方法，返回值在常量池中
         */
        String string1 = "JavaEE" ;
        String string2 = "Hadoop" ;

        String string3 = "JavaEEHadoop";
        String string4 = "JavaEE" + "Hadoop";

        String string5 = string1 + "Hadoop";
        String string6 = "JavaEE" + string2;
        String string7 = string1 + string2;



        System.out.println(string3 == string4);//true
        System.out.println(string3 == string5);//false
        System.out.println(string3 == string6);//false
        System.out.println(string3 == string7);//false
        System.out.println(string5 == string6);//false
        System.out.println(string5 == string7);//false

        //返回值得到的string8使用的是常量值中已经存在的JavaEEHadoop
        String string8 = string5.intern();
        System.out.println(string3 == string8); //true

    }



    /*
    String 的实例化方式
        1、通过字面量定义的方式
        2、通过new + 构造器的方式
     */
    @Test
    public void test2() {
        String s1 = "JavaEE" ;
        String s2 = "JavaEE" ;

        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
//        System.out.println(s2 == s2);
         
    }


    @Test
    public void test1() {
        String s1 = "abc"; //字面量的定义方式
        String s2 = "abc" ;
        s1  = "Hello" ;
        String s3 = "abc" ;
        s3 += "def";//并不是在原有的基础上增加的

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("*****************************************");
        System.out.println(s3);

        String s4 = "abc" ;
        s4.replace('a' , 'o');
    }
}
