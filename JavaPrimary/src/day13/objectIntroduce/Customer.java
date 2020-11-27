package day13.objectIntroduce;

public class Customer {

    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写的原则：比较两个对象的实体内容（name、age）是否相同
/*
    public boolean equals(Object obj) {
        if (this == obj) {
            return true ;
        }
        if (obj instanceof  Customer) {
            Customer cust = (Customer)obj ;
            return this.age == cust.age && this.name.equals(cust.name);
        }
        return false;
    }
 */
}

