package day11Java8NewFeatures.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/*
 * @author Harold
 * @Date 2020/4/23
 * @Description : Lambda表达式的使用
 *  例子 ：
 *      1、举例(o1,o2) -> Integer.compare(o1,o2)
 *      2、格式 -> : Lambda 操作符（箭头操作符）
 *              左边是Lambda是形参列表，其实就是接口总的抽象方法的形参列表
 *              右边是Lambda体，其实就是重写抽象发发的方法体
 *      3、Lambda表达式的使用（6种情况）
 *          3.1、语法格式一  ： 无参，无返回值
 *          3.2、Lambda 需要一个参数，但没有返回值
 *          3.3、数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
 *          3.4、若只需要一个参数时，参数的小括号可以省略
 *          3.5、需要两个或以上的参数，多条执行语句，并且可以有返回值
 *          3.6、当Lambda体只有一条语句时，return与大括号若有，都可以省略
 *
 *      4、Lambda表达式的本质 ： 作为接口的实例，就是对象
 *      5、一个接口中，只声明了一个抽象方法，此接口称为函数式接口
 *          @FunctionalInterface注解可以表明该接口是一个函数式接口，用于校验
 *
 */
public class LambdaExpression1 {

    //语法格式一  ： 无参，无返回值
    @Test
    public void test1() {
        //接口的匿名实现类
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love programming");
            }
        };
        run1.run();

        //Lambda表达式
        System.out.println("Lambda Expression");
        Runnable run2 = () -> System.out.println("I love Java");

        run2.run();
    }

    //Lambda 需要一个参数，但没有返回值
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Hello-World");

        //Lambda表达式
        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("Hi");
    }

    //数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3() {
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        consumer.accept("No Data Type");
    }

    // 3.4、若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("一个参数时，参数的小括号是可以省略的，这个还没省略括号");

        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("一个参数时，参数的小括号是可以省略的，这个省略了括号");
    }

    // 3.5、需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator1.compare(23, 13));
        System.out.println("------Lambda--------");
        Comparator<Integer> comparator2 = (o1,o2) -> {
            System.out.println("o1 : " + o1);
            System.out.println("o2 : " + o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator2.compare(12, 21));
    }

    //当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6() {
        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println("o1 :" + o1);
            System.out.println("o2 :" + o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(12, 6));

        Comparator<Integer> comparator2 = (o1, o2) ->  o1.compareTo(o2);
        System.out.println(comparator1.compare(12, 16));

    }

}
