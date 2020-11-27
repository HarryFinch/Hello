package com.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Harold
 * @Date 2020/7/22
 * @Description :
 */

@Controller
@RequestMapping("/helloWorld ")
public class HelloWorld {

    @Autowired
    private UserService userService;

    public HelloWorld() {
        System.out.println("Hello World Constructor...");
    }


    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World");
        return "success";
    }


}
