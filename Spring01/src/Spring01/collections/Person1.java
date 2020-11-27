package Spring01.collections;

import Spring01.bean.Car;

import java.util.List;
import java.util.Map;

/**
 * @author Harold
 * @Date 2020/5/25
 * @Description : Spring applicationContext.xml 中 不同bean之间的引用关系
 */
public class Person1 {

    private String name;
    private int age;

    private Map<String, Car> cars;

    public Person1() {

    }

    public Person1(String name, int age, Map<String, Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}

