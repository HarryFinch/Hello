package day15.innerClass;

/*
    类的内部成员之五：内部类
    1、Java中允许将一个类A声明在另一类B中，则类A就是内部类，类B称为外部类
    2、内部类分类；成员内部类（静态、非静态） vs 局部内部类（方法内、代码块内、构造器内）

    3、成员内部类
        一方面，作为外部类的成员：
            -- 可以调用外部类的结构
            -- 可以用static修饰
            -- 可以被四种不同的权限修饰

        另一方面，作为一个类出现
            -- 类内可以定义属性、方法、构造器等
            -- 可以被final修饰，表示此类不能被继承
            -- 可以被abstract修饰
    4、关注如下的三个问题
        4.1 如何实例化成员内部类的对象
            -- 静态对象实例化
            -- 非静态对象实例化
        4.2 如何在成员内部类中去区分调用外部类的结构
            -- 重名的通过this关键字、InnerClass.this.属性调用
            -- 不重名的直接调用
        4.3 开发中局部内部类使用情景
            -- 见DevelopmentDemo类
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        //创建Dog实例（静态的成员内部类）
        InnerClass.Dog dog = new InnerClass.Dog();
        dog.show();

        //创建Bird实例(非静态内部类)
        InnerClass innerClass = new InnerClass();
        InnerClass.Bird bird = innerClass.new Bird();
        bird.sing();

        bird.display("黄鹂");
    }
}

class DevelopmentDemo {

    //开发中很少见
    public void method() {
        class AA {

        }
    }

    //返回一个实现了接口的类的对象
    public Comparable getComparable() {
        //方式一  创建一个实现了Comparable接口的类，局部内部类
/*        class MyComparable implements Comparable {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();
        */
        //方式二 接口匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }


}


class InnerClass {

    String name = "小明";
    int age;

    public void eat() {
        System.out.println("eating");
    }

    //成员内部类
    static class Dog {
        String name = "aaaa";
        int age;

        public void show() {
            System.out.println("I am a dog");
        }
    }

    class Bird {
        String name = "杜鹃";

        public void sing() {
            System.out.println("I am a little bird");
            InnerClass.this.eat();
        }

        public void display(String name) {
            //方法的形参
            System.out.println("Name = " + name);
            // 没有冲突的属性
            System.out.println("age = " + age);
            // 内部类的属性
            System.out.println("this.name = " + this.name);
            //外部类的属性
            System.out.println("InnerClass.this.name = " + InnerClass.this.name);
        }
    }

    //局部内部类
    public void method() {
        class AA {

        }
    }


    //局部内部类
    {
        class BB {

        }
    }

    public InnerClass() {
        //局部内部类
        class CC {

        }
    }
}
