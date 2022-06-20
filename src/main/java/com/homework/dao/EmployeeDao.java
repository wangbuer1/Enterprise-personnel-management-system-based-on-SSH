package com.homework.dao;

import com.homework.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Repository("employeeDao")
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Employee employee){
        sessionFactory.getCurrentSession().save(employee);
    }

    public List<Employee> getEmployees() {
        //采用关联查询，如果不用关联查询，将会从服务器映射两次，比较容易出问题
        String hql = "select e from Employee e inner join e.department d";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public Employee getEmployeeByName(String employeeName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where employeeName = ?");
        query.setParameter(0,employeeName);
        return (Employee) query.uniqueResult();
    }

    public void update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class,employeeId);
    }

    public void delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public Employee getEmployeeByCode(String employeeCode) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where employeeCode = ?");
        query.setParameter(0,employeeCode);
        return (Employee) query.uniqueResult();
    }

    public List<Employee> getListByCritiria(Employee employee) {
        String hql = "from Employee e where e.employeeName like ? and e.employeeCode like ?";
        if(employee.getDepartment().getId()!=null && employee.getDepartment().getId()!=0){
            hql = hql + "and e.department.id = ?";
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,"%"+employee.getEmployeeName()+"%");
        query.setString(1,"%"+employee.getEmployeeCode()+"%");
        if(employee.getDepartment().getId()!=null && employee.getDepartment().getId()!=0){
            query.setParameter(2,employee.getDepartment().getId());
        }
        return query.list();
    }

    public List<Employee> getListByDepartmentId(int departmentId) {
        String hql = "from Employee where department.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,departmentId);
        return query.list();
    }

    public List<Employee> getEmployeesAndSalary() {
        String hql = "select e from Employee e inner join e.department d inner join e.salary s";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Employee> getEmployeesAndSalaryByCritiria(Employee employee) {
        String hql = "select e from Employee e inner join e.department d inner join e.salary s where e.employeeName like ? and e.employeeCode like ?";
        if(employee.getDepartment().getId()!=null && employee.getDepartment().getId()!=0){
            hql = hql + "and e.department.id = ?";
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,"%"+employee.getEmployeeName()+"%");
        query.setString(1,"%"+employee.getEmployeeCode()+"%");
        if(employee.getDepartment().getId()!=null && employee.getDepartment().getId()!=0){
            query.setParameter(2,employee.getDepartment().getId());
        }
        return query.list();
    }

    public Employee getEmployeesAndSalaryByEmployeeId(Integer id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class,id);
    }
}
