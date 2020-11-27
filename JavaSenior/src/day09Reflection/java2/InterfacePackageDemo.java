package day09Reflection.java2;

import day09Reflection.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 获取运行时类的接口
 */
public class InterfacePackageDemo {

    @Test
    public void testGetInterface() {
        //获取运行时类的接口
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        //获取运行类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }

    }

    @Test
    public void testGetPackage() {
        //获取运行时类所在的包
        Class clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void testGetAnnotations() {
        //获取运行时类所在的包
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(annotations);
        }
    }


}
