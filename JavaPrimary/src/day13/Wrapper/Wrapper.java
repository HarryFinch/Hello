package day13.Wrapper;

import org.junit.Test;

/*
    包装类的使用
    1、Java提供了八种基本数据类型，使得基本数据类型的变量具有类的特征
    2、基本数据类型、包装类、String三者转换
 */
public class Wrapper {

    //String类型 ---  基本数据类型、包装类,调用包装类中parseXXX方法
    @Test
    public void wrapperTest4() {
        //可能会报NumberFormatException
        String string1 = "123";
        System.out.println(Integer.parseInt(string1));

        String string2 = "true";
        boolean b1 = Boolean.parseBoolean(string2);
        System.out.println(b1);
    }

    //基本数据类型、包装类  ---  String类型
    @Test
    public void wrapperTest3() {
        int num1 = 10;

        //方式一： 直接字符串运算
        String string1 = num1 + "";

        //调用String重载的ValueOf
        float f1 = 12.3f;
        String string2 = String.valueOf(f1);
        System.out.println();
        Double d1 = new Double(12.4);
        String string3 = String.valueOf(d1);
        System.out.println(string2);//"12.3"
        System.out.println(string3);//"12.4"
    }

    /*
        JDK5.0新特性，自动装箱与拆箱
     */
    @Test
    public void wrapperTest2() {
        int number1 = 10;
        method(number1);

        //自动装箱
        int number2 = 20;
        Integer integer3 = number2;

        boolean b1 = true;
        Boolean b2 = b1;

        //自动开箱
        System.out.println(integer3.toString());
        int number3 = integer3;
    }


    public void method(Object object) {
        System.out.println(object);
    }

    //包装类 --- 基本数据类型  调用包装类的xxxValue()
    @Test
    public void wrapperTest1() {
        Integer integer1 = new Integer(12);
        System.out.println(integer1.intValue());

        Float f1 = new Float(12.2);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }

    //基本数据类型 ---  包装类
    @Test
    public void wrapperTest() {
        int number1 = 10;
        Integer integer1 = new Integer(number1);
        System.out.println(integer1.toString());

        Integer integer2 = new Integer("123");
        System.out.println(integer2);

        Float f1 = new Float(12.3F);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("true123");//fasle

    }

}