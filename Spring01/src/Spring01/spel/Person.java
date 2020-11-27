package Spring01.spel;

/**
 * @author Harold
 * @Date 2020/5/27
 * @Description :
 */
public class Person {

    private String name;
    private Car car;

    //引用address 的 city 属性
    private String city;

    /*
    根据车的价格确定info
    车的价格大于等于30w是为金领
    否则为白领
     */

    private String info;

    public Person() {
    }

    public Person(String name, Car car, String city, String info) {
        this.name = name;
        this.car = car;
        this.city = city;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
