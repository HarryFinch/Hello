package day11Java8NewFeatures.java;

import org.junit.Test;

import java.util.Comparator;

/*
 * @author Harold
 * @Date 2020/4/23
 * @Description : Lambda 表达式的举例
 *
 */
public class LambdaExpression {

    @Test
    public void test1() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love programming");
            }
        };
        run1.run();
        System.out.println("Lambda Expression");
        Runnable run2 = () -> System.out.println("I love Java");

        run2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        //Lambda表达式
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(151, 14));

        //方法引用
        Comparator<Integer> com3 = Integer :: compareTo;
        System.out.println(com2.compare(14, 14));
    }


}
