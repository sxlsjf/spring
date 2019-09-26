package com.mygroup.sxl.test;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 16:13
 * @Version 1.0
 * @description
 */
public class Out {


    public  Service getService( int x){
        int y=100;
        return new Service() {
            int z=100;
            @Override
            public int add() {
                return z=x+y+z;
            }

        };
    }
    public static void main(String[] args) {
        Out out=new Out();
        Service e=out.getService(100);
        System.out.println(e.add());
        System.out.println();

    }

}
