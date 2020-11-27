package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Harold
 * @Date 2020/7/18
 * @Description : SpringMVC
 *  1、@RequestMapping注解，value、method、params、headers属性
 *  2、@pathVariable注解
 *  3、REST风格
 */

@Controller
@RequestMapping("/springMVC")
public class SpringMVCTest1 {

    private static final String SUCCESS = "hello";

    /*
    1、@RequestMapping不仅可以修饰方法，也可以修饰类
    2、类定义处：提供初步的请求映射信息，相对于WEB应用的根目录
       方法处：提供进一步的细分映射信息，相对于类定义处的URL；
               若类定义处为标注@RequestMapping，则方法处标记的URL相对于WEB应用的根目录
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /*
     * @Description : RequestMapping注解参数
     *      1、value ：请求路径
     *      2、method ：请求方法
     *      3、params ：请求参数
     *          param1 ：必须包含param1
     *          !param1 ：必须不能包含param1
     *          param1 != value ：包含param1但值不能是value1
     *      4、head ：请求头
     * @Param :
     * @return : 跳转的页面
     */
    @RequestMapping(value = "/testMethod",
            method = RequestMethod.POST,
            headers = {"Accept-Language=zh-CN,zh;q=0.9"}
    )
    public String testRequestMethod() {
        System.out.println("testRequestMethod");
        return SUCCESS;
    }

    @RequestMapping(value = "/testParams", params = {"userName", "age!=10"})
    public String testRequestParams() {
        System.out.println("testRequestParams");
        return SUCCESS;
    }

    @RequestMapping("/testAnt/*/any")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /*
     * @Description : @PathVariable 可以映射URL中的占位符到目标方法的参数中
     * @Param : id 目标方法的参数
     * @return :
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable : " + id);
        return SUCCESS;
    }

    /*
     * @Description : REST风格的URL，以CRUDE为例
     *      1、新增 ：/order        post
     *      2、修改 ：/order/1      put
     *      3、获取 ：/order/1      get
     *      4、删除 ：/order/1      delete
     *  如何发送PUT和DELETE请求
     *      1、配置HiddenHttpMethodFilter
     *      2、发送POST请求
     *      3、需要在发送POST请求是携带name属性值为_method 的隐藏域，value为DELETE或PUT
     *
     *  在SpringMVC的目标方法中使用@PathVariable注解获取数据
     * @Param :
     * @return :
     */
    @RequestMapping(value = "/testRestGet/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id) {
        System.out.println("testRestGet : " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestPost", method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("testRestPost");
        return SUCCESS;
    }

    //    @ResponseBody
    @RequestMapping(value = "/testRestPut/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRestPut : " + id);
        return SUCCESS;
    }

    //    @ResponseBody
    @RequestMapping(value = "/testRestDelete/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRestDelete : " + id);
        return SUCCESS;
    }

}
