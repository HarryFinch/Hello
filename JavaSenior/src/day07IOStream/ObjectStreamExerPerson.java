package day07IOStream;

import java.io.Serializable;

/*
 * @author Harold
 * @Date 2020/4/5
 * @Description : 对象流练习
 *
 *  序列化类的要求
 *      1、实现接口
 *          -- Serializable  没有抽象方法，一般称为标识接口
 *          -- Externalizable
 *      2、需要当前类提供一个全局常量serialVersionUID，
 *          如果没有这个全局常量，在反序列的时候，会出现错误
 *          这个全局常量就是类的唯一标志
 *      3、除了实现接口外，得保证内部所有属性都可以序列化（默认情况下， 基本数据类型也是可以序列化的）
 *          也就是说，引用数据类型（自定义类）也得可以进行序列化
 *
 *      补充 ： 序列化或者反序列化不能操作static和transient修饰的成员变量
 */
public class ObjectStreamExerPerson implements Serializable{

    private String name;
    private int age;
    public static final long serialVersionUID = 42125L;

    public ObjectStreamExerPerson() {}

    public ObjectStreamExerPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectStreamExerPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
