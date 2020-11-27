package day01Create.thread;

/*
    多线程的创建，方式一继承于Thread了类
    1、创建一个继承与Thread类的子类
    2、重写Thread类的run() -- > 将想要的操作声明在run()方法中
    3、创建Thread类的子类的对象
    4、通过此对象调用start()
        作用：1.启动当前线程  2.调用当前线程的run()方法
    5、一个线程已被唤醒，就不可在去执行别的任务，否则会报非法线程异常
    例：遍历100以内的所有偶数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //这个循环是主线程中执行的
        for (int i = 0; i < 100; i++) {
            System.out.println( Thread.currentThread().getName()+ i + "------");

        }
    }
}


//创建一个继承与Thread类的子类
class MyThread extends Thread {
    //重写Thread类的run() -

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <= 100; i++) {
            if ((i & 1) == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
