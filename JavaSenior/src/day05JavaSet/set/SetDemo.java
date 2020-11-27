package day05JavaSet.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * @Author: Harold
 * @Date: 2020/3/23 14:20
 * @Description:  HashSet  LinkedHashSet  TreeSet
 *  1、Set接口的框架结构
 *      1.1 HashSet ： 作为Set的主要实现类，线程不安全，可以存储null
 *      1.2 LinkedHashSet ：  HashSet的子类，遍历内部数据是，可以按照添加的顺序去遍历
 *      1.3 TreeSet ： 同一个类创建的对象才能放入TreeSet中，可以按照元素的指定属性排序
 *  补充：Set接口中没有重新定义方法，都来自与Collection
 *
 *  2、Set存储的数据无序、不可重复
 *      2.1 无序性 (不是随机性）
 *          -- 无序性指的是存储的内存单元是无序存进去的，
 *              并不是按照底层数组索引存储，而是根据数据hash值存储的
 *
 *      2.2 不可重复性 :
 *          -- 保证添加的元素按照equals()判断时，不能返回true，相同元素只能添加一次
 *      2.3 Set添加元素的过程，以HashSet为例
 *          -- 调用添加元素所在类的hashCode()方法，计算hash值
 *          --  根据hash值得出在hashSet底层存放的位置，即索引位置；
 *              --- 如果索引位为空，添加成功
 *              --- 若索引位有其他元素，则调用添加元素所在类的equals方法，
 *                      若返回false，添加成功，否则失败
 *          -- JDK1.7 添加的元素，指向原来的元素
 *             JDK1.8中，原来的元素，执行添加的元素
 *          -- HashSet底层是 数组 + 链表
 *  3、像Set中添加数据的类，一定要重写equals和hashCode方法，而且要尽量保证两个方法的一致性
 */
public class SetDemo {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
//        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");

        set.add(new User("harold" , 22));
        set.add(new User("harold" , 22));
        set.add(170);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
    * LinkedHashSet的使用
    *   添加数据的同时，还维护了两个引用，前一个和后一个数据的地址
    */

    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");

        set.add(new User("harold" , 22));
        set.add(new User("harold" , 22));
        set.add(170);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
