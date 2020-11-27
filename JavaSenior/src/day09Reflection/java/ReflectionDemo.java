package day09Reflection.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * @author Harold
 * @Date 2020/4/13
 * @Description : Reflection 的应用
 *  1、反射对类的操作
 *      1.1、通过反射可以调用类的私有结构
 *
 *  2、对象和反射都可以调用公共机制，开发中到底用哪个
 *      建议使用new的方式，使用对象调用
 *      在不确定创建哪个类的对象时，使用反射的反射的方式，创建对象，调用属性方法
 *  3、反射机制与面向对象的封装性
 *
 *  4、关于java.lang.Class类的理解
 *      4.1、类的加载过程
 *          --- 类在经过javac.exe命令以后，会生成一个或多个字节码文件，
 *          --- 使用java.exe，对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，此过程称为类的加载
 *              加载到内存中的类，就称为运行时类，，此类运行时，就作为Class的一个实例
 *      4.2、Class的实例就对应着一个运行时类
 *           加载到内存中的运行时类，会缓存一定的时间，在此时间内，可以通过不同的方式获取此运行时类
 *
 *  5、可以作为Class对象的类型
 *      --- 类： 外部类、内部类、局部类、匿名类
 *      --- 接口(interface)
 *      --- 数组(Array)
 *      --- 枚举(enum)
 *      --- 注解(annotation)
 *      --- 基本数据类型(primitive type)
 *      --- void
 */
public class ReflectionDemo {

    //反射对类的操作
    @Test
    public void test1() throws Exception {

        //通过反射，创建Person类的对象
        Class personReflect = Person.class;
        Constructor cons = personReflect.getConstructor(String.class, int.class);
//        Object obj = cons.newInstance("Harold", 20);
//        System.out.println(obj.toString());
        Person person = (Person) cons.newInstance("Harold", 20);
        System.out.println(person.toString());

        //通过反射，调用对象指定的属性
        Field age = personReflect.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person.toString());

        //通过反射，调用对象指定的方法
        Method show = personReflect.getDeclaredMethod("show");

        System.out.println("------------------------------------------------------------");

        //调用私有的属性和方法
        Constructor constructor = personReflect.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person person1 = (Person) constructor.newInstance("Reese");
        System.out.println(person1);

        //调用私有的属性
        Field name = personReflect.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Root");
        System.out.println(person1);

        //调用私有的方法
        Method showNation = personReflect.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1, "华夏");
        System.out.println(nation);
    }

    //获取Class实例的方式，四种方式都可以获取实例，而且都是同一个实例
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一  调用运行是类的属性
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        //方式二  通过运行时类的对象
        Person p1 = new Person();
        Class clazz1 = p1.getClass();
        System.out.println(clazz1);

        //方式三  调用Class的静态方法：forName(String classPath)类的全类名
        Class aClass = Class.forName("day09Reflection.java.Person");
        System.out.println(aClass);

        System.out.println(clazz == clazz1);
        System.out.println(clazz == aClass);

        //方式四  使用类的加载器 ClassLoader
        ClassLoader cl = ReflectionDemo.class.getClassLoader();
        Class loadClass = cl.loadClass("day09Reflection.java.Person");
        System.out.println(loadClass);

    }

    //Class实例可以是哪些结构的说明：
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
