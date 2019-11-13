package com.mygroup.sxl.proxy;

import com.mygroup.sxl.service.IHelloService;
import com.mygroup.sxl.service.impl.HelloServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 12:28
 * @Version 1.0
 * @description：${description}
 */
public class MyInvocationHandler implements InvocationHandler {

    public Object target;


    public MyInvocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        System.out.println("执行方法之前");
        result = method.invoke(target, args);
        System.out.println("执行方法之后");
        return result;
    }

    public static void main(String[] args) throws Exception{

        IHelloService target=new HelloServiceImpl();
        MyInvocationHandler appleProxy = new MyInvocationHandler(target);

        IHelloService proxy= (IHelloService) Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{IHelloService.class},appleProxy);

        proxy.sayHello("shenxl");
        proxy.eat("apple");

        genertor();

    }

    private static void genertor() throws Exception{
        byte[] bytes= ProxyGenerator.generateProxyClass("HelloService$proxy",new Class[]{IHelloService.class});
        Files.write(new File("D:\\IdeaProjects\\Spring-boot-Learn-Projects\\sxl\\target\\HelloService$proxy.class").toPath(),bytes);
    }

}
