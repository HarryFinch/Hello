package day05JavaSet.Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/25 9:31
 * @Description: Collections 操作Collection、Map的工具类
 *  1、Collections常用的方法
 *
 * 排序操作：（均为static方法）
 *      reverse(List)：反转 List 中元素的顺序
 *      shuffle(List)：对 List 集合元素进行随机排序
 *      sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 *      sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 *      swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交
 *
 * 查找、替换
 *      Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 *      Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回 给定集合中的最大元素
 *      Object min(Collection) 根据 Comparator 指定的顺序，返回 给定集合中的最小元素
 *      Object min(Collection，Comparator)根据 Comparator 指定的顺序，返回 给定集合中的最小元素
 *      int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 *      void copy(List dest,List src)：将src中的内容复制到dest中
 *      boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧
 *
 *
 *  面试题： Collection和Collections的区别
 *      1、Collection是一个接口，Collections是一个工具类
 *      2、Collections是操作Collection接口的工具类
 *
 */
public class CollectionsDemo {

    @Test
    public void test2() {
        List list = new ArrayList() ;
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Frequency : " + Collections.frequency(list, 1));
        //错误写法
//        List list1 = new ArrayList();
//        Collections.copy(list1,list);
//        System.out.println("Copy : " + list1);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest,list);
        System.out.println(dest);

        //返回的list1即为线程安全的
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);

    }


    //排序操作
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original  : " + list);
        Collections.reverse(list);//反转
        System.out.println("Reverse : " + list);
        Collections.shuffle(list);
        System.out.println("Random Order : " + list);

        list.add(-5);
        list.add(-2);
        list.add(0);
        Collections.sort(list);
        System.out.println("Ascending Sort  : " + list);

//        Collections.sort(list);
//        System.out.println("Comparator Sort  : " + list);
        Collections.swap(list,2,3);
        System.out.println(list);

    }
}
