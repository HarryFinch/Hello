package aopImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/7/11
 * @Description :
 */
public class Main {

    public static void main(String[] args) {

        //1.创建Spring 的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.从IOC容器中获取bean 的实例
        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);

        //3.使用bean
        int result = arithmeticCalculator.add(1, 2);
        System.out.println(result);

        result = arithmeticCalculator.divided(4, 2);
        System.out.println(result);
    }

}
