package day06Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/25 16:52
 * @Description: ①泛型类、接口泛型； ②泛型方法
 *  1、定义了泛型类，但是初始化时没有指明泛型类型，默认为Object类型
 *      因此建议定义了泛型就使用泛型
 *  2、继承时指明具体泛型类型，子类构造对象不用指明泛型
 *  3、泛型引用不能赋值
 *  4、异常类不能是泛型，异常处理也不能是泛型
 *
 *  5、泛型方法：
 *      5.1 方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系
 *          也就是说，泛型方法所在的类是不是泛型也都可以
 *      5.2 泛型方法可以声明为静态的，因为泛型参数是在调用方法时确定的，并非在实例化的时候确定
 *--------------见GenericDemo2----------
 *  6、泛型在继承方面的体现
 *  7、通配符的使用
 *
 */
public class GenericDemo1 {

    @Test
    public void test1() {
        //未使用泛型
        Order order = new Order();
        order.setOrderT(1);

        Order<String > order1 = new Order<String>("OrderAA" , 100 , "First");
//        order1.setOrderT("Hello");
    }

    @Test
    public void test2() {
        SubOrder subOrder = new SubOrder();
        //
        subOrder.setOrderT(1111);
    }

    @Test
    public void test3() {
        ArrayList<String> list = null;
        ArrayList<Integer> list1 = new ArrayList<>();
    }


    //泛型方法测试
    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
