package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author Harold
 * @Date 2020/7/23
 * @Description :
 */
public class SpringDataTest {

    private ApplicationContext ctx;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testJPA() {
//        StringBuffer stringBuffer = null;
//        String string = null;


    }



}
