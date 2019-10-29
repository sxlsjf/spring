package com.mygroup.sxl.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author: shenxl
 * @Date: 2019/10/28 15:27
 * @Version 1.0
 * @description：商品信息
 */
@Data
public class CommodityInfo {

    /**
     * String(100)	商品名称	R
     * */
    @JSONField(name ="GoodsName")
    private String goodsName;
    /**
     * String(100)	商品编码	O
     * */
    @JSONField(name ="GoodsName")
    private String goodsCode;
    /**
     * Int(5)	商品数量	O
     * */
    @JSONField(name ="Goodsquantity")
    private Integer goodsquantity;
    /**
     * Double(10)	商品价格	O
     * */
    @JSONField(name ="GoodsPrice")
    private Double	goodsPrice ;
    /**
     * 	Double(10,3)	商品重量kg	O
     * */
    @JSONField(name ="GoodsWeight")
    private Double goodsWeight;
    /**
     * String(50)	商品描述	O
     * */
    @JSONField(name ="GoodsDesc")
    private String goodsDesc;
    /**
     * Double(15,3)	商品体积m3	O
     * */
    @JSONField(name ="GoodsVol")
    private Double	goodsVol ;
}
