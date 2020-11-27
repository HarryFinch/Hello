package day10;
/*
    类封装性的引入
    1、可以对数据进行很好的封装，很好地保护数据
    2、封装性的体现
        2.1 将类的属性私有化，同时提供公共的方法来获取和设置属性
        2.2 不对外暴露私有的方法
    3、封装性的体现，需要权限修饰来配合
        3.1 Java规定的4中权限（从小到大） ： private、缺省、protected、public
        3.2 4种权限可以用来修饰类以及类的内部结构、属性、方法、构造器
    4、封装性总结
        Java提供了4红权限修饰符来修饰类以及类内部结构，体现类以及类的内部结构在被调用时的可见性的大小
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal() ;
        animal.name  = "Bear" ;
        animal.age =  5 ;
        animal.legs = 4 ;
    }

}

class Animal {
    String name ;
    int age ;
    int legs ;

    public void eat() {
        System.out.println("Animal eats");
    }

    public void show () {
        System.out.println("name :" + name );
        System.out.println("age :" + age );
        System.out.println("legs :" + legs );
    }
}