package day01Create.thread;

/*
 * 例子 ： 创建三个窗口买票，总票数为100张
 *
 */

class Window extends Thread{

    private static int ticket = 100 ;

    @Override
    public void run() {
        while(true) {
            if(ticket > 0 ) {
                System.out.println(getName() + ": 买票，票号为" + ticket);
                ticket -- ;
            }else {
                break;
            }
        }
    }
}

public class WindowDemo {

    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();
        window1.setName("Window1");
        window2.setName("Window2");
        window3.setName("Window3");

        window1.start();
        window2.start();
        window3.start();

    }

}
