package day13.exercise;
/*
    练习：
    1、若子类重写了父类方法，就意味着子类里定义的方案彻底覆盖了父类的同名方法
        系统不可能把父类里的方法转移到子类中：编译看左边，运行看右边
    2、对于实例变量则不存在这样的现象，及时子类里定义了与父类完全相同的实例变量。，
        这个实例变量依然不能覆盖父类中定义的实例变量，编译、运行都看左边
 */
public class FieldMethod {
    public static void main(String[] args) {
        Sub s = new Sub();//单纯的Sub类对象
        System.out.println(s.count);//Sub类的count属性
        s.display();//Sub类的display()方法
        Base b = s; //向上转型
        System.out.println(b == s);//引用，地址相同
        System.out.println(b.count); //多态不适用于属性
        b.display(); //多态性，子类重写父类方法，调用子类重写的
    }
}

class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}
