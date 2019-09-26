package com.mygroup.sxl.test;

import java.math.BigDecimal;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 11:17
 * @Version 1.0
 * @description：${description}
 */
public class Employee {

    private String name;
    private Integer age;
    private char sex;

    private BigDecimal salary;

    public Employee() {

    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;

    }
    public Employee(String name, Integer age, char sex, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
