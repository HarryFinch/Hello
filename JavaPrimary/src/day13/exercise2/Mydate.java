package day13.exercise2;

import java.util.Objects;

public class Mydate {
    private int day;
    private int month;
    private int year;

    public Mydate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return this.day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return this.month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }
    public boolean equals(Object object) {

        if (this == object) {
            return true ;
        }

        if (object instanceof Mydate){
            Mydate date = (Mydate)object ;
            return this.day == date.day &&
                    this.month == date.month &&
                    this.year == date.year ;
        }
        return false ;
    }
/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mydate mydate = (Mydate) o;
        return day == mydate.day &&
                month == mydate.month &&
                year == mydate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }*/
}
