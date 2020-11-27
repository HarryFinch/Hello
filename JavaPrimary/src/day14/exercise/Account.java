package day14.exercise;
/*
    编写一个类实现银行账户的概念，包含的属性有“帐号”、“密 码”、“存款余额”、“利率”、“最小余额”，
    定义封装这些 属性的方法。账号要自动生成。 编写主类，使用银行账户类，输入、输出3个储户的上述信息。
    考虑：哪些属性可以设计成static属性
 */
public class Account {
    private int account;
    private String password;
    private double balance;

    private static double rate = 0.3;
    private static double minBalance;
    private static int init = 1001 ;


    public Account() {
        this.account = init++;
    }

    public Account(String password ,double balance) {
        this() ;
        this.password = password ;
        this.balance = balance ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        Account.rate = rate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        Account.minBalance = minBalance;
    }
}
