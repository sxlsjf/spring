package com.mygroup.sxl.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: shenxl
 * @Date: 2019/10/28 15:53
 * @Version 1.0
 * @description：电子面单实体
 */
@Data
public class LabelRequest {

    /**
     *String（50）	ERP系统、电商平台等系统或平台类型用户的会员ID或店铺账号等唯一性标识，用于区分其用户	O
     */
    @JSONField(name = "MemberID")
    private String memberID	;
    /**
     *String(50)	电子面单客户号，需要下载《快递鸟电子面单客户号参数对照表.xlsx》，参考对应字段传值	O
     */
    @JSONField(name = "CustomerName")
    private String customerName	;
    /**
     *String(30)	O
     */
    @JSONField(name = "CustomerPwd")
    private String customerPwd	;
    /**
     *String(30)	O
     */
    @JSONField(name = "SendSite")
    private String sendSite	;
    /**
     *String(30)	C
     */
    @JSONField(name = "SendStaff")
    private String sendStaff	;
    /**
     *String	C
     */
    @JSONField(name = "MonthCode")
    private String monthCode	;
    /**
     *String(500)	商家自定义区域	C
     */
    @JSONField(name = "CustomArea")
    private String customArea	;
    /**
     *String(30)	发货仓编码	O
     */
    @JSONField(name = "WareHouseID")
    private String wareHouseID	;
    /**
     *Int(1)	运输方式 1- 陆运 2- 空运 不填默认为1	O
     */
    @JSONField(name = "TransType")
    private String transType	;
    /**
     *String(10)	快递公司编码 详细编码参考《2019快递鸟接口支持快递公司编码.xlsx》	R
     */
    @JSONField(name = "ShipperCode")
    private String shipperCode	;
    /**
     *String(30)	快递单号(仅宅急送可用)	O
     */
    @JSONField(name = "LogisticCode")
    private String logisticCode	;
    /**
     *String(50)	第三方订单号 (ShipperCode为JD且ExpType为1时必填)	C
     */
    @JSONField(name = "ThrOrderCode")
    private String thrOrderCode	;
    /**
     *String(30)	订单编号(自定义，不可重复)	R
     */
    @JSONField(name = "OrderCode")
    private String orderCode	;
    /**
     *Int(1)	邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付(仅SF支持)	R
     */
    @JSONField(name = "PayType")
    private String payType	;
    /**
     *String(2)	快递类型：1-标准快件 ,详细快递类型参考《快递公司快递业务类型.xlsx》	R
     */
    @JSONField(name = "ExpType")
    private String expType	;
    /**
     *Int(1)	是否要求签回单 1- 要求 0-不要求	O
     */
    @JSONField(name = "IsReturnSignBill")
    private String isReturnSignBill	;
    /**
     *String(20)	签回单操作要求(如：签名、盖章、身份证复印件等)	O
     */
    @JSONField(name = "OperateRequire")
    private String operateRequire	;
    /**
     *Double(5)	快递运费	O
     */
    @JSONField(name = "Cost")
    private String cost	 ;
    /**
     *Double(5)	其他费用	O
     */
    @JSONField(name = "OtherCost")
    private String otherCost	;

    /**
     *收件人信息
     */
    @JSONField(name = "Receiver")
    private Receiver receiver;

    /**
     *发件人信息
     */
    @JSONField(name = "Sender")
    private Sender sender;

    /**
     *	Int(1)	是否通知快递员上门揽件 0- 通知 1- 不通知 不填则默认为1	O
     */
    @JSONField(name = "IsNotice")
    private Integer isNotice;
    /**
     *Date	上门取货时间段:"yyyy-MM-dd HH:mm:ss"格式化，本文中所有时间格式相同	O
     */
    @JSONField(name = "StartDate")
    private Date startDate;
    /**
     *Date	O
     */
    @JSONField(name = "EndDate")
    private Date endDate	;
    /**
     *Double(10,3)	包裹总重量kg 当为快运的订单时必填，不填时快递鸟将根据各个快运公司要求传对应的默认值	C
     */
    @JSONField(name = "Weight")
    private Double weight	;
    /**
     *Int(2)	包裹数(最多支持30件) 一个包裹对应一个运单号，如果是大于1个包裹，返回则按照子母件的方式返回母运单号和子运单号	R
     */
    @JSONField(name = "Quantity")
    private Integer quantity	;;
    /**
     *Double(20,3)	包裹总体积m3 当为快运的订单时必填，不填时快递鸟将根据各个快运公司要求传对应的默认值	C
     */
    @JSONField(name = "Volume")
    private Double volume	;
    /**
     *String(60)	备注	O
     */
    @JSONField(name = "Remark")
    private String remark	;


    /**
     *增值服务
     */
    @JSONField(name = "AddService")
    private AddServiceInfo addService	;

    /**
     *增值服务
     */
    @JSONField(name = "Commodity")
    private List<CommodityInfo> commodity	;

    /**
     *String(1)	返回电子面单模板：0-不需要；1-需要	O
     */
    @JSONField(name = "IsReturnPrintTemplate")
    private String isReturnPrintTemplate;
    /**
     *Int(1)	是否订阅短信：0-不需要；1-需要	O
     */
    @JSONField(name = "IsSendMessage")
    private Integer isSendMessage;
    /**
     *String(10)	模板规格(默认的模板无需传值，非默认模板传对应模板尺寸)	O
     */
    @JSONField(name = "TemplateSize")
    private String templateSize;
    /**
     *Int(2)	包装类型(快运字段)默认为0； 0- 纸 1- 纤 2- 木 3- 托膜 4- 木托 99-其他	C
     */
    @JSONField(name = "PackingType")
    private Integer packingType	;
    /**
     *Int(1)	送货方式(快运字段)默认为0； 0- 自提 1- 送货上门（不含上楼） 2- 送货上楼	C
     */
    @JSONField(name = "DeliveryMethod")
    private Integer deliveryMethod;
}
