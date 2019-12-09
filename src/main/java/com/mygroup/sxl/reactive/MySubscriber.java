package com.mygroup.sxl.reactive;




/**
 * @Author: shenxl
 * @Date: 2019/11/21 11:29
 * @Version 1.0
 * @description：${description}
 */
public class MySubscriber/* implements Flow.Subscriber<Employee>*/ {

  /*  //发布订阅协调者
    private Flow.Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed/订阅完成");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher请求一个数据
        System.out.println("onSubscribe requested 1 item/一次请求一个数据");
    }

    @Override
    public void onNext(Employee item) {
        System.out.println("Processing Employee/处理 "+item);
        counter++;
        this.subscription.request(1);
    }

//	@Override
//	public void onNext(Employee item) {
//		System.out.println("Processing Employee "+item);
//		counter++;
//		if(counter==3) {
//			this.subscription.cancel();
//			return;
//		}
//		this.subscription.request(1);
//	}

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done");
    }

    public int getCounter() {
        return counter;
    }*/

}