package com.homework.service.impl;

import com.homework.dao.DepartmentDao;
import com.homework.model.Department;
import com.homework.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;
    @Transactional
    public List<Department> getDepartments() {
        return departmentDao.getDepartments();
    }
    @Transactional
    public Department getDepartmentId(int departmentId) {
        return departmentDao.getDepartmentId(departmentId);
    }
    @Transactional
    public Department getDepartmentByName(String departmentName) {
        return departmentDao.getDepartmentByName(departmentName);
    }
    @Transactional
    public void add(Department department) {
        departmentDao.add(department);
    }
    @Transactional
    public void update(Department department) {
        departmentDao.update(department);
    }
    @Transactional
    public void delete(int departmentId) {
        Department department =departmentDao.getDepartmentId(departmentId);
        departmentDao.delete(department);
    }
    @Transactional
    public List<Department> endListByFuzzyName(String departmentName) {
        return departmentDao.getListByFuzzyName(departmentName);
    }
}
