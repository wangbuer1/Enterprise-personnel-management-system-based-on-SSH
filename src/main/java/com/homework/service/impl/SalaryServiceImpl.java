package com.homework.service.impl;

import com.homework.dao.EmployeeDao;
import com.homework.dao.SalaryDao;
import com.homework.model.Employee;
import com.homework.model.Salary;
import com.homework.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/31
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Transactional
    public void update(Employee employee) {
        Salary salary = salaryDao.getSalaryById(employee.getSalary().getId());
        salary.setAllowance(employee.getSalary().getAllowance());
        salary.setBasis(employee.getSalary().getBasis());
        salary.setBonus(employee.getSalary().getBonus());
        salary.setSubsidy(employee.getSalary().getSubsidy());
        salary.setTotal(employee.getSalary().getTotal());
    }
    @Transactional
    public void add(Employee employee) {
        Employee employee1 =employeeDao.getEmployeesAndSalaryByEmployeeId(employee.getId());
        if(employee1.getSalary()!=null){
            employee1.getSalary().setAllowance(employee.getSalary().getAllowance());
            employee1.getSalary().setBasis(employee.getSalary().getBasis());
            employee1.getSalary().setBonus(employee.getSalary().getBonus());
            employee1.getSalary().setSubsidy(employee.getSalary().getSubsidy());
            employee1.getSalary().setTotal(employee.getSalary().getTotal());
            return;
        }
        Salary salary = new Salary();
        salary.setAllowance(employee.getSalary().getAllowance());
        salary.setBasis(employee.getSalary().getBasis());
        salary.setBonus(employee.getSalary().getBonus());
        salary.setSubsidy(employee.getSalary().getSubsidy());
        salary.setTotal(employee.getSalary().getTotal());
        salaryDao.add(salary);
        employee1.setSalary(salary);
    }

    @Transactional
    public void delete(int id) {
        Employee employee = employeeDao.getEmployeeById(id);
        Salary salary  = salaryDao.getSalaryById(employee.getSalary().getId());
        employee.setSalary(null);
        salaryDao.delete(salary);
    }
}
