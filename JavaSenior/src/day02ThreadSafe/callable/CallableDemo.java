package day02ThreadSafe.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * @Author: Harold
 * @Date: 2020/3/19 18:33
 * @Description:创建多线程的方式------Callable接口
 *  步骤：
 *      1、创建一个实现Callable的实现类
 *      2、实现call方法，将此线程需要执行的操作声明在call方法中
 *      3、创建Callable接口实现类的对象
 *      4、将此Callable接口实现类的对象作为参数传递到 FutureTask 构造器中，创建FutureTask类对象
 *      5、将FutureTask对象作为参数传递到 Thread 构造其中，创建Thread类对象，并start方法调用
 *      6、获取Callable中的call方法的返回值
 *------------------------------------------------------------------------------------
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大
 *      1、call()方法是可以有返回值的
 *      2、call（）方法是可以抛出异常，被外面的操作捕获，获取异常的信息
 *      3、Callable接口是支持泛型的
 *
 */
public class CallableDemo {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            //get方法的返回值即为FutureTask构造器参数Callable实现类重写的call方法的返回值
            Object sum = futureTask.get();
            System.out.println("sum = "+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0 ;
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0 ) {
                System.out.println(i);
                sum += i ;
            }
        }
        return sum;
    }
}