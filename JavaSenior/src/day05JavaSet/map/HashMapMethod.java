package day05JavaSet.map;

import org.junit.Test;

import java.util.*;

/*
 * @Author: Harold
 * @Date: 2020/3/24 15:05
 * @Description: Map接口中的方法
 *
 *  添加、删除、修改操作：
 *       Object put(Object key,Object value)：将a指定key-value添加到(或修改)当前mp对象中
 *       void putAll(Map m):将m中的所有key-value对存放到当前map中
 *       Object remove(Object key)：移除指定key的key-value对，并返回value
 *       void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *       Object get(Object key)：获取指定key对应的value
 *       boolean containsKey(Object key)：是否包含指定的key
 *       boolean containsValue(Object value)：是否包含指定的value
 *       int size()：返回map中key-value对的个数
 *       boolean isEmpty()：判断当前map是否为空
 *       boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *       Set keySet()：返回所有key构成的Set集合
 *       Collection values()：返回所有value构成的Collection集合
 *       Set entrySet()：返回所有key-value对构成的Set集
 */
public class HashMapMethod {
    //添加、删除、修改操作
    @Test
    public void test1() {
        Map map = new HashMap();
        map.put("AAA", 123);
        map.put("BBB", 111);
        map.put("VVV", 22);
        map.put("CCC", 34);
        map.put("ZZZ", 66);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("QQ", 123);
        map1.put("WW", 111);
        map.putAll(map1);
        System.out.println(map);

        Object value = map.remove(66);
        System.out.println(value);
        System.out.println(map);

        map.clear();
        System.out.println(map);
    }

    // 元素查询的操作
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AAA", 123);
        map.put("BBB", 111);
        map.put("VVV", 22);
        map.put("CCC", 34);
        map.put("ZZZ", 66);

        Map map1 = new HashMap() ;
        map1.put("AAA", 123);
        map1.put("BBB", 111);
        map1.put("VVV", 22);
        map1.put("CCC", 34);

        System.out.println(map.get("AAA"));
        System.out.println(map.containsKey("BBB"));
        System.out.println(map.containsValue(22));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.equals(map1));
    }

    //元视图操作的方法
    @Test
    public void test3() {
        Map map = new HashMap() ;
        map.put("AA" , 1);
        map.put("BB" , 2);
        map.put("CC" , 3);

        //遍历所有key集，keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        //遍历所有value集，values()
        Collection collection = map.values();

        for (Object obj : collection) {
            System.out.println(obj);
        }

        //遍历所有key-value集
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()) {
            Object obj = iterator.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "-------" + value);
        }
    }
}
