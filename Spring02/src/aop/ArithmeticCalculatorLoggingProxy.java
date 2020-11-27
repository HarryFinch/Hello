package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description :
 *      利用动态代理，实现添加日志信息，方法更简洁，
 *      日志信息统一管理，方便维护和修改，但是需要理解动态代理
 */
public class ArithmeticCalculatorLoggingProxy {

    //被代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }


    public ArithmeticCalculator getLogging() {
        ArithmeticCalculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();

        //代理类对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};

         /*
         * @Description :当调用代理类对象中的方法时，该执行的代码
         * @Param : proxy 正在返回的代理对象，一般情况下在invoke方法中都不是使用该对象
         * @Param : method  正在被调用的方法
         * @Param : args  调用方法时，传入的参数
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法内不会调用proxy对象的方法的，因为一旦调用proxy对象的方法，
                // proxy就会调用invoke方法，如此进入死循环
//                System.out.println(proxy.toString());
                String methodName = method.getName();

                //日志
                System.out.println("The method " + methodName + " begin with " + Arrays.asList(args));

                //执行方法
                Object result = method.invoke(target, args);

                System.out.println("The method " + methodName + " end with " + result);

                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);

        return proxy;
    }
}
