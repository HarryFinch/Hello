package Spring01.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/27
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext  ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");
        Address address = (Address) ctx.getBean("address");
        Car car = (Car)ctx.getBean("pcar");
        Person person = (Person)ctx.getBean("person");
        System.out.println(address);
        System.out.println(car);
        System.out.println(person);
    }

}
