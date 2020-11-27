package aop;

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

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    /*
     * @Description : 定义一个方法，用于声明切入点表达式，
     *                一般地，该方法中不需要填入其他代码
     *                其他通知可以直接使用方法名来引用切入点表达式，
     *                不同包中的可以使用全限定名来引用
     * @Param :
     */
    @Pointcut("execution(* aop.ArithmeticCalculatorImpl.*(..))")
    public void declareJoinPointExpression() {

    }


    /*
     * @Description : 在接口的每个实现类中每个方法执行前执行一段代码
     * @Param :
     */
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends ");
    }

    /*
     * @Description : 在方法正常结束后指定代码，可以访问方法的返回值
     * @Param :
     */
    @AfterReturning(value = "declareJoinPointExpression()",
            returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " afterReturning " + result);
    }


    /*
     * @Description : 在目标方法出现异常时会执行该方法
     *                 可以访问到异常对象，可以指定出现特定异常时通知
     * @Param :
     */
    @AfterThrowing(value = "declareJoinPointExpression()",
            throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurred width " + e);
    }

    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return proceedingJoinPoint.proceed();
    }


    /*
     * @Description : 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     *                环绕通知类似于动态代理的全过程，ProceedingJoinPoint类的参数可以决定是否执行目标方法
     *                环绕通知必须有返回值，返回值即为目标方法的返回值
     *                环绕通知功能是最强大的，但是却是最不常用的
     * @Param :
     */
//    @Around("execution(* aop.ArithmeticCalculatorImpl.*(..))")
//    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
//        Object result = null;
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
//        try {
//            //前置通知
//            System.out.println("The method " + methodName + " begins with " + args);
//            result = proceedingJoinPoint.proceed();
//
//            //返回通知
//            System.out.println("The method ends with " + result + "(AfterRound)");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            //异常通知
//            System.out.println("The method occurred exception : " + throwable);
//        }
//
//        //后置通知
//        System.out.println("The method end");
//
//        return result;
//    }

}
