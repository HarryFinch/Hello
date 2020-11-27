package day09Reflection.java2;

import day09Reflection.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 获取构造器结构
 */
public class ConstructorDemo {

    //获取当前运行时类的公有构造器
    @Test
    public void testConstructor() {
        Class clazz = Person.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor con : constructors ) {
            System.out.println(con);
        }

        System.out.println();

        //获取当前运行时类的所有构造方法
        Constructor[] constructor = clazz.getDeclaredConstructors();
        for (Constructor con : constructor) {
            System.out.println(con);
        }

    }
    
}
