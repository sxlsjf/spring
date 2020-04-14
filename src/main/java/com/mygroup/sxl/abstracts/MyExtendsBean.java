package com.mygroup.sxl.abstracts;

/**
 * @author shenxl
 * @date 2020/3/16 16:48
 * @description
 */
public class MyExtendsBean extends MyAbstract {


    @Override
    public void hello() {
        //super.hello();
        System.out.println("我是子类");
    }

    public static void main(String[] args) {
        MyExtendsBean bean=new MyExtendsBean();
        bean.hello();


        String x = "string";
        String y = "string";
        String z = new String("string");

        System.out.println(x==y); // true,引用相同
        System.out.println(x==z); // false,==:string比较引用,开辟了新的堆内存空间,所以false
        System.out.println(x.equals(y)); // true,equals:string:比较值,相同
        System.out.println(x.equals(z)); // true,equals:string比较值,相同
    }
}
