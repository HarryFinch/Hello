package day05JavaSet.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
 * @Author: Harold
 * @Date: 2020/3/22 21:02
 * @Description: 集合框架的概述
 *
 *  1、集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *      说明 ：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 *  2、数组在存储多个数据方面的优缺点：
 *      2.1 优点 ：
 *          -- 初始化以后长度确定
 *          -- 定义数组时，需要指定数组元素类型，数据类型确定，只能操作固定类型的数据
 *      2.2 缺点 ：
 *          -- 初始化后，长度确定不可修改
 *          -- 数组中提供的方法非常有限，对于增删改查非常不便，效率不高
 *          -- 获取数组中实际元素的个数，数组没有现成的属性或者方法可用
 *          -- 数组有序、可重复地存储数据，对于无序、不可重复的需求，数组不能满足
 *  3、Java集合可以分为Collection和Map两种体系
 *      3.1 Collection接口，单列数据，定义了存取一组对象的方法的集合
 *          -- List：元素有序、可重复的集合（动态数组）
 *              -- ArrayList、LinkedList、Vector
 *          -- Set ： 元素无序、不可重复的集合
 *              -- HashSet、LinkedHashSet、TreeSet
 *      3.2 Map接口：双列数据，保存具有映射关系"Key-value对"的集合
 *          -- HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *  4、Collection接口
 *      4.1 接口中方法的使用
 *
 */
public class CollectionDemo {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        //add(Object e)将元素添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll.size());

        //addAll(Collection),讲coll1集合中的元素添加到当前集合
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("DD");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //clear方法清空集合元素
        coll.clear();

        //isEmpty 判断集合中是否有元素
        System.out.println(coll.isEmpty());

        
    }


}


