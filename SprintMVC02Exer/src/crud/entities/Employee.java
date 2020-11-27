package crud.entities;

import java.util.Date;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Past;

public class Employee {

    private Integer id;

    @NotEmpty
    private String lastName;

    @Email
    private String email;

    //1 male, 0 female
    private Integer gender;

    private Department department;

    /* @DateTimeFormat 注解可以讲指定格式的字符串转化为日期，通过pattern属性指定字符串格式*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /*
     *  @NumberFormat 注解可以讲指定格式的字符串转化为数字，通过pattern属性指定字符串格式
     *  @Past 注解可以保证输入的最晚日期是当前日期
     */
    @NumberFormat(pattern = "#,###,###.#")
    @Past
    private Float salary;


    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender,
                    Department department) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
