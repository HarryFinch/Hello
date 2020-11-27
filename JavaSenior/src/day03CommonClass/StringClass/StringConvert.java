package day03CommonClass.StringClass;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * @Author: Harold
 * @Date: 2020/3/21 15:18
 * @Description: String 和基本数据数据类型、包装类的转换
 *
 */
public class StringConvert {

    //String ----> 基本数据类型，包装类
    @Test
    public void test1() {
        String string1 = "123456789";
        int numString = Integer.parseInt(string1);
        System.out.println("String -- Number : " + numString);

        int number1 = 123456789;
        String strNum1 = number1 + "";
        String strNum2 = String.valueOf(number1);
        System.out.println("Number -- String kong : " + strNum1);
        System.out.println("Number ---String valueOf : " + strNum2);

    }

    //String <----> char[]
    @Test
    public void test2() {
        //String ----> char[]
        String string1 = "String Convert to char ";
        char[] strArr = string1.toCharArray();
//        System.out.println("String --- char[]" + string1.toCharArray());
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("char[" + i + "]" + strArr[i]);
        }

        //String <---- char[]
        char[] strArr1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        String string2 = new String(strArr1);
        System.out.println(string2);
    }

    //String <----->byte[]
    @Test
    public void test3() throws UnsupportedEncodingException {

        //String ---> byte[]
        String string1 = "abc123中国";
        //使用默认的字符集转换
        byte[] strByte = string1.getBytes();

        //设置GBK字符集，一个字符占用两个字符
        byte[] strByteGBK = string1.getBytes("gbk");
        System.out.println(Arrays.toString(strByteGBK));

        String string2 = new String(strByte);
        System.out.println(string2);

        //strByteGBK与string3编码集不一致，出现里乱码
        String string3 = new String(strByteGBK);
        System.out.println(string3);

        //设置编码集
        String string4 = new String(strByteGBK , "gbk");
        System.out.println(string4);

//        System.out.println("String ---> byte[] : " + string1.getBytes());
/*        for (int i = 0; i < strByte.length; i++) {
            System.out.println("strByte[ " + i + " ]" + strByte[i]);
        }*/
    }


    @Test
    public void test4() {
        String string1 = "javaEEhadoop";
        String string2 = "javaEE";
        String string3 = string2 + "hadoop";
        System.out.println(string1 == string3);
        string1.trim();
        final String string4 = "javaEE" ;
        String string5 = string4 + "hadoop" ;
        System.out.println(string1 == string5);

    }
}
