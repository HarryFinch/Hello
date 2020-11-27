package test;

import crud.dao.EmployeeDao;
import crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * @author Harold
 * @Date 2020/7/21
 * @Description :
 */

@Controller
@RequestMapping("/springMVCDemo1")
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    /*
     * @Description : 测试Json，方法的返回值格式是Json
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }


    @RequestMapping("/testConversion")
    public String testConverter(@RequestParam("employee") Employee employee) {

        System.out.println(employee);

        employeeDao.save(employee);

        return "redirect:/emps";
    }


    /*
     * @Description : 测试 HttpMessageConverter,文件上传
     *  1、通过添加@ResponseBody、@RequestBody注解，可以使用 HttpMessageConverter
     *      将请求信息转化并绑定到处理方法的入参中或者将相应结果转为对应类型的相应信息
     *  2、注解标注后，首先根据请求头或相应头的Accept属性选择匹配的 HttpMessageConverter ，
     *      进而根据参数类型或者泛型类型过滤得到匹配的 HttpMessageConverter，如果找不到 HttpMessageConverter 将会报错
     * @Param :
     * @return :
     */
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println("testHttpMessageConverter body : " + body);
        return "helloWorld!" + new Date();
    }


    /*
     * @Description :  测试 HttpMessageConverter,文件下载
     * @Param :
     * @return :
     */
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/files/abc.txt");
        body = new byte[inputStream.available()];
        inputStream.read(body);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=abc.txt");

        HttpStatus httpStatus = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders, httpStatus);

        return responseEntity;
    }

    @RequestMapping("/testI18n")
    public String testI18n(Locale locale) {
        String val = resourceBundleMessageSource.getMessage("i18n.user", null, locale);
        System.out.println("testI19n " + val);
        return "i18n";
    }


    //文件上传
    @RequestMapping("/testMultipartFileUpload")
    public String testMultipartFileUpload(@RequestParam String desc, @RequestParam MultipartFile multipartFile) throws IOException {
        System.out.println("desc : " + desc);
        System.out.println("File Name : " + multipartFile.getOriginalFilename());
        System.out.println("OriginalFileName : " + multipartFile.getInputStream());
        return "";
    }

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam Integer i) {
        System.out.println("result : " + 19 / i);
        return "success";
    }

    /*
     * 1、@ExceptionHandler 方法的入参中可以加入 Exception 类型的参数，该参数即对应发生的异常对象
     * 2、@ExceptionHandler 方法的入参中不鞥呢传入Map，如希望把异常信息传到页面上，需要使用ModelAndView作为返回值类型
     * 3、@ExceptionHandler 方法的异常优先级，按照异常匹配的准确度进行匹配
     * 4、@ControllerAdvice 如果在当前handler中找不到 @ExceptionHandler 方法来处理当前发生的异常
     *    则去 @ControllerAdvice 标记的类中中寻找 @ExceptionHandler 标记的方法
     */

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handlerArithmeticException(Exception e) {
        System.out.println("There is exception(s)");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e);
        return mv;
    }

//    @ExceptionHandler(ArithmeticException.class)
//    public String handlerArithmeticException(Exception e) {
//        System.out.println("There is exception(s)");
//        return "error";
//    }

    /*
     * @ResponseStatus 注解修饰方法，该方法会按照指定的状态码和错误信息，显示在页面上
     */
//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "页面丢失")
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") Integer i) {
        if (i == 13) {
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testResponseStatusExceptionResolver");
        return "success";
    }


    /*
     * DefaultHandlerExceptionResolver 类可以处理Spring常见的异常
     * 处理异常的类型参考源码
     */
    @RequestMapping(value = "/testDefaultHandlerExceptionResolver",method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver() {
        System.out.println("testDefaultHandlerExceptionResolver...");
        return "success";
    }

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") Integer i) {
        System.out.println("testSimpleMappingExceptionResolver");
        String[] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }

}
