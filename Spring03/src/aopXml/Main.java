package aopXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/7/12
 * @Description :
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        int result = arithmeticCalculator.add(12, 3);
//        System.out.println(arithmeticCalculator.getClass().getName());
        System.out.println(result);
        result = arithmeticCalculator.divided(100, 10);
        System.out.println(result);
    }
}
