package day05JavaSet.collection;

import day05JavaSet.list.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/23 9:32
 * @Description: Collection 中的方法
 *  1、Collection接口实现类的对象中添加数据obj时，要求obj所在类重写equals()方法
 */
public class CollectionDemo1 {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);
//        Person person = new Person("Jhon" , 22));
//        coll.add(person);
        boolean b = coll.contains(123);
        System.out.println(b);
        System.out.println(coll.contains(new String("Harold")));
        //查找的次数和添加的顺序有关
        System.out.println(coll.contains(new Person("Jhon", 22)));
//        System.out.println(coll.contains(person));
        System.out.println("------------------------------------------");
        //判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 3453);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        //remove(Object o),删除指定元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);
        System.out.println(coll);
        System.out.println(coll.remove(1234));
        System.out.println(coll);

        //removeAll(Collection coll)删除当前对象的差集
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println("Before coll1 : " + coll1);
        System.out.println("Before coll : " + coll);
//        System.out.println(coll.removeAll(coll1));
        coll.removeAll(coll1);
        System.out.println("coll  : " + coll);
        System.out.println("After coll1 : " + coll1);
    }

    //retainsAll方法
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(111);
        coll.add(333);
        System.out.println(coll);
        Collection coll1 = Arrays.asList(123, 456, 789);
        //获取当前对象与目标对象的交集coll.retainAll(Collection coll)
        // 并将并集结果赋值给当前集合
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll);
        System.out.println(coll1);
    }

    //equals方法
    @Test
    public void test4() {
        //equals(Object obj) :
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(111);
        coll.add(333);

        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(111);
        coll1.add(333);

        Collection coll2 = new ArrayList();
        coll2.add(456);
        coll2.add(123);
        coll2.add(111);
        coll2.add(333);

        Collection coll3 = Arrays.asList(123, 456);
        //true，两个集合完全一致
        System.out.println(coll.equals(coll1));
        //false ，压根不是一个
        System.out.println(coll.equals(coll3));
        //false，顺序原因
        System.out.println(coll.equals(coll3));
    }

    //hashCode方法
    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);

        //hashCode()方法,返回当前对象的hash值
        System.out.println(coll.hashCode());
    }

    //集合与数组的相互转换
    @Test
    public void test6() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);

        //数组 --> 集合
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //集合 -- >  数组 : 调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "bb"});
        System.out.println(list);

        //元素是一个一维数组，输出首地址
        List<int[]> arr = Arrays.asList(new int[]{123, 456});
        System.out.println(arr);

        //按照单个数字处理的两种方式
        List arr1 = Arrays.asList(123, 456);
        System.out.println(arr1);
        List arr2 = Arrays.asList(new Integer[] {123, 456});
    }


}
