package day05JavaSet.map;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*
 * @Author: Harold
 * @Date: 2020/3/25 8:14
 * @Description: TreeMap
 *  1、想TreeMap中添加key-value，要求key必须是有同一个类创建的对象
 *      因为是按照key排序 ： 自然排序和定制排序
 */
public class TreeMapDemo {

    @Test
    public void test1() {
        TreeMap map = new TreeMap() ;
        map.put(new User("BB" ,12) ,1);
        map.put(new User("AA" ,13) ,2);
        map.put(new User("CC" ,14) ,3);
        map.put(new User("DD" ,15) ,4);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    //定制排序
    @Test
    public void test2() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return Integer.compare(user1.getAge() , user2.getAge());
                }
                throw new RuntimeException("Wrong Object ");
            }
        });
        map.put(new User("BB" ,12) ,1);
        map.put(new User("AA" ,13) ,2);
        map.put(new User("CC" ,14) ,3);
        map.put(new User("DD" ,15) ,4);
    }
}
