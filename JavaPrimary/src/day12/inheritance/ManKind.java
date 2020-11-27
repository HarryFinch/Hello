package day12.inheritance;

public class ManKind {
    private int sex;
    private int salary;

    public void manOrWoman() {
        if (sex == 1) {
            System.out.println("Man");
        }else if (sex == 0) {
            System.out.println("Woman");
        }
    }

    public void employeed() {
       if (salary == 0) {
           System.out.println("No Job");
       }else if (salary != 0 ) {
           System.out.println("Working");
       }
    }

    public int getSex(){
        return sex ;
    }

    public int getSalary() {
        return salary ;
    }
}
