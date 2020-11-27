package day10Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * @author Harold
 * @Date 2020/4/23
 * @Description : 动态代理
 *
 */
interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe myself";
    }

    @Override
    public void eat(String food) {
        System.out.println("SuperMan do not  eat");
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("通用方法一");
    }

    public void method2() {
        System.out.println("通用方法二");
    }
}


/*
 * 动态代理需要解决的问题
 *  1、如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 *  2、通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
 */

class ProxyFactory {
    /*
     * @Description : 调用此方法，返回代理类的对象
     * @Param : obj 被代理类的对象
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;//赋值时也需要使用被代理的对象进行赋值

    //通过代理类对象调用某方法时，就会自动调用如下的方法，invoke()
    //将被代理类要执行的方法功能声明在invoke方法中

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();

        //代理类对象调用的方法
        Object invoke = method.invoke(obj, args);
        humanUtil.method2();
        //返回值作为invoke()方法的返回值
        return invoke;
    }
}

public class ProxyDemo {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //通过代理类对象调用方法时，会自动调用被代理类中的同名方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("Hot");

        System.out.println("------动态构建代理类--------");

        NikeClothFactory ncf = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(ncf);
        proxyClothFactory.produceCloth();


    }

}
