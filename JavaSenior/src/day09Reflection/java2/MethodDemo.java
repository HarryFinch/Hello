package day09Reflection.java2;

import day09Reflection.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 获取运行时类的方法结构
 */
public class MethodDemo {

    //获取当前运行时类的方法
    @Test
    public void test1() {
        Class clazz = Person.class;

        //getMethods()  获取当前运行时类及其所有父类中的声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //获取当前运行时类的所有方法，不包括父类中的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    //获取当前运行时类的方法结构
    //注解、权限修饰符、返回值类型、形参列表、异常类型
    @Test
    public void test2() {

        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //获取方法声明的注解
        for (Method m : declaredMethods) {
            //获取注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annos : annotations) {
                System.out.print("annos : " + annos + "\t");
            }

            //获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            //获取返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            //获取方法名
            System.out.print(m.getName() + "(");
            //获取方法形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (Class para : parameterTypes) {
                    System.out.print(para.getName());
                }
            }
            System.out.print(")");

            //获取抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length ==0) ){
                System.out.print("throw");
                for (int i = 0 ; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getName() + " ");
                }
            }

            System.out.println();
        }


    }
}
