package day02ThreadSafe.threadDead;

import static java.lang.Thread.sleep;

/*
 * @Author: Harold
 * @Date: 2020/3/19 12:50
 * @Description:
 *  线程死锁问题
 *      1、死锁的理解 ： 占用对方所需要的资源不放弃，导致两个线程都无法执行，进入无限循环状态
 *                      出现死锁后不会报错、抛出异常，程序也不会终止
 *      2、使用同步线程时，避免出现死锁问题
 *
 */
public class ThreadDead {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("a");
                    s2.append("1");
                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }

}
