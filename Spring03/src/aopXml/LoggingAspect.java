package aopXml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Harold
 * @Date 2020/7/12
 * @Description :
 */

public class LoggingAspect {


    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("XML The method " + methodName + " begins with " + args);
    }

    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("XML The method " + methodName + " ends ");
    }

    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("XML The method " + methodName + " afterReturning " + result);
    }


    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("XML The method " + methodName + " occurred width " + e);
    }


    /*
     * @Description : 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     *                环绕通知类似于动态代理的全过程，ProceedingJoinPoint类的参数可以决定是否执行目标方法
     *                环绕通知必须有返回值，返回值即为目标方法的返回值
     *                环绕通知功能是最强大的，但是却是最不常用的
     * @Param :
     */
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
        try {
            //前置通知
            System.out.println("XML The method " + methodName + " begins with " + args);
            result = proceedingJoinPoint.proceed();

            //返回通知
            System.out.println("XML The method ends with " + result + "(AfterRound)");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("XML The method occurred exception : " + throwable);
        }

        //后置通知
        System.out.println("XML The method end");

        return result;
    }

}
