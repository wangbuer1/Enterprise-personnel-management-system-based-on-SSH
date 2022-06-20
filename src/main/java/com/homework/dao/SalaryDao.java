package com.homework.dao;

import com.homework.model.Salary;
import com.homework.service.SalaryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/31
 */
@Repository
public class SalaryDao {
    @Autowired
    private SessionFactory sessionFactory;
    public Salary getSalaryById(Integer id) {
       return (Salary) sessionFactory.getCurrentSession().get(Salary.class,id);
    }

    public void add(Salary salary) {
        sessionFactory.getCurrentSession().save(salary);
    }

    public void delete(Salary salary){
        sessionFactory.getCurrentSession().delete(salary);
    }
}
