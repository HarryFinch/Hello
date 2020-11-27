package day09Reflection.java2;

import day09Reflection.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 调用运行时类的指定结构
 *  属性、方法、构造器
 *
 */
public class ReflectionDemo {

    //获取运行时类中的public属性，但开发中不常用
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person person = (Person) clazz.newInstance();

        //获取指定的属性
        Field id = clazz.getField("id");

        //设置当前属性的值
        id.set(person, 611);

        //获取当前属性的值
        int personId = (int) id.get(person);


        System.out.println(personId);
    }

    //操作运行时类的属性，不受属性的限制，必须掌握
    @Test
    public void testField1() throws Exception {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        //获取指定变量名的属性，能够找到类中的所有属性
        //修改属性之前，需要更改属性的权限
        Field name = clazz.getDeclaredField("name");
        //表示当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "Harold");
        name.get(p);
        System.out.println(p.toString());
    }

    /*
     * @Description : 获得运行时类的方法 --- 掌握
     * @Param :
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;
        Person Person = (Person) clazz.newInstance();

        //获取运行时类的指定方法
        //getDeclaredMethod() 参数1 指明获取方法的名称   参数2 指明获取方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        //修改方法访问权限
        show.setAccessible(true);
        //调用invoke方法执行
        //invoke()的返回值即为对应类中调用的方法的返回值
        Object invoke = show.invoke(Person, "中国");
        System.out.println(invoke);

    }

    /*
     * @Description : 反射调用类中的静态方法 --- 掌握
     * @Param :
     */
    @Test
    public void testStaticMethod() throws Exception {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //调用的运行时类中的方法没有返回值，则invoke方法返回null
//        Object invoke = showDesc.invoke(null);
        Object invoke = showDesc.invoke(person);
        System.out.println(invoke);//invoke方法本身没有返回值，所以invoke为null

    }

    /*
     * @Description : 如何调用运行类中指定的构造器
     * @Param :
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;
        Person instance = (Person) clazz.newInstance();

        //获取指定的构造器
        //指明构造器的参数列表
        Constructor personCons = clazz.getConstructor(String.class);
        //保证此构造器是可访问的
        personCons.setAccessible(true);

        //调用此类的构造器，构造运行时对象
        Person pang = (Person) personCons.newInstance("pang");

    }

}
