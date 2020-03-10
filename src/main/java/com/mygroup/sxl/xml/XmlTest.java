package com.mygroup.sxl.xml;

import com.mygroup.sxl.test.Employee;
import com.thoughtworks.xstream.XStream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shenxl
 * @Date: 2019/11/8 10:35
 * @Version 1.0
 * @description：${description}
 */
public class XmlTest {

    public static void main(String[] args) {

     /*   //Java对象转XML
        User user = new User("lanweihong", "lwhhhp@gmail.com");

        //创建解析XML对象
        XStream xStream = new XStream();
        //设置别名, 默认会输出全路径
        xStream.alias("User", User.class);
        //转为xml
        String xml = xStream.toXML(user);
        System.out.println(xml);*/



     /*//XML转Java对象
        XStream xStream = new XStream();
        xStream.alias("User", User.class);
        String xml = "<User>\n" +
                "  <userName>lanweihong</userName>\n" +
                "  <email>lwhhhp@gmail.com</email>\n" +
                "</User>";
        //转对象
        User user = (User)xStream.fromXML(xml);
        System.out.println(user.toString());*/


     //XStream默认不会读取这个注解，因为，我们需要声明XStream的注解来源：
        User user = new User("lanweihong", "lwhhhp@gmail.com");

        user.setNameSpace("http://www.w3.org/2001/XMLSchema-instance");

        List<Employee> list=new ArrayList<>();
       // list.add(new Employee("zhangsan",20,'男', BigDecimal.ONE));

        user.setEmployees(list);
        XStream xStream = new XStream();
        //声明XStream注解来源
        xStream.processAnnotations(User.class);
        String xml = xStream.toXML(user);
        System.out.println(xml);

        String xm="<user>\n" +
                "  <username>lanweihong</username>\n" +
                "  <email>lwhhhp@gmail.com</email>\n" +
                "  <employees>\n" +
                "    <employee>\n" +
                "      <name>zhangsan</name>\n" +
                "      <age>20</age>\n" +
                "      <sex>男</sex>\n" +
                "      <salary>1</salary>\n" +
                "    </employee>\n" +
                "  </employees>\n" +
                "</user>";
        User user1=XmlUtils.parseFromXml(User.class,xm);

        System.out.println(user1);

        System.out.println(XmlUtils.toXml(user1));;

    }
}
