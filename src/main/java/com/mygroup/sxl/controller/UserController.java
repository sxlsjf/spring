package com.mygroup.sxl.controller;

import ch.qos.logback.core.util.FileUtil;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteTable;
import com.mygroup.sxl.mode.Person;
import com.mygroup.sxl.mode.User;
import com.mygroup.sxl.service.IHelloService;
import com.mygroup.sxl.utils.EasyExcelUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Author: shenxl
 * @Date: 2019/9/20 14:19
 * @Version 1.0
 * @description：${description}
 */
@Controller
public class UserController {


    @Autowired
    private IHelloService iHelloService;

    @PostMapping("/recruit/list")
    @ResponseBody
    @ApiOperation(value = "拉新列表导出", tags = {"Excel导出-接口"})
    public void download(HttpServletResponse response) throws Exception {

        EasyExcelUtils.pageWrite(response,User.class,"sheet1",20
                , (currentPage,pageSize)-> getList());

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman

      //  out.flush();
        //EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(getList());
       // ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream(), User.class);
    }

    private List<User> getList(){
        List<User> list=new ArrayList<>();

        User user=new User();
        user.setAge(14);
        user.setName("xiaoming");
        user.setPassword("1234ss56");
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);list.add(user);

        return list;
    }


    @RequestMapping("export")
    public void export(HttpServletResponse response){

        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞","1",new Date());
        Person person2 = new Person("娜美","2", new Date());
        Person person3 = new Person("索隆","1", new Date());
        Person person4 = new Person("小狸猫","1", new Date());
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        //导出操作
        EasyExcelUtils.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);
    }

    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "F:\\海贼王.xls";
        //解析excel，
        List<Person> personList = FileUtil.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
    }


    @RequestMapping("export")
    public void export(HttpServletResponse response) {
        Map<String, Object> params = new HashMap<>();
        Workbook workbook = bigExcel(1, params, null, new ExportParams("海贼王", "海贼王"), new Page<>());
        ExcelExportUtil.closeExportBigExcel();
        downLoadExcel("海贼王.xls", response, workbook);
    }


    private Workbook bigExcel(int pageNum, Map<String, Object> params, Workbook workbook, ExportParams exportParams, Page<SysUser> page) {
        //分页查询数据
        page.setCurrent(pageNum);
        page.setSize(1000);
        page.setCondition(params);
        page = this.getData(sysUserService.queryPage(page));
        List<SysUser> users = FastJsonUtils.toList(FastJsonUtils.toJSONString(page.getRecords()), SysUser.class);

        workbook = ExcelExportUtil.exportBigExcel(exportParams, SysUser.class, users);

        //如果不是最后一页，递归查询
        if (page.getPages() > pageNum) {
            bigExcel(pageNum + 1, params, workbook, exportParams, page);
        }
        return workbook;
    }

    private void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("content-Type", "application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
