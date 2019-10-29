package com.mygroup.sxl.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author: shenxl
 * @Date: 2019/10/28 15:43
 * @Version 1.0
 * @description：收件人信息
 */
@Data
public class Receiver {

    /**
     * String(30)	收件人公司	O
     */
    @JSONField(name = "Company")
    private String company	;
    /**
     *String(30)	收件人	R
     */
    @JSONField(name = "Name")
    private String name	;
    /**
     *String(20)	电话与手机，必填一个	R
     */
    @JSONField(name = "Tel")
    private String tel	;
    /**
     *String(20)
     */
    @JSONField(name = "Mobile")
    private String mobile	;
    /**
     *String(10)	收件人邮编	c
     */
    @JSONField(name = "PostCode")
    private String postCode	;
    /**
     *String(20)	收件省 (如广东省，不要缺少“省”；如是直辖市，请直接传北京、上海等； 如是自治区，请直接传广西壮族自治区等)	R
     */
    @JSONField(name = "ProvinceName")
    private String provinceName	;
    /**
     *String（20）	收件市(如深圳市，不要缺少“市”； 如果是市辖区，请直接传北京市、上海市等)	R
     */
    @JSONField(name = "CityName")
    private String cityName	;
    /**
     *String（20）	收件区/县(如福田区，不要缺少“区”或“县”)	R
     */
    @JSONField(name = "ExpAreaName")
    private String expAreaName	;
    /**
     *String(100)	收件人详细地址	R
     */
    @JSONField(name = "Address")
    private String address	;
}
