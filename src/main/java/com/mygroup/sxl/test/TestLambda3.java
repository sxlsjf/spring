package com.mygroup.sxl.test;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 10:56
 * @Version 1.0
 * @description：${description}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java内置四大核心函数式接口
 * <p>
 * 1.Consumer<T>消费型接口 无返回值  void accept（T t）
 * 2.Supplier<T>供给型接口 T get();
 * 3.Function<T>函数型接口 R apply(T t)
 * 4.Predicate<T>断言型接口 用于做判断操作 boolean test(T t)
 */
public class TestLambda3 {


    //Consumer<T>
    public static void test1() {
        happy(10.15, (x) -> System.out.println(x));

    }

    //happy
    public static void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    //Supplier<T> 产生指定个数的随机数,存入集合

    public static void test2() {
        System.out.println(getNumber(10, () ->  Math.random() * 100-1));
    }

    public static List<Double> getNumber(int num, Supplier<Double> sup) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }


    //Predicate<T>
    public  static void test3() {
        List<String> strList = Arrays.asList("Mike", "Lee", "Yan");
        //使用时设置条件
        List<String> list = filterStr(strList, x -> x.length() > 3);
        list.forEach(System.out::print);
    }

    //将满足条件的字符串 存入集合中
    public static List<String> filterStr(List<String> str, Predicate<String> pre) {
        List<String> list = new ArrayList<>();

        for (String s : str) {
            if (pre.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        test2();
        test3();
    }
}
