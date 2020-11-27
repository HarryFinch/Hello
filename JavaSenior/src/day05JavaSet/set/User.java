package day05JavaSet.set;


import java.util.Objects;

/**
 * @Author: Harold
 * @Date: 2020/3/23 14:44
 * @Description:
 */
public class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("---------------------");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int compare = this.name.compareTo(user.name);
            if(compare != 0) {
                return compare;
            }else {
                return Integer.compare(this.age , user.age ) ;
            }
        } else {
            throw new RuntimeException("Object Wrong");
        }
    }
}
