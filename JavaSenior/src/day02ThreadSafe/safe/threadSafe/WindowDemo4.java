package day02ThreadSafe.safe.threadSafe;
/*
 * 同步方法解决继承Thread类的线程同步问题
 *
 */

class Window4 extends Thread {

    private static int tickit = 100;

    //此时是不安全的，因为创建了三个Widow对象，安全锁有三个
 /*   public synchronized void  show () {
        if (tickit > 0) {
            System.out.println(getName() + ": 买票，票号为" + tickit);
            tickit--;
        }
    }*/

    /*
        同步监视器  ：Window.class
    */
    public static synchronized void show() {
        if (tickit > 0) {
            System.out.println(Thread.currentThread().getName() + ": 买票，票号为" + tickit);
            tickit--;
        }
    }

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
}

public class WindowDemo4 {

    public static void main(String[] args) {

        Window4 window1 = new Window4();
        Window4 window2 = new Window4();
        Window4 window3 = new Window4();

        window1.setName("Window1");
        window2.setName("Window2");
        window3.setName("Window3");

        window1.start();
        window2.start();
        window3.start();
    }
}
