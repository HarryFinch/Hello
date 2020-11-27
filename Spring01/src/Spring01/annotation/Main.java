package Spring01.annotation;

import Spring01.annotation.controller.UserController;
import Spring01.annotation.repository.UserRepository;
import Spring01.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author Harold
 * @Date 2020/5/29
 * @Description : Spring bean 之间的关联
 *  1、autowire属性
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");

//        TestObject to = (TestObject)ctx.getBean("testObject");
//        System.out.println(to);
//
        UserController uc = (UserController) ctx.getBean("userController");
        System.out.println(uc);
        uc.execute();
//
//        UserService us = (UserService) ctx.getBean("userService");
//        System.out.println(us);

//        UserRepository ur = (UserRepository) ctx.getBean("userRepository");
//        System.out.println(ur);

    }

}
