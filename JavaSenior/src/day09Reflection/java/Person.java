package day09Reflection.java;

/*
 * @author Harold
 * @Date 2020/4/13
 * @Description :
 */
public class Person {

    private String name ;
    public int age ;

    public Person() {
        System.out.println("Person()");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
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

    public void show() {
        System.out.println("Hello Dear" );
//        System.out.println(showNation("中国"));
    }

    private String showNation(String nation) {
        return "我的国国籍是" + nation ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
