package day11Java8NewFeatures.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
 * @author Harold
 * @Date 2020/4/24
 * @Description : java 内置的4大核心函数式接口
 *
 *  1、消费型接口  Consumer<T>   --- void accept(T t)
 *  2、供给型接口  Supplier<T>   --- T get()
 *  3、函数型接口  Function<T,R> --- R apply(T t)
 *  4、断定型接口  Predicate(<T> --- boolean test(T t)
 *
 */
public class LambdaExpression2 {

    @Test
    public void testConsumer() {
        happyTime(59990, money -> System.out.println("Hello"));
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void testSupplier() {
        List<String> list = Arrays.asList("北京","天津","南京");
        System.out.println(filterString(list, s -> s.contains("京")));
    }

    //根据给定的规则，过滤集合中的字符串，此规则有Predicate的方法决定的
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

}
