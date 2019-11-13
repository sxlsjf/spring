package com.mygroup.sxl.lambda;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 10:56
 * @Version 1.0
 * @description：${description}
 */

import com.mygroup.sxl.test.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        list.forEach(System.out::println);
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

        //String name = "John";
        List<Employee> list=null;
        Employee e1=new Employee();
        e1.setName("zhangsan");
        Employee e2=new Employee();
        e1.setName("lisi");
        Employee e3=new Employee();
        e1.setName("wanger");
        Employee e4=null;
       /* list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);*/
        Optional<List<Employee>> employeeList = Optional.ofNullable(list);


  /*      Optional<String> longest = list.stream()
                .map(nam -> nam.getName())
                .findFirst();
                 employeeList.map(Collection::stream).filter();
        employeeList.map(Stream::of).filter();
*/

        Optional<String> longest=Optional.ofNullable(null);

        String result2=longest.orElse("");

        System.out.println(result2);

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        //求集合元素只和
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求和
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最大值
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最小值
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //做逻辑
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result3 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

        Integer result4=null;

        Optional.ofNullable(result4).ifPresent(System.out::println);

        //Optional.ofNullable(result4).orElseThrow(RuntimeException::new);

       // Optional.of(result4).orElseGet()

        Optional.of(e1).ifPresent((employee)->employee.setName("wangwu"));
        Optional.ofNullable(result).ifPresent(System.out::println);

        Optional.ofNullable(result).orElseGet(null);
//        Optional.ofNullable(result4).orElseThrow(RuntimeException::new);


        System.out.println(e1.getName()+"11111");

        System.out.println("===============================");
        /*int i=-3;

        System.out.println(i<<1);
        System.out.println(i<<2);
        System.out.println(i<<3);
        System.out.println(i>>>1);
        System.out.println(i>>>2);
        System.out.println(i>>>3);*/


        List<Integer> integers=new ArrayList<>();

        for(int i=0;i<10000;i++){
            integers.add(i);
        }
        List<Integer> integer=new ArrayList<>();

        integers.parallelStream().forEach(integer::add);

        System.out.println("integer="+integer.size());
/*
        Long s2=System.currentTimeMillis();
        BlockingQueue<Integer> integers2=new ArrayBlockingQueue<>(10000);
        integers.parallelStream().forEach((t)->{
            integers2.add(t);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("ArrayBlockingQueue:"+ integers2.size()+":"+(System.currentTimeMillis() - s2));

        Long s3=System.currentTimeMillis();
        List<Integer> integers4=Collections.synchronizedList(new ArrayList<>());
        integers.parallelStream().forEach((t)->{
            integers4.add(t);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("synchronizedList:"+(System.currentTimeMillis()-s3));

        Long s1=System.currentTimeMillis();
        Lock  lock=new ReentrantLock();
        List<Integer> integers3=new ArrayList<>();
        integers.parallelStream().forEach((t)->{
            lock.lock();
            integers3.add(t);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        System.out.println("ArrayListparallelStream:"+(System.currentTimeMillis()-s1));


        Long s5=System.currentTimeMillis();
        List<Integer> integers5=new ArrayList<>();
        integers.stream().forEach((t)-> {
            integers5.add(t);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("ArrayListStream:"+(System.currentTimeMillis()-s5));*/

/*
        System.out.println(integers5.size());

        System.out.println(integers4.size());*/

        List<Employee> list2=new ArrayList<>();

       /* for (int i = 0; i < 1000; i++) {
            Employee employee=new Employee();
            employee.setAge(20);
            employee.setName("第："+i);
            list2.add(employee);

        }*/

        List<String> list3=new ArrayList<>();

       // list2.parallelStream().map(Employee::getName).forEachOrdered(list3::add);
       // System.out.println(list3.size());

        list3=list2.parallelStream().map(Employee::getName).collect(Collectors.toList());

        //list2.parallelStream().map(Employee::getName).collect(Collectors.groupingBy());

        list3.forEach(System.out::println);
        System.out.println(list3.size());

    }
}


