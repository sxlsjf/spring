package com.mygroup.sxl.controller;

import com.mygroup.sxl.service.IHelloService;
import com.mygroup.sxl.service.impl.HelloServiceImpl;
import com.mygroup.sxl.strategy.AsinfoVip;
import com.mygroup.sxl.strategy.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 14:19
 * @Version 1.0
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private IHelloService iHelloService;

    @Autowired
    private StrategyFactory strategyFactory;

    @RequestMapping("/index")
    public String say(){


        int compute = strategyFactory.getInstance(AsinfoVip.class).compute(10);

        System.out.println("策略工厂："+compute);

        iHelloService.eat("apple");
        System.out.println(Thread.currentThread().getName());
        // 使用示例
        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  int i=10/0;
            return "result";
        }).whenComplete((result, e) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result + " " + e);
        }).exceptionally((e) -> {
            System.out.println("exception " + e);
            return "exception";
        });

        return "成功";
    }

}
