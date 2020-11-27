package day01Create.thread;

/*
 *  创建多线程的方式二 ： 实现Runnable接口
 *      1、创建一个实现Runnable接口的类
 *      2、实现类去实现Runnable接口中的抽象方法，run方法
 *      3、创建实现类对象
 *      4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *      5、通过Thread类的对象调用start方法
 * ------------------------------------------------------------------------
 *  比较创建线程的两种方式：
 *      1、开发中优先选择Runnable接口
 *          原因： 实现方式没有类单继承的局限性
 *                  实现方式更适合处理多个线程共享数据的情况
 *      2、两者之间的练习：Thread类就是实现Runnable接口，Thread类中的run方法就是实现了Runnable中的run方法
 *      3、相同点；两种方法都需要重写run方法，将线程要执行的逻辑写在run方法中
 */
public class RunnableDemo {
    public static void main(String[] args) {
        //创建实现类对象
        RunDemo runDemo = new RunDemo();
        //将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread1 = new Thread(runDemo);
        //通过Thread类的对象调用start方法，调用了
        thread1.start();

        Thread thread2 = new Thread(runDemo) ;
        thread2.start();

    }
}

class RunDemo implements Runnable{

    //实现run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %  2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

