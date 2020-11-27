package day05JavaSet.set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * @Author: Harold
 * @Date: 2020/3/23 17:52
 * @Description: TreeSet
 *  1、向TreeSet中添加是数据，必须是同一个类提供的，因为要根据属性进行排序
 *  2、两种排序方式 自然排序  定制排序
 *  3、自然排序比较两个对象是否相同的标准，comparTo()返回0，不再是equals()
 *  4、定制排序比较两个对象是否相同的标准，compar()返回0，不再是equals()
 */
public class TreeSetDemo {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
//        set.add(123);
//        set.add(465);
//        set.add(79);
//        set.add(-123);
        set.add(new User("Tom" , 22) );
        set.add(new User("Jhon" , 20) );
        set.add(new User("Peter" , 17) );
        set.add(new User("Harold" , 23) );

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        set.add("465");
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return Integer.compare(user1.getAge() , user2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet treeSet = new TreeSet();
    }
}
