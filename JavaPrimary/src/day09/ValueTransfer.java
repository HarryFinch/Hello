package day09;

/*
    关于变量的赋值
    1.如果变量是基本数据类型，此时赋值的是变量所保存的数据。
    2.如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址

    方法形参的传递机制
    1.如果变量是基本数据类型，此时传递的是变量所保存的数据
    2.如果变量是引用数据类型，此时传递的是变量所保存的数据的地址

 */
public class ValueTransfer {
    int orderId;
    int[] arr = new int[5];

    public void vlaueTransferTest() {

        int m = 10;
        int n = m;
        System.out.println("m = " + m + " n = " + n);

        n = 20;
        System.out.println("n = " + n);

        ValueTransfer order1 = new ValueTransfer();
        order1.orderId = 1001;

        ValueTransfer order2 = order1;
        System.out.println("Order1.orderId = " + order1.orderId);
        System.out.println("Order2.orderId = " + order2.orderId);

    }

    public void vlaueTransferTest1() {
        //交换两个变量值的操作
        int m = 10;
        int n = m;
        System.out.println("m = " + m + " n = " + n);

/*
        int temp = m ;
        m = n ;
        n = temp ;
        System.out.println("m = " + m + " n = " + n );
*/
        swap(m, n);
        swap1(arr, m, n);
    }

    //错误的传递方式
    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }

    //正确的传递方式
    public void swap1(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public void printParameter() {
        int[] arr1 = new int[]{123, 123};
        //输出地址，因为调用的println函数参数是Object类型
        System.out.println(arr1);
        char[] arr2 = new char[]{'a', 'b', 'c'};
        //输出字符串，因为调用的println函数参数是char[] 类型
        System.out.println(arr2);
    }


}