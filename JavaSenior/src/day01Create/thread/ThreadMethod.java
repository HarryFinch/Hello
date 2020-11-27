package day01Create.thread;

/*
    测试Thread常用的方法
    1、start()方法  ①启动当前线程  ②调用当前线程的run方法
    2、run()方法：通常需要重写Thread雷总的此方法，讲创建的线程需要执行的操作声明在此方法中
    3、currentThread():静态方法，返回执行当前代码的线程
    4、getName():获取当前线程的名字
    5、setName():设置当前线程名称
    6、yield():释放当前CPU的执行权（静态方法）
    7、join():在线程A中调用线程B的join方法后，线程A进入阻塞状态，
                直到线程B完全执行完后，线程A才能继续执行
    8、sleep(long millis)：使线程进入睡眠状态
    9、isAlive()判断线程是否存活
    ---------------------------------------------------------------------------------------------------
    线程优先级
     MAX_PRIORITY 10
     MAX_PRIORITY  1
     MAX_PRIORITY 5
     1、如何设置当前线程的优先级
        getPriority()获取当前线程的优先级
        setPriority()设置的当前线程的优先级

 */
public class ThreadMethod {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("Hello");
//        helloThread.setName("Hello");
        helloThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +Thread.currentThread().getPriority() +  " : " + i);
            if (i == 20 ) {
                try {
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                 }
            }
        }
    }
}


class HelloThread extends Thread {
    public HelloThread(String name) {
        super(name);

    }

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +  Thread.currentThread().getPriority() +" : " + i);
        }
    }
}