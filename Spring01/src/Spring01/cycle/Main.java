package Spring01.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cycle.xml");
        Car car = (Car)ctx.getBean("car");
        System.out.println(car.toString());

        //关闭IOC容器
        ctx.close();

    }

}
