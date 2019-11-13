package com.mygroup.sxl.lambda;

import com.alibaba.fastjson.JSONObject;
import com.mygroup.sxl.test.Employee;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.core.io.Resource;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 10:55
 * @Version 1.0
 * @description：${description}
 */
public class test {


    public static void test1() {

        Consumer<String> consumer = (x)-> System.out.println(x);

        consumer.accept("hahaha");
        PrintStream ps = System.out;
        Consumer<String> son =  ps::println;
        son.accept("what!");
    }


    public static void test2() {
        Employee emp = new Employee("Yan", 24, '男', new BigDecimal("1452"));
        Supplier<String> sup = emp::getName;

       /* Supplier<String> sup2 = new Supplier<String>() {
            @Override
            public String get() {
               return emp.getName();
            }
        };*/

//     与上面语句功能相同    Supplier sup2 = ()->emp.getName();
        String s = sup.get();
        System.out.println(s);
    }


    //类 :: 静态方法
    public static void test3() {
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com2 = Integer::compare;
    }


    //类 :: 实例方法名


    public static void test4() {
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);

        //限制条件：只有当(x, y) -> x.equals(y) 第一个参数x作为参数的调用者，第二个参数y为方法参数时，才可以使用这种方式
        //ClassName::method
        BiPredicate<String, String> bp2 = String::equals;
    }


    //构造器引用 ClassName::new

    public static void test5() {
        Supplier<Employee> sup1 = () -> new Employee();
        Employee employee = sup1.get();//接口sup1 调用方法 get()  get方法被() -> new Employee() 重写

        //调用无参构造器  因为 需要和Supplier get方法中的入参和返回值类型保持一致
        Supplier<Employee> sup2 = Employee::new;


        //如需使用其他构造器则
        BiFunction<String, Integer, Employee> bg1 = (x, y) -> new Employee(x, y);
        System.out.println(bg1.apply("Yan", 23));

        //调用有参构造器，取决于BiFunction中的apply方法的入参
        BiFunction<String, Integer, Employee> bg2 = Employee::new;

    }


    //数组引用 type[] :: new

    public static void test6() {
        Function<Integer, String[]> fun1 = (x) -> new String[x];
        String[] apply = fun1.apply(10);
        System.out.println(apply);

        Function<Integer, String[]> fun2 = String[]::new;

    }

    public static void main(String[] args) {


        List<Employee> list=new ArrayList<>();

        Employee employee1=new Employee();
        employee1.setSalary(new BigDecimal("100"));

        Employee employee2=new Employee();
        employee1.setSalary(new BigDecimal("110"));

        Employee employee3=new Employee();
        employee1.setSalary(new BigDecimal("120"));

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        BigDecimal[] total = {new BigDecimal("0")};


        System.out.println(total);






    }
}
