package day10.exercise;

public class Girl {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String i) {
        name = i;
    }

    public String getName() {
        return name;
    }

    public void marry(Boy boy) {
        System.out.println("HasbandName : " + boy.getName());
        System.out.println("HasbandAge  : " + boy.getAge());
    }

    public void compare(Girl girl) {

    }
}
