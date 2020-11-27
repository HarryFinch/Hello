package day06Generic;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Harold
 * @Date: 2020/3/25 16:47
 * @Description:自定义泛型类
 */
public class Order<T> {
    String name;
    int orderId;
    T orderT;//使用类的泛型定义类的结构

    public Order() {
    }

    public Order(String name, int orderId, T orderT) {
        this.name = name;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //泛型方法
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> es = new ArrayList<>();
        for (E e : arr ) {
            es.add(e) ;
        }
        return es ;
    }
}
