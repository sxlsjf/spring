package com.mygroup.sxl.reactive;


/**
 * @Author: shenxl
 * @Date: 2019/11/21 11:47
 * @Version 1.0
 * @description：${description}
 */
public class MyReactiveAppWithProcessor {


   /* public static void main(String[] args) throws InterruptedException {
        // Create End Publisher
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        // Create Processor
        MyProcessor transformProcessor = new MyProcessor(s -> {
            return new Freelancer(s.getId(), s.getId() + 100, s.getName());
        });

        //Create End Subscriber
        MyFreelancerSubscriber subs = new MyFreelancerSubscriber();

        //Create chain of publisher, processor and subscriber
        publisher.subscribe(transformProcessor); // publisher to processor
        transformProcessor.subscribe(subs); // processor to subscriber

        List<Employee> emps = EmpHelper.getEmps();

        // Publish items
        System.out.println("Publishing Items to Subscriber");
        emps.stream().forEach(i -> publisher.submit(i));

        // Logic to wait for messages processing to finish
        while (emps.size() != subs.getCounter()) {
            Thread.sleep(10);
        }

        // Closing publishers
        publisher.close();
        transformProcessor.close();

        System.out.println("Exiting the app");
    }*/
}
