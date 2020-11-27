package day06Generic;

import day05JavaSet.list.Person;
import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/26 9:39
 * @Description:
 *  6、泛型在继承方面的体现
 *  7、通配符的使用
 */
public class GenericDemo2 {
    //泛型在继承方面的体现
    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        //list1 和 list2 不具备子父类关系
        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2 ;
    }

    @Test
    public void test2() {
        AbstractList<String> list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;

    }

    //通配符的使用   ?
    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;

        //不能想Lis<?>t内部添加数据
        //除了添加null以外
        list.add(null);

        Object o = list.get(0);
        System.out.println(o);

    }


    //有限制条件的通配符的使用   ?
    //? extends A    G<? extends A> 可以作为G<A> 和 G<B>的父类，其中B是A的子类，最大是A
    //?  super A     G<? extends A> 可以作为G<A> 和 G<B>的父类，其中B是A的父类，最小是A
    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Student> list3 = null ;
        List<Person> list4 = null ;
        List<Object> list5 = null ;

        list1 = list3;
        list1 = list4;
//        list1 = list5;
//        list2 = list3 ;
        list2 = list4;
        list2 = list5;
    }

}
