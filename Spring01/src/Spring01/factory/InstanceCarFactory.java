package Spring01.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 *  1、实例工厂方法  ： 实例工厂的方法，即需要创建工厂本身，
 *      再调用工厂的实例方法，返回 bean 的实例
 */
public class InstanceCarFactory {

   private Map<String ,Car> cars = null;

   public InstanceCarFactory() {
       cars = new HashMap<>();
       cars.put("audi", new Car("audi",300000));
       cars.put("Ford", new Car("Ford",400000));
   }

   public Car getCars(String brand) {
       return cars.get(brand);
   }

}
