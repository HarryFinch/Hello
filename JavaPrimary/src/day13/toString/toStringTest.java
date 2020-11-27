package day13.toString;

import day13.objectIntroduce.Customer;

import java.util.Date;

/*
    Object类中的toString方法的使用
    1、当输出对象引用时，实际上就是调用当前对象的toString方法
    2、Object类中toString方法的定义
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
    3、String类、Date、File包装类等都重写了Object类中的toString方法，使得在调用toString方法时，返回“实体内容”信息
    4、自定义类重写toString方法，当调用此方法是返回对象的“实体内容”信息
 */
public class toStringTest {
    public static void main(String[] args) {
        Customer cust1 = new Customer("Harold" , 20) ;
        System.out.println(cust1.toString());
        System.out.println(cust1);

        String string1 = new String("Harold") ;
        System.out.println(string1);

        Date date = new Date(12313) ;
        System.out.println(date);
    }
}
