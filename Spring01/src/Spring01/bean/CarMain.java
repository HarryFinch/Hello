package Spring01.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/4/24
 * @Description : 用以测试
 */
public class CarMain {
    public static void main(String[] args) {
        //创建S平的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Car car = ctx.getBean(Car.class);
//        System.out.println(car);
//        Car car = (Car) ctx.getBean("car");
//        System.out.println("car " + car);
//
//        Car car1 = (Car) ctx.getBean("car1");
//        System.out.println("car1 " + car1);
//
//        Car car2 = (Car) ctx.getBean("car2");
//        System.out.println("car2 " + car2);

        Person person = (Person) ctx.getBean("person");
        System.out.println("Person " + person);

        Person person1 = (Person)ctx.getBean("person2");
        System.out.println("person1" + person1);
    }
}
