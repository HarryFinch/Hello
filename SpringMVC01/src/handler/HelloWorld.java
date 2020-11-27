package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Harold
 * @Date 2020/7/17
 * @Description : SpringMVC 的 HelloWorld
 */

@Controller
@RequestMapping("/springmvc")
public class HelloWorld {

    /*
     * @Description :
     *  1、使用 RequestMapping 注解来映射请求的URL
     *  2、返回值会通过事物解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会进行如下操作 :
     *      通过prefix + returnVal + suffix 方式得到实际的物理视图，然后做转发操作
     * @Param :
     */
    @RequestMapping("/helloWorld")
    public String Hello() {
        System.out.println("Hello!");
        return "hello";
    }

}
