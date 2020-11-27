package day09;

/*
 * 一、理解“万事万物皆对象”
 * 1.在Java语言范畴中，都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构
 *
 * 2.涉及到Java语言于前端HTML、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象
 * 
 * 二内存解析的说明
 * 1.引用类型的变量，只可能存储两类值，null 或者地址值
 *
 * 三、匿名对象的使用
 * 1.理解：创建的对象没有显式的赋给一个变量名，即是匿名对象
 * 2.特征：匿名对象只能调用一次
 *
 */
public class InstanceTest {
    public static void main(String[] args) {
        Phone phone = new Phone() ;
        phone.sendEmail();
        phone.playGame();

        //匿名对象,两个对象为不同对象
        new Phone().playGame();
        new Phone() .sendEmail();

        //匿名对象示例
        PhoneMall phoneMall = new PhoneMall() ;
        phoneMall.show(new Phone());
    }

}

class Phone {
    double price;

    public void sendEmail() {
        System.out.println("Send Email");
    }

    public void playGame() {
        System.out.println("Play Game");
    }

}

class PhoneMall {
    public void show (Phone phone){
        phone.playGame();
        phone.sendEmail();
    }
}