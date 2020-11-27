package handler;

import entities.Address;
import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author Harold
 * @Date 2020/7/19
 * @Description :
 * 1、@RequestParam注解
 * 2、@RequestHeader注解
 * 3、@CookieValue注解
 * 4、POJO
 * 5、ServletAPI
 */

@Controller
@RequestMapping("/springDemo2")
public class SpringMVCTest2 {

    private static final String SUCCESS = "hello";

    /*
     * @RequestParam注解映射请求参数
     *  1、value表示请求参数的参数名，页面中的name属性值一致
     *  2、required表示该参数是否必须
     *  3、defaultValue表示该参数的默认值
     * 注 ：这个注解常用，使用场景较多，得记住
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
        System.out.println("userName = " + userName + " , " + "age = " + age);
        return SUCCESS;
    }

    /*
     * @Description : @RequestHeader注解，映射请求头信息
     *  1、value表示请求头名称
     *  2、required表示是否必须
     *  3、defaultValue表示默认值
     * 用法同@RequestParam注解相同，使用场景不多
     * @Param :
     * @return :
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String requestHeader) {
        System.out.println("testRequestHeader Accept-Language : " + requestHeader);
        return SUCCESS;
    }


    /*
     * @Description : @CookieValue 映射一个Cookie值
     *      属性同@RequestParam注解相同，用法也一致
     * @Param :
     * @return :
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String sessionId) {
        System.out.println("testCookieValue JSESSIONID : " + sessionId);
        return SUCCESS;
    }

    /*
     * @Description : POJO
     *  SpringMVC 会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值，支持级联属性
     * @Param :
     * @return :
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo : " + user.toString());
        return SUCCESS;
    }


    /*
     * @Description : 使用Servlet原生的API作为方法的参数
     *  支持如下参数：
     *      1、HttpServletRequest
     *      2、HttpServletResponse
     *      3、HttpSession
     *      4、java.security.Principal
     *      5、OutputStream
     *      6、Reader
     *      7、Writer
     * @Param :
     * @return :
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServletAPI " + request);
        System.out.println("testServletAPI " + response);
        return SUCCESS;
    }

    //测试了Writer
//    @RequestMapping("/testServletAPI")
//    public void testServletAPI1(HttpServletRequest request, HttpServletResponse response, Writer writer) {
//        System.out.println("testServletAPI " + request);
//        System.out.println("testServletAPI " + response);
//        try {
//            writer.write("Hello SpringMVC");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
