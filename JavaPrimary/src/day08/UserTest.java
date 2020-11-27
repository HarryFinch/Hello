package day08;

/*
1、属性：写在类的{}内，有权限修饰符
2、局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部变量
            没有权限修饰符
3、默认初始化的情况
    属性：有默认初始化值，根据其具体类型决定
          整型--0
          浮点型--0.0
          字符型--'0'或（'\u0000'）
          布尔型--false
          引用类型(类、数组、接口)---null

    局部变量：没有默认初始化值，所以在调用局部变量前需要显示赋值
                特别地，形参在调用的时候进行复制即可


4、局部变量和属性在内存中加载的位置（非static变量）：
        属性：加载到堆空间中
        局部变量：加载到栈空间中

5、变量都是先声明后使用，变量都有其对应的作用域

 */
public class UserTest {
    String name;
    int age;
    boolean isMale;

    public void talk(String language) {//language是形参，也是局部变量
        System.out.println("use:" + language);
    }

    public void eat() {
        String food = "bing"; //局部变量
        System.out.println("北方人喜欢吃：" + food);
    }

}
