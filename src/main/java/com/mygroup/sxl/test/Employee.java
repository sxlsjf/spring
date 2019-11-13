package com.mygroup.sxl.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 11:17
 * @Version 1.0
 * @description：${description}
 */
@Data
@XStreamAlias("employee")
public class Employee {

    @XStreamAlias("name")
    private String name;
    @XStreamAlias("age")
    private Integer age;
    @XStreamAlias("sex")
    private char sex;
    @XStreamAlias("salary")
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", salary=" + salary +
                '}';
    }
}
