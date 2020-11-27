package day05JavaSet.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @Author: Harold
 * @Date: 2020/3/24 10:47
 * @Description: Map
 * 一、Map的概述
 *  1、Map ： 双列数据，存储key-value对数据
 *      |--- HashMap ： 作为Map的主要实现类，线程不安全，效率高，可以存储null的key-value
 *          | --- LinkedHashMap ：保证在遍历Map元素时，可以按照添加的顺序实现遍历
 *                                原因：在原有的HashMap底层的基础结构上，添加了前后指针
 *                                      对于频繁的遍历操作，此类执行效率高于HashMap
 *      |--- TreeMap ： 保证按照添加的key-value对进行排序，实现排序遍历 。
 *                      此时考虑key的自然排序或定制排序，底层使用红黑树
 *      |--- Hashtable ： 作为Map的古老实现类 ，线程安全，效率低，不能存储null的key-value
 *          |---Properties ： 常用来处理配置文件。key-value都是String类型
 *
 *  2、HahMap的底层 ： 数组 + 链表 （JDK1.7以前）
 *                    数组 + 链表 + 红黑树 （JDK1.8）
 *  3、面试题 ：
 *      3.1 HashMap的底层实现原理
 *          3.1.1 以JDK1.7为例说明
 *              -- HashMap map = new HashMap();
 *              -- 实例化以后，底层创建了长度是16的一维数组 Entry[] table
 *              -- 可能已经执行过多次put....
 *              -- map.put(key1,value1) :
 *                  --- 首先，计算key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算以后，得到Entry数组中存放的位置
 *                  --- 如果此位置数据为空，此时key1-value1添加成功    ---> 情况1
 *                  --- 如果此位之上数据不为空，意味着这个位置上可能有多个数据，比较key1和已经存在的数据的hash值
 *                  --- 如果与已存在的hash值都不相同，此时key1-value添加成功    ---> 情况2
 *                          如果与已存在数据的hash值相同，则调用key1所在类的equals方法进行比较，
 *                              若返回值为false，则key1-value1添加成功，  ---> 情况3
 *                              若返回值为true，则使用value1替换已存在的相同value
 *                  --- 补充 ： 关于情况2 和 情况3  ： 此时key1-value1和原来的数据以链表的方式存储
 *              --- 默认的扩容方式 ： 扩容为原来容量是2倍，并将原有的数据复制过来，当存储数据达到临界值并且存储的索引位不为空，开始扩容
 *          3.1.2 JDK8中相较于JDK中底层实现的不同
 *              --- new HashMap() ： 底层没有创建一个长度为16的 Node 数组，
 *              --- 首次调用put方法时，底层调用一个长度为16的数组
 *              --- JDK7中底层结构只有数组 + 链表 ， JDK8 中底层结构 ： 数组 + 链表 + 红黑树
 *              --- 当数组的某一个索引位置上的元素以链表形式存在的数据个数大于8，并且当前数组的长度大于64时，此时此索引位置上的所有改为使用红黑树存储
 *      3.2 HashMap和Hashtable的异同
 *      3.3 CurrentHashMap 与 Hashtable 的异同
 *
 * 二、Map结构的理解
 *  1、Map中key ： 无序、不可重复的，使用Set存储所有的key ---> key所在的类要重写equals方法和hashCode方法
 *     Map中的value ： 无序的，可重复的，使用Collection存储的所有的value  ---> value所在类要重写equals方法
 *  2、一个键值对 ： key-value构成一个Entry对象
 *  3、Map中的entry ： 无序的、不可重复的，使用Set存储所有的entry
 *
 *
 * 三、HashMap中的重要常量
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树
 *      UNTREEIFY_THRESHOLD：Bucket中红黑树存储的Node小于该默认值，转化为链表
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。（
 *          当桶中Node的 数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，
 *          此时应执行 resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4 倍。）
 *      table：存储元素的数组，总是2的n次幂
 *      entrySet：存储具体元素的集
 *      size：HashMap中存储的键值对的数量
 *      modCount：HashMap扩容和结构改变的次数。
 *      threshold：扩容的临界值 = 容量*填充因子
 *      loadFactor：填充因子
 *
 * 四、LinkedHashMap 的底层实现原理
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *      Entry<K,V> before, after;//能够记录元素添加的前后顺序
 *      Entry(int hash, K key, V value, Node<K,V> next) {
 *          super(hash, key, value, next);
 *      }
 *  }
 *
 *
 */
public class MapDemo {

    @Test
    public void test1() {
        Map map1 = new HashMap();
        Map map2 = new Hashtable();
        map1.put(null, null);
        map2.put(null, null);
    }

    @Test
    public void test2() {
        Map map = new LinkedHashMap();
        map.put(132, "aa");
        map.put(123, "bb");
        map.put(567, "dd");
        map.put(678, "ff");
        System.out.println(map);
    }
}
