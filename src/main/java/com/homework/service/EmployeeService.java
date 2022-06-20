package com.homework.service;

import com.homework.model.Employee;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployeeByName(String employeeName);

    void add(Employee employee);

    void update(Employee employee);

    void delete(int employeeId);

    Employee getEmployeeById(Employee employee);

    Employee getEmployeeByCode(String employeeCode);

    List<Employee> getListByCritiria(Employee employee);

    List<Employee> getEmployeeByDepartmentId(int departmentId);

    List<Employee> getEmployeesAndSalary();

    List<Employee> getEmployeesAndSalaryByCritiria(Employee employee);
}
