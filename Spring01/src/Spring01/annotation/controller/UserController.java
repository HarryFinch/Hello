package Spring01.annotation.controller;

import Spring01.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    public void execute(){
        System.out.println("UserController execute()....");
        userService.add();
    }

}
