package com.mygroup.sxl.mode;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import lombok.Data;

@Data
public class User {


    @ColumnWidth(20)
   // @ExcelIgnore
    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ColumnWidth(20)
    @ExcelProperty(value = "密码", index = 1)
    private String password;

    @ColumnWidth(20)
    @ExcelProperty(value = "年龄", index = 2)
    private Integer age;

}
