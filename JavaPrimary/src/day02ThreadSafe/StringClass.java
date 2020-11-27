package day02ThreadSafe;

/*
 *   引用类型——String
 *       1、声明String变量的时，使用双引号  ""
 *       2、String类型可以和8种基本数据类型变量做运算，且运算只能是连接运算： +
 *       3、与String做运算的结果仍然是String
 *       4、运算中遇到String类型变量后，后面的数据类型都成为String类型
 * */
public class StringClass {

    public void testString() {
        int number = 10011;
        String numberStr = "学号";
        System.out.println(numberStr + number) ;
        //结果只能升级String类型，

         //练习1
        char c = 'a' ;
        int num = 10 ;
        String str = "hello" ;
        System.out.println(c + num + str); // 107hello
        System.out.println(c + str + num);//ahello10
        System.out.println(c + (num+ str));//a10hello
        System.out.println((c + num) + str);//107hello
        System.out.println(str + num  + c);//hello10a

        //练习2，控制台输出 * (Tab) *
        System.out.println("*   *");//对
        System.out.println('*' + '\t' + '*');//错
        System.out.println('*' + "\t" + '*');//对
        System.out.println('*' + '\t' + "*");//错
        System.out.println('*' + ('\t' + "*"));//对

    }

}
