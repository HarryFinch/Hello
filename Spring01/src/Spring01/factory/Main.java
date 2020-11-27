package Spring01.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-factory.xml");
        Car car1 = (Car) ctx.getBean("car1");
        System.out.println(car1);

        System.out.println("-----------------------------");
        Car car2 = (Car)ctx.getBean("car2");
        System.out.println(car2);
    }

}
