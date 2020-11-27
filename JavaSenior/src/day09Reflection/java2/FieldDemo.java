package day09Reflection.java2;

import day09Reflection.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 * @author Harold
 * @Date 2020/4/22
 * @Description : 获取当前运行时类的属性结构
 */
public class FieldDemo {

    //获取运行时类的属性
    @Test
    public void test1() {
        Class clazz = Person.class;

        //获取属性结构
        //getFields()获取当前运行时类，以及父类当中声明为public的属性
        Field[] fields = clazz.getFields();
         for (Field f : fields) {
             System.out.println(f);
         }

         //getDeclaredFields()获取当前运行时类中声明的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    //获取运行时类的部分属性结构
    //比如，权限修饰符、变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.println("getFieldModifiers :" + Modifier.toString(modifiers));
            //获取数据类型
            Class type = f.getType();
            System.out.println("getFieldType : " + type.getName());
            //获取变量名
            String name = f.getName();
            System.out.println("FieldName : " + name);
            System.out.println();
        }
    }

}
