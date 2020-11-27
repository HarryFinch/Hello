package day13.exercise2;

import java.util.Objects;

/*
    编写Order类，有int型的orderId，String型的orderName
    相应的getter和setter方法
    重写父类equals方法：public boolean equals（Object obj）
    判断测试类中两个对象是否相等
 */
public class Order {
    int orderId;
    String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Order) {
            Order order1 = (Order) object;
            return this.orderId == order1.orderId && this.orderName.equals(order1.orderName);
        }
        return false;
    }

/*    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }*/

    /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                Objects.equals(orderName, order.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderName);
    }*/

}
