package day15.interfaceDemo;

public class InterfaceDemo1 {
    public static void main(String[] args) {

        Computer computer = new Computer();
        //创建了接口的非匿名子类的非匿名对象
        Flash flash = new Flash();
        computer.transferData(flash);

        //创建接口的非匿名子类的匿名对象
        computer.transferData(new Flash());
        computer.transferData(new Printer());
        //创建接口的匿名子类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("Phone Working");
            }

            @Override
            public void stop() {
                System.out.println("Phone stop ");
            }
        };
        computer.transferData(phone);


        //创建接口的匿名子类的匿名对象
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("Anonymous Working");
            }

            @Override
            public void stop() {
                System.out.println("Anonymous stop");
            }
        });

    }
}

class Computer{
    public void transferData(USB usb){
        usb.start();
        System.out.println("transfer");
        usb.stop();
    }
}

interface USB{

    //定义最大、最小的传输速度
    int MAX_SPEED = 3000;
    int MIN_SPEED = 30;

    void start();
    void stop();
}

class Flash implements USB{

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

class Printer implements USB{

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}