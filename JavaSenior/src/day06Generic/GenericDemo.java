package day06Generic;

import org.junit.Test;

import java.util.*;

/*
 * @Author: Harold
 * @Date: 2020/3/25 15:49
 * @Description: 泛型的使用
 *  1、泛型是JDK1.5新增特性
 *  2、单纯的ArrayList线程不安全
 *
 *  3、在集合中使用泛型
 *      3.1 集合接口或集合类在JDK5.0时都修改为带泛型的类型结构
 *      3.2 在实例化集合类时，可以指明具体的泛型类型
 *      3.3 指明以后，在集合类或者接口中，凡事定义类或接口时，
 *          内部结构（方法、属性、构造器等）使用到类的泛型的位置，都指定为实例化的泛型类型
 *      3.4 注意点 ：  泛型的类型必须是一个类，不能时基本数据类型。需要用到基本数据类型的位置，需要使用包装类
 *      3.5 如果实例化时，没有指明泛型类型，默认类型为Object类型
 *  4、自定义泛型结构： ①泛型类、接口泛型； ②泛型方法
 *      4.1
 */
public class GenericDemo {

    @Test
    public void test1() {
        ArrayList list = new ArrayList<>();
        list.add(123.0);
        list.add(546.0);
        list.add(345.0);
        list.add(657.0);
        //线程不安全
        list.add("Tom");
        for (Object obj : list ) {
            //强转时，可能出现ClassCastException
            int  stuScore  =(int)obj ;
            System.out.println(stuScore);
        }
    }

    //集合中使用泛型的情况，以ArrayList为例
    @Test
    public void test2() {
        //编译时就会进行数据检查，保证数据安全
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(345);
        list.add(367);
        list.add(654);
        for(Integer integer : list) {
            int stuScore = integer;
            System.out.println(stuScore);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //以HashMap为例
    @Test
    public void test3() {
        Map<String , Integer> map = new HashMap<String , Integer>();
        map.put("Harold" , 1) ;
        map.put("Jhon" , 2) ;
        map.put("Reesr" , 3) ;
        map.put("Groves" , 3) ;

        //泛型的嵌套
        Set<Map.Entry<String , Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String , Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String , Integer > entry1 = iterator.next();
            Integer value = entry1.getValue();
            String key = entry1.getKey();
            System.out.println("value : "  + value);
            System.out.println("key   : "  + key);
        }
    }
}
