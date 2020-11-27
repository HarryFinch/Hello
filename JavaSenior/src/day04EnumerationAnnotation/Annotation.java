package day04EnumerationAnnotation;

/*
 * @Author: Harold
 * @Date: 2020/3/22 19:46
 * @Description:注解的使用
 *  1、Annotation的理解
 *      1.1 JDK5.0新增的功能，通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *      1.2 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能， 忽略警告等。在 JavaEE/Android 中注解占据了更重要的角色，
 *              例如 用来配置应用程序的任何切面，代替 JavaEE 旧版中所遗留的繁冗代码和 XML 配置等
 *  2、Annotation的使用示例
 *      在编译时进行格式检查(JDK内置的三个基本注解)
 *          @Override: 限定重写父类方法, 该注解只能用于方法
 *          @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 *          @SuppressWarnings: 抑制编译器警告
 *      框架应用：跟踪代码依赖性，实现替代配置文件功能
 *  3、自定义注解 ： 参照 SuppressWarnings()
 *      3.1 声明为 @interface
 *      3.2 内部定义成员，通常使用 value 表示
 *      3.3 可以指定成员默认值，使用 default 定义
 *      3.4 如果自定义注解没有成员，表明一个标识作用
 *      补充：如果注解有成员，使用时需要给成员赋值（有默认值可以不赋值）
 *            自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 *  4、JDK中提供的4中元注解
 *      4.1 元注解 ：修饰其他注解的注解，起到解释说明作用
 *          Retention ： 指定所修饰的Annotation的生命周期 ：SOURCE/CLASS（默认行为）/RUNTIME，
 *                       只有声明为RUNTIME生命周期的注释，才能通过反射获取
 *          Target ： 用于修饰 Annotation 的注解，注明自定义的注解能够修饰哪些结构
 *          -----出现频率较低-------
 *          Documented ： 被Documented修饰的注解被javadoc解析时保留下来
 *          Inherited ： 被修饰的Annotation将会具有继承性，也就是说被修饰类的子类也会具有父类的注释
 * 5、注解的新特性
 *      5.1 可重复注解
 *          在MyAnnotation上声明@Repeatable，成员值为Annotation.class
 *          MyAnnotation的Target和Retention等元注解与MyAnnotation相同
 *      5.2 类型注解
 *          ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语 句中（如：泛型声明）。
 *          ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 */
public class Annotation {
}

@MyAnnotation()
class Person{
    private String name ;
    private int age ;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public  void walk() {
        System.out.println("Walking");
    }
    public void eat() {
        System.out.println("eating");
    }
}

class Student extends Person {
    @Override
    public void walk() {
        System.out.println("Student walking");
    }


}