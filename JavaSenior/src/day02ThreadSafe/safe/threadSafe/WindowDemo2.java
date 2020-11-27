package day02ThreadSafe.safe.threadSafe;


/*
 * 例子 ： 创建三个窗口买票，总票数为100张
 *
 * 使用同步代码块的方式解决线程安全问题
 *
 * 继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类.class作为安全锁
 *
 *
 */

class Window2 extends Thread{

    private static int tickit = 100 ;
    private static  Object object = new Object();


    //继承Thread类的方式，会有多个对象调用run方法，需要对象锁是静态的
    //不能使用this作为安全锁，可以使用Window.class作为安全锁，window.class只加载一次
    @Override
    public void run() {
        synchronized (Window2.class){
            while (true) {
                if (tickit > 0) {
                    System.out.println(getName() + ": 买票，票号为" + tickit);
                    tickit--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowDemo2 {

    public static void main(String[] args) {

        Window2 window1 = new Window2();
        Window2 window2 = new Window2();
        Window2 window3 = new Window2();

        window1.setName("Window1");
        window2.setName("Window2");
        window3.setName("Window3");

        window1.start();
        window2.start();
        window3.start();

    }

}
