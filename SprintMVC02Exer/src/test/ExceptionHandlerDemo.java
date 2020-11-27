package test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Harold
 * @Date 2020/7/22
 * @Description :
 */

@ControllerAdvice
public class ExceptionHandlerDemo {

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handlerArithmeticException(Exception e) {
        System.out.println("There is exception(s)");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e);
        return mv;
    }

}
