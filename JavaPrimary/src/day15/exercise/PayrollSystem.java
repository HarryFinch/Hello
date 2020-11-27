package day15.exercise;

import java.util.Calendar;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employee = new Employee[3];
        //获取当前月份
        Calendar calendar = Calendar.getInstance();
        //Calendar.MONTH 一月对应的数值为零，纯程序员
        int month = calendar.get(Calendar.MONTH) +1 ;

        employee[0] = new SalariedEmployee(1000, "A", 123, new MyDate(1999, 6, 9));
        System.out.println(employee[0].toString());

        employee[1] = new HourlyEmployee(10.0, 10.0, "B", 124 ,new MyDate(1999, 6, 10));
        System.out.println(employee[1].toString());

    }
}
