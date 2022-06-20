package com.homework.service;

import com.homework.model.Employee;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/31
 */
public interface SalaryService {
    void update(Employee employee);

    void add(Employee employee);

    void delete(int id);
}
