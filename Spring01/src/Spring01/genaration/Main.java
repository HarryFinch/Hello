package Spring01.genaration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-generic.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }

}
