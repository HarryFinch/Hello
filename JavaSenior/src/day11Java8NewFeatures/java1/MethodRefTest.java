package day11Java8NewFeatures.java1;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 * @author Harold
 * @Date 2020/4/23
 * @Description : 方法引用  --- 本质就是Lambda表达式
 * 	1、方法引用是使用情景
 * 		当传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *	2、方法引用  --- 本质就是Lambda表达式，而Lambda表达式作为函数式接口的实例，
 * 		所以方法引用也就是函数式接口的实例
 * 	3、使用格式  调用者 :: 方法名
 * 	4、分为如下的三种情况
 * 		对象 ::  非静态方法
 * 		 类  :: 调用静态方法
 * 		 类  :: 非静态方法
 * 	5、方式引用使用的要求
 *		5.1、接口中抽象方法的形参列表和返回值  与  方法引用方法的形参列表和返回值类型相同
 */
public class MethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("beijing");
        System.out.println("---------------方法引用-------------------------");

        PrintStream ps = System.out;
        Consumer<String> consumer2 = ps::println;
        consumer2.accept("BeiJing");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        Employee employee1 = new Employee(1001, "Harold", 22, 560000);
        Supplier<String> supplier1 = () -> employee1.getName();
        System.out.println(supplier1.get());

        System.out.println("------------------方法引用--------------------------");

        Supplier<String> supplier2 = employee1::getName;
        System.out.println(supplier2.get());
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> comparator1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator1.compare(12, 21));

        System.out.println("------------------方法引用--------------------------");

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator1.compare(21, 12));
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        Function<Double, Long> function1 = d -> Math.round(d);

        System.out.println("------------------方法引用--------------------------");

        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(12.3));


    }

    // 情况三：类 :: 实例方法
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {

        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));
        System.out.println("-----------------------");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abm"));

    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc", "abc"));
        System.out.println("-----------------");
        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("acv", "avc"));
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        Employee employee = new Employee(1001, "Harold", 20, 30000);
        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));
    }

}
