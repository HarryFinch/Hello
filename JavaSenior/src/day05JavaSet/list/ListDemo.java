package day05JavaSet.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/23 11:42
 * @Description:
 *  ArrayList(List接口的主要实现类) ，底层使用Object[] elementData存储
 *  LinkedList 底层使用双向链表存储，链式结构，适用于频繁的插入、删除
 *  Vector(List接口的古老实现类) ， 底层使用Object[]存储
 *
 *  1、ArrayList源码分析
 *      JDK1.7
 *          1.1 底层创建了长度为10 的数组elementData[]
 *
 *      JDK1.8
 *          1.2 ArrayList list = new ArrayList(); 底层并未创建数组
 *          list.add(123)添加操作才创建数组
 *          扩容与1.7无异
 *  2、LinkedList源码分析
 *      2.1 LinkedList linkedList = new LinkedList()
 *      2.2 内部声明了Node类型的first和last属性，默认值为null
 *          list.add(123)  创建一个Node对象，将123封装到Node中
 *
 *  3、Vector的源码分析：JDK1.7 和JDK1.8中的构造对象时，底层都创建了长度为10 的数组
 *                      默认扩容长度为2倍
 *
 *  4、List接口中的常用方法
 *      void add(int index, Object ele):在index位置插入ele元素
 *      boolean addAll(int index, Collection eles):从index位置开始将eles中 的所有元素添加进来
 *      Object get(int index):获取指定index位置的元素
 *      int indexOf(Object obj):返回obj在集合中首次出现的位置
 *      int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 *      Object remove(int index):移除指定index位置的元素，并返回此元素
 *      Object set(int index, Object ele):设置指定index位置的元素为ele
 *      List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex 位置的子集合
 */
public class ListDemo {

    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new Person("Haorld", 22));
        //插入元素，把BB插到索引位置
        arrayList.add(1, "BB");
        System.out.println(arrayList);

        //两个集合拼接，把list集合中的所有元素加入到arrayList中
        List<Integer> list = Arrays.asList(1, 2, 3);
        arrayList.addAll(list);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }

    @Test
    public void test2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new Person("Haorld", 22));
        //首次出现的索引，如果不存在，返回-1
        System.out.println(arrayList.indexOf(79));
        //末次出现的索引,如果不存在，返回-1
        System.out.println(arrayList.lastIndexOf(456));
        //按照索引删除元素，并返回元素
        System.out.println(arrayList.remove(1));

        arrayList.set(2, "PP");
        //子集合，前闭后开
        System.out.println(arrayList.subList(1, 3));
    }

    //集合的遍历方式
    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        //方式一 迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //增强循环
        for (Object obj : list) {
            System.out.println(obj);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private static void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }
}
