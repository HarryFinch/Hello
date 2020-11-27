package day16;
/*
    如何自定义异常类：
    1、自定义异常类继承现有的异常结构
    2、提供全局常量：serialVersionUID
    3、提供重载的构造器
 */
public class CustomException extends RuntimeException {

    static final long serialVersionUID = -703489719074576693L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }
}
