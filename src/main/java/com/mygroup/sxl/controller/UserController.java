package com.mygroup.sxl.controller;

import com.mygroup.sxl.service.IHelloService;
import com.mygroup.sxl.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 14:19
 * @Version 1.0
 * @description：${description}
 */
@RestController
public class UserController {

    @Autowired
    private IHelloService iHelloService;

    @RequestMapping("/index")
    public String say(){

        iHelloService.eat("apple");

        return "成功";
    }

}
