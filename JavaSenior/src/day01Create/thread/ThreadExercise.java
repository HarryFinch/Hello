package day01Create.thread;

/*
    两个线程，一个输出100以内的偶数，另一输出奇数
 */
public class ThreadExercise {
    public static void main(String[] args) {
        Even even = new Even();
        Odd odd = new Odd();

        even.start();
//        odd.start();

        //创建Thread类的匿名子类的方式
        new Thread() {
            @Override
            public void run() {
                super.run();
                //爱干啥就干啥
            }
        }.start();
    }
}

class Even extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

class Odd extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1)
                System.out.println(Thread.currentThread().getName() + i);
        }
    }
}