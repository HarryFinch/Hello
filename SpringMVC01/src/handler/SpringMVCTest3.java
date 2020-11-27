package handler;

import entities.Address;
import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author Harold
 * @Date 2020/7/19
 * @Description :
 * 1、ModelAndView
 * 2、目标方法参数为Map
 * 3、@SessionAttributes注解
 * 4、@ModelAttribute注解
 */

@Controller
@SessionAttributes({"user"})
@RequestMapping("/springMVCDemo3")
public class SpringMVCTest3 {

    private static final String SUCCESS = "hello";

    /*
     * @Description :
     *  目标方法的返回值类型可以是ModelAndView类型，其中可以报刊视图和模型信息
     *  SpringMVC 会把 ModelAndView 的 model 中数据放入到request域对象中
     * @Param :
     * @return :
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);

        //添加模型数据到ModelAndView
        modelAndView.addObject("time", new Date());

        return modelAndView;
    }

    /*
     * @Description :
     *  处理数据模型的第二种方式
     *  目标方式可以添加 Map 类型的参数(实际上也可以是Model类型或者ModelMap类型)
     * @Param : map
     * @return :
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("name", Arrays.asList("Tome", "Harold"));
        return SUCCESS;
    }

    /*
     * @Description :
     *  @SessionAttribute注解除了可以通过属性名指定需要放到绘画中的属性外(实际上使用的是value属性值)
     *  还可以通过模型属性的对象类型指定哪些模型需要放到会话中（使用types属性值）
     *  该注解只能修饰类，不能修饰方法，开发的时候会用到
     * @Param :
     * @return :
     */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Map<String, Object> map) {
        User user = new User("Harold", "123", "345@123", 20, new Address());
        map.put("user", user);
        return SUCCESS;
    }


    /*
     * @ModelAttribute注解标记的方法会在每个目标方法执行前被SpringMVC调用
     * @ModelAttribute注解也可以修饰目标方法POJO类型的入参，其value属性值具有如下作用 ：
     *      -- SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象，若存在则会直接传入到目标方法的入参中
     *      -- SpringMVC 会一value 为 key， POJO 类型的对象为value，存入 request 中
     *      -- 可以使用 @ModelAttribute 注解修饰参数，value 属性值为 map 的 key 值，
     *          一般情况下，@ModelAttribute 修饰的方法中的map.put(key,value) 与 @RequestMapping修饰的方法的参数类型对象一致即可
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            User user = new User(1, "Harold", "123", "123@345", 20);
            map.put("user", user);
            System.out.println("从数据库获取了一个对象 : " + user);
        }
    }

    /*
     *  一、运行流程
     *      1、执行@ModelAttribute修饰的方法，从数据库中取出了一个对象，把对象放入Map中，key值为user
     *      2、SpringMVC从Map中取出user(key值)对象，并把表单的请求参数改user对象的对应属性
     *      3、SpringMVC把上述对象传入目标方法的参数
     *  注意 ：在ModelAttribute修饰的方法中，放入到Map时的键值需要和目标方法入参类型的首字母小写的一致
     *      如果不一致
     *
     * 二、SpringMVC 确定目标方法 POJO 类型入参的过程
     *  1. 确定一个 key:
     *      1). 若目标方法的 POJO 类型的参数木有使用 @ModelAttribute 作为修饰, 则 key 为 POJO 类名第一个字母的小写
     *      2). 若使用了  @ModelAttribute 来修饰, 则 key 为 @ModelAttribute 注解的 value 属性值.
     *  2. 在 implicitModel 中查找 key 对应的对象, 若存在, 则作为入参传入
     *      1). 若在 @ModelAttribute 标记的方法中在 Map 中保存过, 且 key 和 1 确定的 key 一致, 则会获取到.
     *  3. 若 implicitModel 中不存在 key 对应的对象, 则检查当前的 Handler 是否使用 @SessionAttributes 注解修饰,
     *  若使用了该注解, 且 @SessionAttributes 注解的 value 属性值中包含了 key, 则会从 HttpSession 中来获取 key 所
     *  对应的 value 值, 若存在则直接传入到目标方法的入参中. 若不存在则将抛出异常.
     *  4. 若 Handler 没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的 value 值中不包含 key, 则
     *      会通过反射来创建 POJO 类型的参数, 传入为目标方法的参数
     *  5. SpringMVC 会把 key 和 POJO 类型的对象保存到 implicitModel 中, 进而会保存到 request 中.
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("update : " + user);

        return SUCCESS;
    }


}
