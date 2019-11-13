package com.mygroup.sxl.spi;

import com.mygroup.sxl.service.IHelloService;

import java.util.ServiceLoader;

/**
 * @Author: shenxl
 * @Date: 2019/11/7 14:47
 * @Version 1.0
 * @description：${description}
 */
public class JavaSpiTest {


    public static void main(String[] args) {
        // 加载IService下所有的服务
        ServiceLoader<IHelloService> serviceLoader = ServiceLoader.load(IHelloService.class);

        serviceLoader.forEach((t)-> t.sayHello(":delta"));



    }


}
