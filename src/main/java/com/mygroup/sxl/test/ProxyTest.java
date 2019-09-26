package com.mygroup.sxl.test;

import com.mygroup.sxl.service.IHelloService;
import com.mygroup.sxl.service.impl.HelloServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 11:31
 * @Version 1.0
 * @description：${description}
 */
public class ProxyTest {

    public static void main(String[] args) {
        //InvocationHandler Object proxy, Method method, Object[] args

        final IHelloService target=new  HelloServiceImpl();

        IHelloService iHelloService= (IHelloService) Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{IHelloService.class},(proxy, method, arg1)->{
            System.out.println("处理前");
            Object obj=method.invoke(target,arg1);
            System.out.println("处理后");
            return obj;
        });

        iHelloService.sayHello("world");

    }
}
