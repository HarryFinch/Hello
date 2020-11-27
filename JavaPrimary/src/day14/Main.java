package day14;
/*
    main方法的使用说明
    1、main方法作为程序的入口
    2、main方法也是一个普通的静态方法
    3、main方法也可以作为普通的静态方法
    4、main方法也可作为我们于控制台交互的一种方式
 */
public class Main {
    public static void main(String[] args) {
        Test.main(new String[10]);
    }
}

class Test{
    public static void main(String[] args) {
        for (int i = 0; i< args.length; i++){
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}