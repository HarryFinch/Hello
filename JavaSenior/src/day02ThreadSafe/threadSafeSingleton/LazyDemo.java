package day02ThreadSafe.threadSafeSingleton;

/*
 * @Author: Harold
 * @Date: 2020/3/19 11:52
 * @Description:
 *  使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 */
//单例模式懒汉式的线程安全问题
public class LazyDemo {

}


class Bank {

    private static Bank instance = null ;

    private Bank() {}

    //线程安全，效率稍差
    private static synchronized Bank getInstance() {
 /*       synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/
        //方式二
        if (instance == null) {
            synchronized (Bank.class) {
//                if (instance == null ) {
                    instance = new Bank();
//                }
            }
        }
        return instance;
    }
}