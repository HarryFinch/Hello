package day13;

/*
    a intanceof A  :判断对象a是否为A类的对象
    使用情景：为了避免在向下转型时出现异常，在向下转型前先进行instanceof的判断，返回true进行向下转型，返回false停止转型

    a intanceof A 返回true， a intanceof B返回true，那么类B是类A的父类
 */
public class IntanceofKW {

    public static void main(String[] args) {
        IntanceofKW intanceofKW = new IntanceofKW();
        if (intanceofKW instanceof IntanceofKW) {
            System.out.println("Yes!");
        } else {
            System.out.println("No");
        }
    }

}
