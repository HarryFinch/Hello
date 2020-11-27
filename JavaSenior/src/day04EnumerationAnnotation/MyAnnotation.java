package day04EnumerationAnnotation;

/**
 * @Author: Harold
 * @Date: 2020/3/22 20:14
 * @Description: 自定义注解
 */
public @interface MyAnnotation {
    String value() default "hello";
}
