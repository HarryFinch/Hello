package Spring01.collections;

import Spring01.bean.Car;

import java.util.List;

/**
 * @author Harold
 * @Date 2020/5/25
 * @Description : Spring applicationContext.xml 中 不同bean之间的引用关系
 */
public class Person {

    private String name;
    private int age;

    private List<Car> cars;

    public Person() {

    }

    public Person(String name, int age, List<Car> cars) {
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}

