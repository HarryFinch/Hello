package day13;

public class Interview {

    public static void main(String[] args) {
        Base1 base1 = new Sub1() ;
        base1.add(1,2,3);//输出sub1，可变形参和数组是等价的

        Sub1 s = (Sub1)base1 ;
        s.add(1,2,3);//输出sub2
    }
}

class Base1 {
    public void add(int a, int... arr) {
        System.out.println("Base1");
    }
}

class Sub1 extends Base1 {

    public void add(int a, int[] arr) {
        System.out.println("Sub1");
    }

    public void add(int a, int b, int c) {
        System.out.println("Sub2");
    }
}