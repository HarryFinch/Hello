package day02ThreadSafe.threadCommunicate;

/*
 * @Author: Harold
 * @Date: 2020/3/19 14:22
 * @Description:
 *  使用两个线程打印 1-100。线程1, 线程2 交替打印
 *  线程通信涉及到的三个方法
 *      1、wait() ： 使当前方法进入阻塞状态，并释放同步监视器
 *      2、notify() ： 唤醒被wait的线程，如果是多个线程，唤醒优先级最高的
 *      3、notifyAll() ： 唤醒所有被wait的线程
 *      说明 ：
 *          1、上述三个方法中，必须使用在同步代码块或同步方法中
 *          2、上述三个方法的调用者必须是同步代码块或者同步方法中的同步监视器，否则会出现IllegamonitorException异常
 *          3、上述方法定义在Object类中
 *
 *   面试题 ：
 *      1、sleep方法与wait方法的异同
 *          相同点：两个方法都可以使当前线程进入阻塞状态
 *          不同点：
 *              -- 两个方法声明的位置不同，sleep声明在Thread类中，wait方法声明在Object类中
 *              -- 调用的范围不同 ： sleep的调用没有要求，wait一定要在同步代码块或者同步方法中调
 *              -- 如果两个方法都是在同步代码块或同步方法中，sleep不会释放锁，而wait方法会释放锁
 */
public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("Thread 1 : ");
        thread2.setName("Thread 2 : ");

        thread1.start();
        thread2.start();
    }
}


class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number  < 100 ) {
                    System.out.println(Thread.currentThread().getName() + " : Number = " + number);
                    number++;
                    try {
                        //调用wait方法的线程进入阻塞状态
                        //wait方法会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}