package day03;

/*
 *   1、运算符之一：
 *       算术运算符：+ - /  * a++ ++a a-- --a
 *   2\
 * */
public class AriTest {

    public static void main(String[] args) {
        AriTest at = new AriTest();
        at.division();
    }

    //除号
    public void division() {

        int num1 = 12;
        int num2 = 5;
        int result1 = num1 / num2;
        System.out.println(result1);//输出2

        int result2 = num1 / num2 * num2;
        System.out.println(result2); //输出10

        double result3 = num1 / num2;
        System.out.println(result3); //输出2.0

        double result4 = num1 / num2 + 0.0; //输出2.0
        double result5 = num1 / (num2 + 0.0); //输出2.4
        double result6 = (double) num1 / num2; //输出2.4
        double result7 = (double) (num1 / num2);//输出2.0
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result6);
        System.out.println(result7);
    }

    /*取余运算 %
     *结果的符号与被模数符号相同
     * 开发中，经常使用%来判断能否被除尽的情况
     */
    public void modMethod() {
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 =  " + m1 % n1); //2

        int m2 = -12;
        int n2 = 5;
        System.out.println("m2 % n2 =  " + m2 % n2); //-2

        int m3 = 12;
        int n3 = -5;
        System.out.println("m3 % n3 =  " + m3 % n3); //2

        int m4 = -12;
        int n4 = -5;
        System.out.println("m4 % n4 =  " + m4 % n4); //-2

    }

    //自加、自减运算，自运算不会改变本身的数据类型
    public void selfMethod() {
        int a1 = 10;
        int b1 = ++a1;
        System.out.println(b1); //11

        int a2 = 10;
        int b2 = a2++;
        System.out.println(b2); // 10

        int a3 = 10;
        int b3 = --a3;
        System.out.println(b3);

        int a4 = 10;
        int b4 = a4--;
        System.out.println(b4);

        //注意点
        short s1 = 10;
        //s1 = s1 +1  编译失败
        //s1 = (short)(s1 +1) 正确
        //s1++

        //问题
        byte byte1 = 127;
        byte1++;
        System.out.println(byte1); //-128
    }

    //赋值运算符，不会改变变量自身数据类型
    public void setValue() {
        int i1 = 10;
        int j1 = 10;

        //连续赋值
        int i2, j2;
        i2 = j2 = 10;
    }

    public void compareTest() {
        /*
        == 、!= 、> 、 < 、>= 、<= instanceof
        结论：
            1、比较运算符的结果是boolean类型
            2、区别 == 和 =
        */
    }

    public void byteMove() {
        /*
            1、位运算符的操作数都是整数
            2、<<：在一定范围内，每向左移都相当于乘2，最低位补0
            3、>>:在一定范围内，每向右移都相当于除2，最高位原来是啥补啥
            4、>>>：右移高位都用0补
         */
        //数值交换
        int a = 10 ;
        int b = 20 ;

        //方法一
        int c = a ;
        a = b ;
        b = c ;

        //方法二：
            //好处：不用定义临时变量
            //弊端：①相加结果可能存在溢出②只能用于数字交换
        a = a + b ;
        b = a - b ;
        a = a - b ;

        //方法三 ：使用位运算符，只能适用于数值类型
        a = a ^ b ;
        b = a ^ b ;
        a = a ^ b ;
    }

    //三元运算符
    public void ternary() {
        /*
        1、结构（条件表达式） ？ 表达式1 ： 表达式2
        2、说明
            ①条件表达式的结果为boolean类型
            ②根据条件表达式真或假，决定执行表达式1还是表达式2
                如果表达式俄日true，则执行表达式1
                如果表达式为false，则执行表达式2
            ③表达式1和表达式2要求数据类型一致
            ④三元运算符可嵌套使用
            ⑤凡是能使用三元运算符的地方都可以使用if—else
         */
        int m = 12 ;
        int n = 5 ;
        int max = m > n ? m : n ;
        System.out.println( max );

        //获取三个数的最大值
        int n1 = 12 ;
        int n2 = 30 ;
        int n3 = -43 ;
        int max1 = n1 > n2 ?  n1 : n2 ;
        int max2  = max1 > n3 ? max1 :n3 ;
        System.out.println(max2);

        int max4 = (((n1 > n2 ) ? n1 : n2 ) > n3 ) ? ((n1 > n2 ) ? n1 : n2 ):n3 ;
        System.out.println(max4);

    }
}
