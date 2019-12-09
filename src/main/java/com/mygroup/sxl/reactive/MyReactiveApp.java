package com.mygroup.sxl.reactive;

import java.util.List;


/**
 * @Author: shenxl
 * @Date: 2019/11/21 11:47
 * @Version 1.0
 * @description：${description}
 */
public class MyReactiveApp {
    public static void main(String args[]) throws InterruptedException {

    /*    // Create Publisher创建发布者
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        // Register Subscriber注册订阅者
        MySubscriber subs = new MySubscriber();
        publisher.subscribe(subs);

        List<Employee> emps = EmpHelper.getEmps();

        // Publish items发布消息
        System.out.println("Publishing Items to Subscriber");
        emps.stream().forEach(i -> publisher.submit(i));

        // logic to wait till processing of all messages are over
        //while (emps.size() != subs.getCounter()  || !publisher.isSubscribed(subs)) {
        Thread.sleep(1000);
        //}
        // close the Publisher
        publisher.close();

        System.out.println("Exiting the app");*/

    }
}
