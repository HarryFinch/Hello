package day12.inheritance;
/*
    一、子类对象实例化的全过程
        1、从结果上来看（继承性）：
            子类继承父类以后，就获取了父类中声明的属性和方法
            创建子类的对象，再对空间中，就会加载所有的父类中声明的属性
        2、从过程上来看：
            通过子类的构造器创建子类对象时，一定会直接或间接地其父类的构造器，进而调用父类的父类构造器，直到调用到Object类构造器
            正因为加载过所有父类的结构，所以才可以看到内存中有父类的结构，子类对象才可以考虑进行调用
        3、明确：子类对象创建过程中，虽然调用了父类构造器，但是只创建了一个子类对象，并没有创建父类对象
 */
public class Instance {
}
