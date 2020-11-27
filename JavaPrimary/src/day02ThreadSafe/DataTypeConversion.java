/*
Java自动数据类型转换、强制类型转换
不同数据类型之间运算不包含boolean类型
 */

/*
    一、自动类型提升
        1、容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
            byte -> short -> int -> long -> double
        2、short 、 char、 byte  三类型做运算，其运算结果需要用 int 类型储存

    二、强制类型转换
        1、强制类型转换是自动提升运算的逆运算
        2、强制转换没有四舍五入（截断操作），浮点数强制转换整型会损失精度
        3、
     ！！说明： 容量大小指的是，变量类型能标示顿范围的大小，而不是该类型所占用的字节数的多少

    三、变量运算规则的两个特殊情况
        1、long型常量末尾不加后缀默认为int类型，当数值过大是编译报错
        2、float类型常量必须加后缀，否则编译无法通过，因为double类型比float类型大
        3、整型常量默认是int类型；浮点型常量默认是double类型

 */
package day02ThreadSafe;

public class DataTypeConversion {

    public void Calculate(){

        byte b1 = 2 ;//-128——127
        int i1 = 12 ; //-2^15 —— 2^15-1
        //用字节占用大的储存运算结果，
        //整数运算结果可用以浮点型变量储存（输出结果虚拟机会自动补全小数位）
        //byte表示一字节，一个字节占8位，位存储0或1
        int results1 = b1 + i1 ;

        int i2 = b1 + i1  ;
        long l1 = b1 + i1 ;
        System.out.println(i2);

        float f = b1 + i1 ;
        System.out.println(f);

        short s1 = 123 ;
        double d1 = s1 ;
        System.out.println(d1);

        //*********分隔符***************/
        /*
            \n :换行符
            \t :制表符
            主要是用声明字符和转义字符
         */
        char c1 = 'a' ; //不能为空，必须有一个字符
        int i3 = 10 ;
        int i4 = c1 + i3 ;
        System.out.println(i4) ;

        /***************强制类型转换************************/
        double d5 = 123.9 ;
        int i5 = (int)d5 ; //截断操作，没有四舍五入，小数点之后截断，可能导致精度损失
        System.out.println(i5);

        long l5 = 123 ;
        short s2 = (short)l5 ;

        //精度损失举例,需深入二进制层次解释
        int i6 = 128;
        byte b = (byte)i6 ;
        System.out.println(b);

        //***************char问题*******************/
        char c2 = 'a' ;
        int i7 = 10 ;
        int i8 = c2 + i7 ;
        System.out.println(i8);

        short s3 = 10 ;
        //char c3 = c2 + s3   编译不通过
        byte b2 = 10 ;
        //cahr c4 = c2 + b2   编译不通过
        /*
        * 字符集问题：
        *   UTF-8是Unicode的一种实现，包含目前已知的所有字符
        *   命令行默认字符集是GBK字符集
        * */
        /*
        整型：
            1、常定义整型变量时使用int类型，short、byte类型容易发生溢出
            2、long型常量末尾加L或l作为后缀表示常量
        浮点型：
            1、float（四字节）可以精确到7位小数，double（8字节）可以精确到14位
            2、float定义常量是末尾加F或f作为后缀
        char型：
            1、字符型：char（1字节--2字节）
        boolean：
            1、只有两个值 true、 false
            2、常在条件判断、循环结构中使用
        */

        /*
        * Java定义的数据类型
        *   一、变量按照数据类型分：
        *       基础数据类型
        *          整型：ibyte、short、int、long
        *          浮点型：float、double
        *          字符型：char
        *          布尔型：boolean
        *       引用类型：
        *           类（class）
        *           接口（interface）
        *           数组（array）
        *
        *   二、变量在类中的声明位置：
        *       成员变量  局部变量
        *
        *   三、基本规则：
        *       前提：只是7种基本数据类型变量之间的运算，不包含boolean类型
        *       1、自动类型提升：
        *           存储范围小的向存储范围大的合并，数据类型提升至存储范围大的类型
        *               （大小指的是表示数的大小，不是占用内存大小）
        *           byte、char、short（三者运算结果都是int） ——> int ——> long ——> float ——> long
        *
        *           整型向浮点型转换，输出时整型末尾会补上“.0”
        *           123 ——> 123.0
        *
        *       2、强制类型转换：自动类型提升运算的逆运算
        *
        */

    }
}
