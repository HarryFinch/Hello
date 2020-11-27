package Spring01.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/27
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext  ctx = new ClassPathXmlApplicationContext("bean-spel.xml");
        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Car  car = (Car)ctx.getBean("car");
        System.out.println(car);

        Person person = (Person)ctx.getBean("person");
        System.out.println(person);
    }

}
