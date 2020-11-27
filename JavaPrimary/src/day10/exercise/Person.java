package day10.exercise;

/*
    1、创建程序，在其中定义两个类，Person和PersonTest类，定义如下
        用setAge()设置人的合法年龄，用getAge()返回人的年龄。
        再PersonTest类中实例化Person类的对象b，调用两个方法
 */
public class Person {

    private short age;

    public void setAge(short a) {
        if (a < 0 || a > 130) {
            System.out.println("Information is wrong");
        } else {
            age = a;
        }

    }

    public short getAge() {
        return age;
    }

    public static void main(String[] args) {
        short age = 80;
        Person p = new Person();
        p.setAge(age);
        System.out.println("age = " + p.getAge());
    }
}
