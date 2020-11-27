package day09Reflection.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/*
 * @author Harold
 * @Date 2020/4/14
 * @Description : 了解类的加载器
 *
 */
public class ClassLoaderDemo {

    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(loader);

        //调用系统类加载器的getParent()获取扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);

        //调用系统类加载器的getParent() 无法获取引导类加载器
        //引导类架子傲气主要负责加载Java的核心类库，无法加载自定类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    //Properties 用来读取配置文件
    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        // //读取配置文件的方式一，默认在当前的module下
//        FileInputStream fis = new FileInputStream("jsbc.properties");
//        properties.load(fis);

        //读取配置文件的方式二，此时的当前路径是module的src下
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("jsbc.properties");
        properties.load(is);


        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + "\t" + "password=" + password);
    }

}
