package com.mygroup.sxl.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author: shenxl
 * @Date: 2019/10/28 15:40
 * @Version 1.0
 * @description：增值服务
 */
@Data
public class AddServiceInfo {

    /**
     * 	String(20)	增值服务名称 (数组形式，可以有多个增值服务)	C
     */
    @JSONField(name = "Name")
    private String name;
    /**
     *String(30)	增值服务值	C
     */
    @JSONField(name = "Value")
    private String value	;
    /**
     *String(30)	客户标识（选填）	O
     */
    @JSONField(name = "CustomerID")
    private String customerID	;
}
