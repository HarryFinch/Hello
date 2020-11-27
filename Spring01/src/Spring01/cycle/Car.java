package Spring01.cycle;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :  spring bean 生命周期
 */
public class Car {

    private String brand;

    public Car() {
        System.out.println("car constructor");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("set brand ... ");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init ....");
    }

    public void destroy(){
        System.out.println("destroy ... ");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
