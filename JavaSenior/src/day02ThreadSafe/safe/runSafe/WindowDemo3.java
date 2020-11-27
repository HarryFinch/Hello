package day02ThreadSafe.safe.runSafe;

/*
 *使用同步方法解决实现Runnale接口的线程安全问题
 */
public class WindowDemo3 {
    public static void main(String[] args) {
        WindowRun winRun = new WindowRun();

        Thread thread1 = new Thread(winRun);
        thread1.start();

        Thread thread2 = new Thread(winRun);
        thread2.start();

        Thread thread3 = new Thread(winRun);
        thread3.start();
    }
}


class WindowRun implements Runnable {

    private int tickit = 100;

    /*
        使用同步方法完成多线程操作
        同步方法中的同步监视器为this
     */
    private synchronized  void show () {
        if (tickit > 0) {
            System.out.println(Thread.currentThread().getName() + "Tickit" + tickit);
            tickit--;
        }
    }

    @Override
    public synchronized void run() {
        while (true) {
            show();
        }
    }
}