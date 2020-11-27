package Spring01.relation;

import Spring01.autowire.Address;
import Spring01.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/27
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
        Address address = (Address) ctx.getBean("address");
        System.out.println(address);
        address = (Address) ctx.getBean("address1");
        System.out.println(address);

        Person person = (Person)ctx.getBean("person");
        System.out.println(person);
    }
}
