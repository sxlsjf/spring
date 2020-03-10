package com.mygroup.sxl.io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author shenxl
 * @date 2020/1/29 23:37
 * @description
 */
public class IOStream {

    public static void main(String[] args) throws Exception{
        String str="what";
        File txt=new File("D:/log1.txt");
        if(!txt.exists()){
            txt.createNewFile();
        }
        byte bytes[];
        bytes=str.getBytes();
        int b=bytes.length;   //是字节的长度，不是字符串的长度
        FileOutputStream fos=new FileOutputStream(txt);
        fos.write(bytes,0,b);
        fos.close();

        float a=1.0f;
        double c=1.00d;
        System.out.println(a==c);

    }
}
