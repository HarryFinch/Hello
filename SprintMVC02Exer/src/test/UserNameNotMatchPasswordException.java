package test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Harold
 * @Date 2020/7/22
 * @Description :
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户名或密码错误")
public class UserNameNotMatchPasswordException extends RuntimeException{

    private static final long serialVersionUID = 1L;



}
