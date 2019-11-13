package com.mygroup.sxl.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Author: shenxl
 * @Date: 2019/11/8 10:41
 * @Version 1.0
 * @description：${description}
 */
public class XmlUtils {

    /**
     * XML转对象
     * @param clazz 对象类
     * @param xml xml字符串
     * @param <T> T
     * @return
     */
    public static <T> T parseFromXml(Class<T> clazz, String xml) {
        //创建解析XML对象
        XStream xStream = new XStream(new DomDriver());
        //处理注解
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
                T t = (T)xStream.fromXML(xml);
        return t;
    }

    /**
     * 对象转xml
     * @param obj 对象
     * @return
     */
    public static String toXml(Object obj) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }
}
