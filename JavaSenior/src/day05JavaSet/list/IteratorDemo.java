package day05JavaSet.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * @Author: Harold
 * @Date: 2020/3/23 10:44
 * @Description: 集合元素的遍历操作，Iterator接口
 *  1、每次调用iterator方法都会得到一个全新的迭代器，默认在集合的第一个元素之前
 */
public class IteratorDemo {
    //iterator():返回Iterator接口的实例，用于遍历集合元素

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //遍历方式一  : 开发中不常用
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        //遍历方式二 : 开发中常用方式
        //hasNext() 判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next()两个作 用 ①指针下移 ②将下移后返回集合位置上的元素
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Harold".equals(obj)) {
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
