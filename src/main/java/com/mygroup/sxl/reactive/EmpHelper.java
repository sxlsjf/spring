package com.mygroup.sxl.reactive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shenxl
 * @Date: 2019/11/21 11:44
 * @Version 1.0
 * @description：${description}
 */
public class EmpHelper {


    public static List<Employee> getEmps() {

        Employee e1 = new Employee(1, "Pankaj");
        Employee e2 = new Employee(2, "David");
        Employee e3 = new Employee(3, "Lisa");
        Employee e4 = new Employee(4, "Ram");
        Employee e5 = new Employee(5, "Anupam");

        List<Employee> emps = new ArrayList<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        emps.add(e4);
        emps.add(e5);

        return emps;
    }
}
