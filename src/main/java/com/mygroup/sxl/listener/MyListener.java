package com.mygroup.sxl.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: shenxl
 * @Date: 2019/9/23 16:23
 * @Version 1.0
 * @description：${description}
 */
public class MyListener implements SpringApplicationRunListener , Ordered {


    public MyListener(SpringApplication application,String ...agrs){

    }

    @Override
    public void starting() {
        System.out.println("自己的监听器starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("contextPrepared");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded");

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("started");

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("running");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("failed");

    }

    @Override
    public int getOrder() {
        return -1;
    }
}
