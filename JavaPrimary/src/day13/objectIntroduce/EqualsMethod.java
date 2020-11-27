package day13.objectIntroduce;

/*
    一、回顾 == 运算符的使用
        1、可以使用基本数据类型变量和引用数据类型变量中
        2、如果比较的是基本数据类型，比较两个变量保存的数据是否相等（数据类型无需相同）
            如果比较的是引用数据数据类型，比较的是两个对象的地址值是否相同
        3、使用时一定得保证左右两边的类型一致

    二、equals方法的使用
        1、是一个方法，不是一个运算符
        2、只能适用于引用数据类型，不适用于基础数据类型
    三、String、Date、File、包装类都重写了Object类中的equals方法，
        重写以后比较的不是两个引用对象的地址，而是比较两个对象的内容
    四、自定义类重写equals方法
        1、通常情况下，自定义的类如果使用equals方法，通常是比较两个对象的实体内容，而不是对象地址
 */
public class EqualsMethod {

    public void primaryData() {
        int a = 10;
        int b = 20;
        double c = 30.0;
        char d = 10;
        char e = 'A';
        char f = 65;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(e == f);
    }

    public void quoteData() {
        Test test1 = new Test();
        Test test2 = new Test();
        //调用Object类中的equals()方法，其功能于 == 运算符相同
        System.out.println(test1.equals(test2));

        String string1 = new String("Hello") ;
        String string2 = new String("Hello") ;
        //调用String类中重写的equals()方法
        System.out.println(string1.equals(string2));
    }
}

class Test{
    String string = "Hello";
}
