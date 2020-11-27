package Spring01.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-beanFactory.xml");
        Car car = (Car)ctx.getBean("car");
        System.out.println(car);
    }

}
