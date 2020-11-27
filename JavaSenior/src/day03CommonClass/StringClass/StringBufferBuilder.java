package day03CommonClass.StringClass;

import org.junit.Test;

/*
 * @Author: Harold
 * @Date: 2020/3/21 16:19
 * @Description: StringBuffer 、 StringBuilder的使用
 *
 *  String、StringBuffer、StringBuilder三者异同
 *      String  不可变的字符序列
 *      StringBuffer   可变的字符序列，线程安全的，效率低
 *      StringBuilder  可变的字符序列，线程不安全的，效率高
 *
 *      三者相同点：底层都使用char[]存储
 *
 *  源码分析：
 *      String str1 = new String();//new char[0]
 *      String str2 = new String("ABC")//new char[]{'A','B','C'}
 *
 * //new char[16],底层创建了一个长度为16的数组
 *      StringBuffer  stringbuffer1 = new StringBuffer() ;
 *      stringbuffer.append('a')//value[0] = a
 *      stringbuffer.append('b')//value[1] = b
 *
 *      //StringBuffer扩容问题
 *      默认情况下，扩容为原来的二倍+2，同时将原有的数组复制到新数组中
 *      如果默认扩容不够，则按照薪字符串的长度扩容
 *
 *
 *      //new char[19]   value.length + 16
 *      StringBuffer  stringbuffer2 = new StringBuffer("abc") ;
 *      sout(stringbuffer.length) //结果为3
 *
 *  开发中建议使用StringBuffer(int capacity)或者StringBuilder(int capacity)
 *
 */

/*
    StringBuffer类中的常用方法
        StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
        StringBuffer delete(int start,int end)：删除指定位置的内容
        StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
        StringBuffer insert(int offset, xxx)：在指定位置插入xxx
        StringBuffer reverse() ：把当前字符序列逆转
        public String substring(start , end)//前闭后开截取字符串
        public int length() //和String类的length一样
        public char charAt(int n) //获取单个字符
        public void setCharAt(int n,char ch) //替换指定位置的字符值
 */

public class StringBufferBuilder {

    @Test
    public void test1() {
        StringBuffer stringb1 = new StringBuffer("abc");
        stringb1.setCharAt(0, 'm');//setCharAt是void方法
        System.out.println("CharAtReplacement : " + stringb1);
        stringb1.append("def");
        System.out.println("StringAppend : " + stringb1);

        StringBuffer stringbuffer2 = new StringBuffer("abc");
        System.out.println(stringbuffer2.length());//结果为3
    }


    //StringBuffer相关方法的练习
    @Test
    public void test2() {
        StringBuffer stringBuffer1 = new StringBuffer("abc");
        stringBuffer1.equals(stringBuffer1);
        stringBuffer1.append(1);
        stringBuffer1.append('1');
        System.out.println(stringBuffer1);
        //前闭后开
        System.out.println(stringBuffer1.delete(2, 4));
        System.out.println(stringBuffer1.replace(0, 3, "Hello"));
        System.out.println(stringBuffer1.insert(7, 'm'));
        System.out.println(stringBuffer1.reverse());
        stringBuffer1.setCharAt(2, 'P');
        System.out.println(stringBuffer1);
    }



    //String  < StringBuffer < tringBuilder效率的对比，见test3
    @Test
    public void test3() {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }


}
