package day02ThreadSafe.safe.runSafe;

/*
 * 例子 ： 创建三个窗口买票，总票数为100张
 * 问题 ： 出现重票或者错票的情况
 * 原因 ：某个线程操作车票尚未完成时，另一个线程同样进行了操作，导致了问题
 * 解决方案 ： 当一个线程操作执行时，其他线程不能参与进来，必须等线程该线程执行完毕，才可以由其他线程来操作
 *              即是正在执行的线程出现了阻塞问题，其他线程也不能进行操作
 *
 * 在Java中，通过同步机制解决安全问题
 *      方式一 ： 同步代码块
 *          synchronized(同步监视器) {
 *              需要同步的代码
 *          }
 *          说明 ：
 *              1.操作共享数据的代码，即为需要被同步的代码 --> 包含范围要准确
 *              2.共享数据 ： 多个线程共同操作的数据，比如买票系统中的票就是共享数据
 *              3.同步监视器 ： 俗称“锁”。任何一个类的对象都可充当锁
 *                  3.1 要求 ： 多个线程必须要共用同一把锁
 *              补充 ： 实现Runnable接口创建多线程的方式中，我们可以考虑this作为安全锁
 *                      继承Thread类创建多线程的方式中，慎用this作为安全锁
 *      方式二 ： 同步方法
 *          1. 如果操作共享数据的代码完整的声明在一个方法中，可以将此方法声明为同步方法
 *          2. 同步方法仍涉及到同步监视器，只是不需要显示声明
 *          3. 非静态的同步方法，同步监视器是 ： this
 *              静态同步方法，同监视器是当前类本身
 *
 *同步方法的优缺点
 *      同步的方式解决了线程的安全问题（好处）
 *      操作同步代码时只能有一个线程参与，其他线程等待，相当于一个单线程，效率低
 */
public class WindowDemoRun {
    public static void main(String[] args) {
        WindowRun1 winRun = new WindowRun1();

        Thread thread1 = new Thread(winRun);
        thread1.start();

        Thread thread2 = new Thread(winRun);
        thread2.start();

        Thread thread3 = new Thread(winRun);
        thread3.start();
    }
}


class WindowRun1 implements Runnable {

    private int tickit = 100;
    //充当安全锁
    Object object = new Object();

    //synchronized同步方式
    @Override
    public void run() {
        //实现了线程同步
        synchronized (this) {
            //this表示当前WindRun类的唯一对象
            while (true) {
                if (tickit > 0) {
                    System.out.println(Thread.currentThread().getName() + "Tickit" + tickit);
                    tickit--;
                } else {
                    break;
                }
            }
        }
    }
}