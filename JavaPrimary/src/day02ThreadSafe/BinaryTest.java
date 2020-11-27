package day02ThreadSafe;
/*
*   计算机中几种进制的说明：
*       二进制
*       八进制
*       十进制
*       十六进制
*       任意两种进制相互转换，一般以二进制为媒介，十六进制、八进制转换为二进制，再转为十进制
* */
public class BinaryTest {
    public void test() {
        int number1 = 0b110 ;
        int number2 = 110 ;
        int number3 = 01237 ;
        int number4 = 0x110A ;
        System.out.println("number1  :  " + number1);
        System.out.println("number2  :  " + number2);
        System.out.println("number3  :  " + number3);
        System.out.println("number4  :  " + number4);
        //输出是10进制数
    }
}
