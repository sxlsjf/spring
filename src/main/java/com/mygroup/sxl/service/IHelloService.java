package com.mygroup.sxl.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 11:29
 * @Version 1.0
 * @description：${description}
 */
public interface IHelloService {
    void sayHello(String say);

    void eat(String apple);

    void exportExcel(HttpServletResponse response);
}
