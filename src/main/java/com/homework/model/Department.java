package com.homework.model;

import javax.persistence.*;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Entity
@Table(name = "department")
public class Department {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
