package aopXml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * @author Harold
 * @Date 2020/7/12
 * @Description : 验证通知
 */
public class ValidationAspect {

    public void  validateArgs(JoinPoint joinPoint){
        System.out.println("XML Validation : " + Arrays.asList(joinPoint.getArgs()) );
    }

}




















