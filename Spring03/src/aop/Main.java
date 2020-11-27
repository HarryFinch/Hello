package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/7/12
 * @Description :
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
        int result = arithmeticCalculator.add(12, 3);
//        System.out.println(arithmeticCalculator.getClass().getName());
        System.out.println(result);
        result = arithmeticCalculator.divided(100, 10);
        System.out.println(result);
    }
}
