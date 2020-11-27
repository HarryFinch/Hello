package day15.exercise;

public class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(double monthlySalary , String name, int number, MyDate birthday) {
        super(name , number , birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earning() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SalariedEmployee{" +
                "monthlySalary=" + getMonthlySalary() +
                '}';
    }

}
