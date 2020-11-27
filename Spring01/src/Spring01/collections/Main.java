package Spring01.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/25
 * @Description : 测试类
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Person person3 = (Person) ctx.getBean("person3");
//        System.out.println(person3);

        Person person4 = (Person) ctx.getBean("person5");
        System.out.println(person4);

//        System.out.println("---------------------");
//
//        Person1 person1 = (Person1) ctx.getBean("person1");
//        System.out.println(person1);
//
//        System.out.println("---------------------");

        DataSource bean = ctx.getBean(DataSource.class);
        System.out.println(bean.getProperties());
    }

}
