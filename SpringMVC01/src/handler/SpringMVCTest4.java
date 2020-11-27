package handler;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Harold
 * @Date 2020/7/20
 * @Description :
 */

@Controller
@RequestMapping("/springDemo4")
public class SpringMVCTest4 {
    private static final String SUCCESS = "hello";

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        System.out.println("ModelAttribute method");
    }

    /*
     * @Description :
     *  不论目标方法何种类型数据，SpringMVC 都会转换为 ModelAndView 类型，
     *  视图解析器讲 ModelAndView 对象解析为真正的物理视图，然后通过 View 的 render方法 渲染得到响应结果
     *  InternalResourceViewResolver 主要是搞转发(请求转发、请求重定向)结果
     * @Param :
     * @return :
     */
    @RequestMapping("/testViewAndViewResolver")
    public String testCViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    @RequestMapping("/testView")
    public String testView() {
        System.out.println("testView");
        return "helloView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("test Redirect");
        return "redirect://index.jsp";
    }

    /*
     * @Description : @InitBinder 注解
     *      通过注解可以对指定字段进行操作，如不赋值
     * @Param :
     * @return :
     */
    @InitBinder
    public void testInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("");
    }

}
