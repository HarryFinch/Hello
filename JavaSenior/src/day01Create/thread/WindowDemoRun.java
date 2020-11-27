package day01Create.thread;

public class WindowDemoRun {
    public static void main(String[] args) {
        WindowRun winRun = new WindowRun() ;

        Thread thread1 = new Thread(winRun) ;
        thread1.start();
    }

}


class WindowRun implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "Ticket" + ticket);
                ticket--;
            } else {
                break ;
            }
        }
    }
}