package day13.Wrapper;

import org.junit.Test;

/*
    面试题目
 */
public class wrapperInterview {

    @Test
    public void testMethod1() {
        //自动类型提升，编译过程中两个类型统一了
        Object object1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(object1);
    }

    @Test
    public void testMethod2() {
        //不需要类型提升
        Object object;
        if (true) {
            object = new Integer(1);
        } else {
            object = new Double(2.0);
        }
        System.out.println(object);
    }

    @Test
    public void testMethod3() {
        Integer i = new Integer(1);
        Integer j = new Integer(2);
        //false  比较的是地址
        System.out.println(i == j);

        /*
        Integer内部定义了IntegerCache结构，IntegerCache中地给予了Integer[]
        保存了-128 --- 127 范围的整数，如果使用了这个范围内的值，可以直接使用数组中的元素，无需构造新的对象 ，提高了效率

        下面两个结果不同的原因是Integer内部创造了一个数组，
        数组存储数字的范围是 -128 --- 127 ，这些数随用随取，无需构造对象
        而范围之外的数字则需要构造新的对象
         */
        Integer m = 1;
        Integer n = 1;
        //true 直接使用了Integer中的数组
        System.out.println(m == n);

        Integer x = 128;
        Integer y = 128;
        //false  构造了Integer对象
        System.out.println(x == y);
    }
}
