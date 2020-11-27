package Spring01.scope;

import Spring01.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/27
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scope.xml");
//        Car car = (Car) ctx.getBean("car");
//        Car car1 = (Car) ctx.getBean("car");
//        System.out.println(car == car1);
    }



}
