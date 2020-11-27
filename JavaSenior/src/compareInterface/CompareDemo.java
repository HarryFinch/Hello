package compareInterface;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @Author: Harold
 * @Date: 2020/3/22 16:01
 * @Description: Comparable接口和
 *  1、说明：Java对象只能进行 == 或 != 比较操作，需要对多个对象进行比较，需要实现Comparable或Comparator接口
 *
 *  2、Comparable接口
 *      2.1 String、包装类等实现了Comparable接口，重写了compareTo（Object obj）方法，可以比较对象的大小
 *      2.2 重写compareTo（Object obj）方法的规则（从小到大排列）
 *          2.2.1 当前对象大于形参对象，返回正整数（因为做了减法运算）
 *          2.2.2 当前对象小于形参对象，返回负整数（因为做了减法运算）
 *          2.2.3 当前对象等于形参对象，返回零（因为做了减法运算）
 *      2.3 对于自定类，如果需要排序，需要实现Comparable接口，指明如何排序
 *  3、Comparator接口
 *      3.1 当前类没有实现Comparable接口，或者实现了，但是排序方式不理想
 */
public class CompareDemo {

    //Comparable接口使用举例
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "ZZ", "CC", "FF", "EE", "BB"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //ComGoods；类实现了Comparable接口
    @Test
    public void test2() {
        ComGoods[] cg = new ComGoods[4];
        cg[0] = new ComGoods("Levon", 100);
        cg[1] = new ComGoods("Dell", 65);
        cg[2] = new ComGoods("Xiaomi", 10);
        cg[3] = new ComGoods("Huawei", 60);
    }


    //Comparator接口
    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "ZZ", "CC", "FF", "EE", "BB"};
        Arrays.sort(arr, new Comparator() {
            //字符串按照从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                return 0;
            }
        });
    }
}
