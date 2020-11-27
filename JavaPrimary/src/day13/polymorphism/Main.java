package day13.polymorphism;

/*
    三、多态性
        1、可以理解为一个事物的多种形态
        2、父类的引用子类的对象，即为多态性
 */
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.eat();

        Man man1 = new Man();
        man1.eat();
        man1.age = 22;
        man1.earnMoney();

        //多态性：父类的引用子类的对象
        Person person2 = new Man();
/*
        多态的使用，当调用子父类同名同参数的方法时，实际上执行的是子类重写父类的方法 -- 虚拟方法调用
        有了对象多态性以后，我们在编译期，只能调用父类中声明的方法，但实际执行的是子类重写父类的方法
        编译看左边，运行看右边(只适用于属性）
        父类引用子类对象称为向上转型（通常说多态）

        属性都看左边
*/
        person2.eat();
        person2.walk();
        /*
            通过强制类型转换可以使子类对象引用父类对象（向下转型）
            使用强转时可能出现ClassCastException
         */
        Man man2 = (Man) person2;
        man2.earnMoney();
        man2.isSmoking = true;


        //练习
        //问题1： 编译时通过，运行时不通过
        //举例一
        Person p3 = new Woman() ;
        Man man3 = (Man)p3;

        //举例二
        Person p4 = new Person();
        Man man4 = (Man)p4 ;

        //问题二：编译时通过，运行时也通过
        Object object = new Woman() ;
        Person person = (Person)object;

        //问题三：编译不通过,类型不匹配
//        Man man5 = new Woman();

    }
}
