package com.mygroup.sxl.reactive;

import java.util.function.Function;

/**
 * @Author: shenxl
 * @Date: 2019/11/21 11:47
 * @Version 1.0
 * @description：${description}
 */
public class MyProcessor /*extends SubmissionPublisher<Freelancer> implements Flow.Processor<Employee, Freelancer> */{

   /* private Flow.Subscription subscription;
    private Function<Employee,Freelancer> function;

    public MyProcessor(Function<Employee,Freelancer> function) {
        super();
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Employee emp) {
        submit((Freelancer) function.apply(emp));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }*/

}
