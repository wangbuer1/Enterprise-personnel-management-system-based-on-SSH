package com.homework.model;

import javax.persistence.*;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Entity
@Table(name="salary")
public class Salary {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private Integer basis;//基本工资
    private Integer bonus;//奖金
    private Integer allowance;//津贴
    private Integer subsidy;//补贴
    private Integer total;//总工资

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasis() {
        return basis;
    }

    public void setBasis(Integer basis) {
        this.basis = basis;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getAllowance() {
        return allowance;
    }

    public void setAllowance(Integer allowance) {
        this.allowance = allowance;
    }

    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getTotal() {
        return subsidy+basis+allowance+bonus;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
