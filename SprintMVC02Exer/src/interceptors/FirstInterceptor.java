package interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Harold
 * @Date 2020/7/22
 * @Description :
 */
public class FirstInterceptor implements HandlerInterceptor {


    /*
     * 该方法在目标方法之前调用，如返回值为true的话，则继续调用后续的拦截器和目标方法；
     * 如返回值为false，则不会在调用后续的拦截器和目标方法
     * 可以做权限限定，日志、事务等
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor preHandle");
        return true;
    }

    /*
     * 调用目标方法之后，渲染视图之前
     *
     * 可以用来对请求域中的属性或视图做出修改
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor postHandle");
    }

    /*
     * 渲染视图之后调用
     * 用来释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor afterCompletion");
    }
}
