package com.mygroup.sxl.service.impl;

import com.mygroup.sxl.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 11:30
 * @Version 1.0
 * @description：${description}
 */
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public void sayHello(String say) {

        System.out.println("hello"+say);

    }

    @Override
    public void eat(String apple) {
        System.out.println("eat"+apple);
    }
}
