package com.mygroup.sxl.xml;

import com.mygroup.sxl.test.Employee;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @Author: shenxl
 * @Date: 2019/11/8 10:31
 * @Version 1.0
 * @description：${description}
 */
@Data
@XStreamAlias("user")
public class User {


    @XStreamAlias("username")
    private String userName;

    @XStreamAlias("email")
    private String email;

    @XStreamAlias("employees")
    private List<Employee> employees;

    public User() {}

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", employees=" + employees +
                '}';
    }
}
