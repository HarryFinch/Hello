package Spring01.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description : 静态工厂方法
 *  1、直接调用某一个类的静态方法，就可以返回 Bean 的实例
 */
public class StaticCarFactory {

    public static Map<String,Car> cars = new HashMap<String , Car>();

    static {
        cars.put("audi", new Car("audi",30000));
        cars.put("baoma", new Car("audi",20000));
    }

    //静态工厂方法
    public static Car getCar(String name){
        return cars.get(name);
    }

}
