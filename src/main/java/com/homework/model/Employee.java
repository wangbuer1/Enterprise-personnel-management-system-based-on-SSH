package com.homework.model;

import javax.persistence.*;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Entity
@Table(name="employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String employeeCode;
    private String employeeName;
    private Integer age;
    @JoinColumn(name = "departmentId")
    @ManyToOne
    private Department department;

    @JoinColumn(name = "salaryId")
    @OneToOne
    private Salary salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
