package day12.inheritance;
/*
    方法的重写
    1、重写：子类继承父类以后，可以对父类中同名同参的方法进行覆盖操作
    2、应用：重写以后，当创建子类对对象以后，通过子类调用子父类中的同名同参方法时，实际执行的是子类重写父类的方法
    3、重写的规定
        3.1 方法声明： 权限修饰符 返回值类型（形参列表）｛方法体｝
        3.2 约定俗成：子类中叫重写的方法，相应地父类中的方法叫被重写方法
        3.3 子类重写的方法的方法名 和 形参列表于父类被重写的方法的方法名 和形参列表 相同
        3.4 子类重写的方法的权限修饰符不小于父类被重写方法的权限修饰服
                --特别说明：子类中不能重写父类中声明为private的方法
        3.5 返回值类型
            3.5.1 父类中被重写的方法的返回值类型是void ，子类中重写方法的返回值类型也是void
            3.5.2 父类中被重写的方法返回值类型是A类型，则子类重写方法的返回值类型可以是A类型或A的子类型
            3.5.3 父类中被重写方法的返回值类型是基本数据类型，则子类中重写方法的返回值类型也必须是相同的类型
        3.6 子类重写方法抛出的一场类型不大于父类被重写方法抛出的异常类型
                可以抛出父类抛出异常的子类
    ---------------------------------------------------------------------------------------------------
        子类和父类中的同名同参方法要么都声明为非static的（才可以考虑重写），static的静态方法不可重写
        static的方法是随着类的加载而加载的
    面试题：区分方法的重载与重写
 */
public class MethodOverride {
}
