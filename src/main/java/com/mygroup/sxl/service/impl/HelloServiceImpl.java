package com.mygroup.sxl.service.impl;

import com.mygroup.sxl.service.IHelloService;
import com.mygroup.sxl.utils.EasyExcelUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

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

    @Override
    public void exportExcel(HttpServletResponse response) {
       // EasyExcelUtils.pageWrite(response.getOutputStream(),);
    }
}
