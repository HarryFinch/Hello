package day06Generic;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/25 16:57
 * @Description:
 *  1、继承时指明具体类型，子类构造对象不用指明泛型，因为继承了父类
 */
public class SubOrder extends Order<Integer> {
    //泛型方法，无需写在泛型类中
    public static  <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> es = new ArrayList<>();
        for (E e : arr) {
            es.add(e);
        }
        return es;
    }
}
