package day10.exercise;

public class Boy {
    private String name ;
    private int age ;

    public Boy(String name , int age){
        this.name = name ;
        this.age  = age  ;
    }

    public void setName(String i) {
        name = i ;
    }

    public String getName() {
        return name ;
    }

    public void setAge(int i ) {
        age = i ;
    }

    public int getAge() {
        return age ;
    }

    public void marry(Girl girl){
        System.out.println("Wife : " + girl.getName());
    }

    public void shout(){

    }
}
