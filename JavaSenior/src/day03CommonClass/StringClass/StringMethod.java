package day03CommonClass.StringClass;

import org.junit.Test;

/*
 * @Author: Harold
 * @Date: 2020/3/20 8:14
 * @Description : String中的常用方法
 *
 */
public class StringMethod {

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(3));
        System.out.println(s1.isEmpty());

        //大小写转换并不改写原来字符的情况
        String s2 = s1.toLowerCase();
        String s3 = s1.toUpperCase();
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s2);
        System.out.println(s3);

        String s4 = "   He llo world   ";
        System.out.println(s4.trim());


    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        System.out.println(s3.concat("def"));
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = "abd";
        //字符串排序
        System.out.println(s1.compareTo(s2));
    }

    @Test
    public void test4() {
        String s1 = "HelloWorld";
        //从指定位置开始到结尾
        System.out.println(s1.substring(5));
        //从指定位置开始，到指定位置结束（不包含最后一个）
        System.out.println(s1.substring(5, 10));
    }

    @Test
    public void test5() {
        String string1 = "HelloWorld";
        String string2 = "helloworld";
        System.out.println(string1.contains("llo"));

        System.out.println(string2.compareTo(string1));
        System.out.println(string1.startsWith("He"));
        System.out.println(string1.startsWith("Wo" , 5));
        System.out.println(string1.indexOf("Wo" , 5));

    }
}
