package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Harold
 * @Date 2020/7/12
 * @Description : 验证通知
 */
@Order(2) //指定切面的优先级，值越小优先级越高
@Aspect
@Component
public class ValidationAspect {

    @Before("aop.LoggingAspect.declareJoinPointExpression()")
    public void  validateArgs(JoinPoint joinPoint){
        System.out.println("Validation : " + Arrays.asList(joinPoint.getArgs()) );
    }

}




















