package day13.exercise;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Person person = new Person() ;
        Person person1 = new Student() ;
        Person person2 = new Graduate() ;
        System.out.println(person.getInfo());
        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());
        main.method(new Person());
        main.method(new Student());
        main.method(new Graduate());
/*        main.method(person);
        main.method(person1);
        main.method(person2);*/
    }

    public void method(Person e){
        if (e instanceof Person) {
            System.out.println("Person");
        }else if (e instanceof Student){
            System.out.println("Student");
        }else if (e instanceof Graduate){
            System.out.println("Graduate");
        }
    }
}
