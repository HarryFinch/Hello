package day03CommonClass.otherClass;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * @Author: Harold
 * @Date: 2020/3/22 17:06
 * @Description:System  Math  BigInterge   BigDecimal
 *
 */
public class OtherClass {

    //System
    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }


    //BigInterge
    @Test
    public void test2() {
        //支持任意长度
        BigInteger bigI = new BigInteger("1231313123131313213213131321321564646498797979444646");
        BigDecimal bigD1 = new BigDecimal("654645646546451645.46464564564646464664646464646464");
        BigDecimal bigD2 = new BigDecimal("11");
        System.out.println(bigI);
        System.out.println(bigD1.divide(bigD2));
        //任意精度，没有指定小数点后的数位
        System.out.println(bigD1.divide(bigD2 ,BigDecimal.ROUND_HALF_UP));
        //任意精度，指定小数点后的数位
        System.out.println(bigD1.divide(bigD2 ,15 ,BigDecimal.ROUND_HALF_UP));
    }

}
