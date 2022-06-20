package com.homework.service;

import com.homework.model.Department;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
public interface DepartmentService {
    List<Department> getDepartments();

    Department getDepartmentId(int departmentId);

    Department getDepartmentByName(String departmentName);

    void add(Department department);

    void update(Department department);

    void delete(int departmentId);

    List<Department> endListByFuzzyName(String departmentName);
}
