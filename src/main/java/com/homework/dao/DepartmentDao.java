package com.homework.dao;

import com.homework.model.Department;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Repository
public class DepartmentDao {
    @Autowired
    private SessionFactory sessionFactory;
    public List<Department> getDepartments() {
        return sessionFactory.getCurrentSession().createQuery("from Department").list();
    }

    public Department getDepartmentId(int departmentId) {
        return (Department) sessionFactory.getCurrentSession().get(Department.class,departmentId);
    }

    public Department getDepartmentByName(String departmentName) {
        return (Department) sessionFactory.getCurrentSession()
                .createQuery("from Department where departmentName = ?")
                .setParameter(0,departmentName)
                .uniqueResult();
    }

    public void add(Department department) {
        sessionFactory.getCurrentSession().save(department);
    }

    public void update(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    public void delete(Department department) {
        sessionFactory.getCurrentSession().delete(department);
    }

    public List<Department> getListByFuzzyName(String departmentName) {
        String hql = "from Department where departmentName like ?";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,"%"+departmentName+"%");
        return query.list();
    }
}
