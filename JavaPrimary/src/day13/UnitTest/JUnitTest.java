package day13.UnitTest;

import org.junit.Test;

import java.util.Date;

/*
    Java中的JUnit单元测试
    步骤(Eclipse)：
        1、build path -- add libraries  添加JUnit
        2、创建Java类，进行单元测试
            该类要求：必须是public 、提供公共的无参构造器
        3、此类中声明单元测试方法，要求：方法的权限是public、没有返回值、没有形参
        4、单元测试方法上需要圣宁@Test
        5、在方法体内写代码，然后选中单元测试方法名，右键运行
        6、执行结果没有异常，控制台JUnit是绿色对号，出现异常是红色感叹号
 */
public class JUnitTest {

    @Test
    public void testEquals() {
        String s1 = "aa" ;
        String s2 = "bb" ;
        System.out.println(s1.equals(s2));

        Object obj = new String ("aa" ) ;
        Date date = (Date)obj;
    }
}




















