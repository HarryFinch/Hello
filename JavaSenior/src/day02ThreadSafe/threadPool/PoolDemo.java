package day02ThreadSafe.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * @Author: Harold
 * @Date: 2020/3/19 18:11
 * @Description:创建线程的方式----使用线程池
 *  线程池好处 :
 *      1、提高响应速度
 *      2、降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *      3、便于线程管理
 *          corePoolSize : 核心池的大小
 *          maximumPoolSize ： 最大线程数
 *          keepAliveTime ： 线程没有任务时最多保持多长时间后就会停止
 *
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " -- "+ i);
            }
        }
    }
}class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " : "+i);
            }
        }
    }
}


public class PoolDemo {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池属性
//        System.out.println(service.getClass());
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
       //执行指定的线程操作，需要提供实现Runnable接口或这Callable接口的实现类对象
        service.execute(new NumberThread()); //适用于Runnable
        service.execute(new NumberThread1()); //适用于Runnable
//        service.submit() ;//适用于Callable
        //关闭连接池
        service.shutdown();
    }
}

