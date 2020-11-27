package day02ThreadSafe.threadLock;

import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author: Harold
 * @Date: 2020/3/19 13:29
 * @Description:
 *  解决线程安全问题的方式三 ： Lock
 *
 *  面试题 synchronized 与Lock的异同
 *      1、相同点
 *      2、不同点：
 *          synchronized机制在执行完相应的同步代码后，自动释放同步监视器
 *          Lock需要手动启动同步，同时结束同步也需要手动实现
 *  面试题： 如何解决线程安全问题
 *      1、lock方式
 *      2、synchronized
 *          代码块
 *          同步方法
 *
 * 优先使用顺序 ：
 *  Lock -- 代码块 --- 同步方法
 *
 */
public class LockDemo {
    public static void main(String[] args) {
        Window window = new Window() ;
        Thread th1 = new Thread();
        Thread th2 = new Thread();
        Thread th3 = new Thread();

        th1.setName("Window1");
        th2.setName("Window2");
        th3.setName("Window3");
    }
}

class Window implements Runnable {

    private int ticket = 100;
    //1.实例化 ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            try {
                //2.调用lock方法，锁定资源
                lock.lock();
                if (ticket > 0 ) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : 售票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                //3.调用解锁方法
                lock.unlock();
            }
        }
    }
}