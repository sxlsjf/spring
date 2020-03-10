package com.mygroup.sxl.xml;

import jdk.internal.util.xml.impl.XMLWriter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @author shenxl
 * @date 2020/1/27 23:22
 * @description
 */
public class XmlFile {

    @Test
    public void testAdd() {

/*
       // 1：创建dom对象：
        Document dom=new DOMDocument();

      //  2：创建根节点：
        Element root=dom.addElement("AmazonEnvelope");
        root.addNamespace("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        root.addNamespace("xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");

      //  3：为根结点设置属性：
        //root.setAttributes();

      //  4：由根结点构建dom树：

     //   1）创建子节点：
        Element header=root.addElement("Header");
        Element documentVersion = header.addElement("DocumentVersion");
        Element merchantIdentifier = header.addElement("MerchantIdentifier");
        Element messageType=root.addElement("MessageType");
        messageType.addText("OrderFulfillment");
        Element message=root.addElement("Message");
        Element messageID=message.addElement("MessageID");
        messageID.addText("1");
        Element orderFulfillment = message.addElement("OrderFulfillment");
        Element merchantOrderID = orderFulfillment.addElement("MerchantOrderID");
        Element merchantFulfillmentID = orderFulfillment.addElement("MerchantFulfillmentID");


        //  2）设置结点属性：
        element.setAttribute(属性名，属性值);

     //   3）设置结点文本内容：
        element.setText(文本）;

      //          5：构建dom树完毕，把dom对象输出到xml文件：

      //          1）创建XMLWriter：
         XMLWriter writer=new XMLWriter（new FileOutputStream(xml_file),format）；//format参数可选，可以传一个format对象指定输出格式

     //   2）设置输出到文档时是否转义：
         writer.setEscapeText(false);//true转义

     //   3）通过writer把dom对象写到xml文档中：
         wtiter.write(dom);
    }*/
    }
}
