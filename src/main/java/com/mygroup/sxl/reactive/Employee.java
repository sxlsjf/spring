package com.mygroup.sxl.reactive;

/**
 * @Author: shenxl
 * @Date: 2019/11/21 11:45
 * @Version 1.0
 * @description：${description}
 */
public class Employee {


    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Employee(int i, String s) {
        this.id = i;
        this.name = s;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "[id="+id+",name="+name+"]";
    }
}
