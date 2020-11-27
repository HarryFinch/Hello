package Spring01.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description : 自定义的FactoryBean
 *  1、实现Spring提供的 FactoryBean<>接口
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        return new Car(brand, 300000);
    }

    /*
     * @Description : 返回 bean 的类型
     * @Param :
     */
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
