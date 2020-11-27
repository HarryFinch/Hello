package Spring01.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author Harold
 * @Date 2020/4/24
 * @Description : Spring Hello World
 *
 *  1、IOC前生
 *      1.1、分离接口与实现
 *          --- 需求 -- 生成HTML或PDF格式的不同类型的报表
 *      1.2、采用工厂设计模式
 *      1.3、采用反转控制
 *  2、Spring支持的三种依赖注入的方式
 *      2.1、属性注入（实际应用中最常用的注入方式）
 *          --- 通过setter() 方法注入Bean的属性值 或 依赖的对象
 *          --- 使用property元素，使用name属性指定Bean的属性名称，value属性或<value>子节点指定属性值
 *
 *      2.2、构造器注入
 *          --- 通过构造方法注入Bean的属性或依赖的对象，保证Bean实例的在实例化后就可以使用
 *          --- 构造器注入在<constructor-arg>元素里声明属性，但<constructor-arg>中没有name属性
 *
 *      2.3、工厂方法注入（不推荐使用，使用的很少）
 *
 */
public class Hello {

    private String name;

    public Hello() {
        System.out.println("Hello`s Constructor");
    }

    public void setName(String name) {
        System.out.println("setName  " + name);
        this.name = name;
    }

    public void hello() {
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
//        Hello hello = new Hello();
//        hello.setName("Harold");
//        hello.hello();
        //1、创建Spring的IOC容器对象
        //ApplicationContext代表IOC容器
        //ClassPathXmlApplicationContext 是 ApplicationContext接口的实现类，该实现类从类路径下来加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、从IOC容器中获取Bean实例
        //利用类型返回 IOC 容器中的bean
        Hello hello = (Hello) ctx.getBean("hello");
        System.out.println(hello);

        //利用类型返回 IOC 容器中的bean，但要求 IOC 容器中必须只能有一个该类型的Bean
        Hello bean = ctx.getBean(Hello.class);
        System.out.println(bean);
//        Hello hello = (Hello) ctx.getBean("hello");
//        hello.hello();
    }

}
