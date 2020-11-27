package day02ThreadSafe.safe;

/*
 * 例子 ： 创建三个窗口买票，总票数为100张
 *
 */

class Window extends Thread{

    private static int tickit = 100 ;

    @Override
    public void run() {
        while(true) {
            if(tickit > 0 ) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ": 买票，票号为" + tickit);
                tickit -- ;
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
