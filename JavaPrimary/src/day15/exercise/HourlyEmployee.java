package day15.exercise;

public class HourlyEmployee extends Employee {

    private double wage;
    private double hour;

    public HourlyEmployee(double wage, double hour,String name, int number, MyDate birthday) {
        super(name , number  ,birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earning() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "HourlyEmployee{" +
                "wage=" + wage +
                ", hour=" + hour +
                "salary = " +  wage * hour +
                '}';
    }
}
