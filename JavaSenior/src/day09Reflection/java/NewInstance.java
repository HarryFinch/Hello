package day09Reflection.java;

import org.junit.Test;

import java.util.Random;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 通过反射创建对应的运行时类的对象
 *
 */
public class NewInstance {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        /*
        调用此方法，创建对应的运行时类的对象
        方法内部调用了运行时类的空参构造器，
        实体类必须提供空参构造器，且构造器权限通常设置为public，必须保证其权限能够使用

        在JavaBean中要求提供一个publi c的空参构造器，
        便于功过反射创建运行时类对象
        便于子类继承此运行时类时，默认用super()时，保证父类由此构造器
         */
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    //反射的例子，动态语言特性性，Java反射
    @Test
    public void test2() {
        int i = new Random().nextInt(3);
        System.out.println(i);
        String classPath = "";
        switch (i) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
//                classPath = "java.sql.Date";
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "day09Reflection.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建一个指定类的对象，classPath指定类的全名
    public Object getInstance(String classPath) throws Exception {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }


}
