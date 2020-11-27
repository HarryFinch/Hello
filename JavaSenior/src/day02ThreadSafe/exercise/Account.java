package day02ThreadSafe.exercise;

/*
 * @Author: Harold
 * @Date: 2020/3/19 13:52
 * @Description:
 * 银行有一个账户。 有两个储户分别向同一个账户存3000元，
 * 每次存1000，存3次。每次存完打 印账户余额。
 *  分析 ：
 *  是否是多线程问题        两个储户 ---  多线程
 *  是否有线程安全问题      共享数据 ---  线程安全问题，一个共同账户
 *  如何解决线程安全问题    同步机制
 */
public class Account {
    public static void main(String[] args) {
        AccountDemo account = new AccountDemo(0.0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("customer1");
        customer2.setName("customer2");

        customer1.start();
        customer2.start();
    }
}

class AccountDemo {
    private double balance;

    public AccountDemo(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println(Thread.currentThread().getName() + " + Balance = " + balance);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private AccountDemo account;

    public Customer(AccountDemo account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}