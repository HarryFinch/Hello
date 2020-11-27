package day10;

public class Order {

    private int orderPrivate;
    int orderDefault;
    public int orderPublic;

    private void methodPrivate() {
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

    void methodDefault() {
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

    public void methodPublic() {
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

    /*
        通过测试，更好地体现封装性
        私有属性和私有方法在 类外、包外 就不可见了
     */
    public static void main(String[] args) {
        Order order = new Order();
        order.orderDefault = 1;
        order.orderPublic = 2;
    }
}
