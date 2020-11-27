package day16;

public class InnerClassTest {

    /*
    在局部内部类的方法中，调用局部内部类所声明的方法中的局部变量，要求此局部变量为final
    就是，方法中声明的局部内部类，类中的方法想调用外部方法所声明的局部变量，该变量应该是final的

    JDK7之前的版本，要求此局部变量显示的声明为final
    JDK8以后，可以省略final的声明
     */
    public void method() {
        int num = 10 ;
        class AA {
            public void show() {
                //num被final修饰了，不能更改
                //num = 20;
                System.out.println(num);
            }
        }
    }
}
