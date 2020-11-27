package day12.inheritance;

public class SuperExtends extends SuperKeyWord {

    String major;
    int id;

    public SuperExtends(String major) {
        this.major = major ;
    }

    public void eat() {
        System.out.println("student eating ");
    }

    public void study() {
        System.out.println("studying");
    }

    public void show() {
        System.out.println("name : " + name  + "age : " + age );
        System.out.println("id : " + id ); //调用子类属性id
        System.out.println("id : " + super.id ); //调用父类类属性id

    }
}
