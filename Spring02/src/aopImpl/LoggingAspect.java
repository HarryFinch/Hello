package aopImpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * @author Harold
 * @Date 2020/7/11
 * @Description : 日志切面
 * 把这个类声明为一个切面，分为两步
 * 1、需要把该类放入到IOC容器中
 * 2、将该类声明为一个切面
 */
@Aspect
@Component
public class LoggingAspect {

    /*
     * @Description : 声明该方法是一个前置通知，在目标方法开始前执行
     * @Param : joinPoint 封装了切面方法的信息，该对象可以获取目标方法的信息
     */
    @Before("execution(public int aopImpl.ArithmeticCalculatorImpl.*(int ,int ) )")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method  " + methodName + " begins" + args);
    }


    //后置通知，在目标方法执行后（无论是否发生异常），执行通知
    //不能
    @After("execution(* aopImpl.ArithmeticCalculatorImpl.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " ends");
    }
}
