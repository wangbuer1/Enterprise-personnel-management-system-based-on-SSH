package com.homework.service.impl;

import com.homework.dao.EmployeeDao;
import com.homework.model.Employee;
import com.homework.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Transactional
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeDao.getEmployees();
        return employees;
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.getEmployeeByName(employeeName);
    }

    @Transactional
    public void add(Employee employee) {
        employeeDao.save(employee);
    }

    @Transactional
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Transactional
    public void delete(int employeeId) {
        Employee employee = employeeDao.getEmployeeById(employeeId);
        employeeDao.delete(employee);
    }

    @Transactional
    public Employee getEmployeeById(Employee employee) {
        return employeeDao.getEmployeeById(employee.getId());
    }

    @Transactional
    public Employee getEmployeeByCode(String employeeCode) {
        return employeeDao.getEmployeeByCode(employeeCode);
    }

    @Transactional
    public List<Employee> getListByCritiria(Employee employee) {
        return employeeDao.getListByCritiria(employee);
    }
    @Transactional
    public List<Employee> getEmployeeByDepartmentId(int departmentId) {
        return employeeDao.getListByDepartmentId(departmentId);
    }
    @Transactional
    public List<Employee> getEmployeesAndSalary() {
        return employeeDao.getEmployeesAndSalary();
    }
    @Transactional
    public List<Employee> getEmployeesAndSalaryByCritiria(Employee employee) {
        return employeeDao.getEmployeesAndSalaryByCritiria(employee);
    }
}
