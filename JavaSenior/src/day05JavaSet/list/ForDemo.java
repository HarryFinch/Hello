package day05JavaSet.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
 * @Author: Harold
 * @Date: 2020/3/23 11:17
 * @Description: 增强for循环
 */
public class ForDemo {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jhon", 22));
        coll.add(new String("Harold"));
        coll.add(false);

        //for（集合元素类型  局部变量  : 集合对象）
        //内部调用的仍是迭代器
        for (Object arrayList : coll) {
            System.out.println(arrayList);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "AA", "AA", "AA"};
        //改变原有数组
        /*for (int i = 0; i < string.length ; i++) {
            string[i] = "BB" ;
        }*/
        //不改变原有数组
        for (String s : arr) {
            s = "BB";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}