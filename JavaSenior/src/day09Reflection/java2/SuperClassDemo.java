package day09Reflection.java2;

import day09Reflection.java1.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 获取当前运行时类的父类
 */
public class SuperClassDemo {

    //获取运行时类的父类
    @Test
    public  void testSuper() {

        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    // 获取运行时类带泛型的父类
    @Test
    public void testTemplateSuper() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    // 获取运行时类带泛型的父类的泛型
    @Test
    public void testTemplateSuper1() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型的参数
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

}
