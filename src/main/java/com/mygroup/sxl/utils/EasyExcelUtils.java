package com.mygroup.sxl.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.mygroup.sxl.enums.ExcelPageEnum;
import com.mygroup.sxl.service.JPAPageQueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class EasyExcelUtils extends EasyExcel {

    /**
     * @param writerBuilder
     * @param totalCount       数据总数
     * @param pageQueryService
     * @description: 分页查询、分批次写数据，避免导出大数据量时OOM
     * auto close resource
     */
    public static void pageWrite(ExcelWriterBuilder writerBuilder, long totalCount, int pageSize, int sheetMaxRow,
                                 JPAPageQueryService pageQueryService) {

        ExcelWriter writer = writerBuilder.build();
        // compute page count, sheet count
        long pageCount = (totalCount - 1) / pageSize + 1;
        long sheetCount = (totalCount - 1) / sheetMaxRow + 1;
        int currentPage = 0;

        // page write data
        WriteSheet sheet = null;

        for (int i = 0; i < sheetCount; i++) {
            sheet = EasyExcel.writerSheet(i, "sheet" + i).build();

            for (int j = 0; j < (sheetMaxRow / pageSize); j++) {
                // must use ++currentPage, mybatis-plus page query current page start 1
                writer.write(pageQueryService.getData(++currentPage, pageSize), sheet,getTable());
                if (currentPage >= pageCount) {
                    break;
                }
            }
        }
        // close source
        writer.finish();
    }

    public static<T> void pageWrite(OutputStream outputStream, Class<T> classHead, Boolean isXls, long totalCount, JPAPageQueryService pageQueryService) {
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(outputStream,classHead).excelType(ExcelTypeEnum.XLSX);
        int pageSize = ExcelPageEnum.XLSX.getPageSize();
        int sheetMaxRow = ExcelPageEnum.XLSX.getSheetMaxRow();
        if (isXls) {
            pageSize = ExcelPageEnum.XLS.getPageSize();
            sheetMaxRow = ExcelPageEnum.XLS.getSheetMaxRow();
        }
        pageWrite(excelWriterBuilder, totalCount, pageSize, sheetMaxRow, pageQueryService);

    }

    public static<T> void pageWrite(HttpServletResponse response,Class<T> classHead, String excelName, long totalCount, JPAPageQueryService pageQueryService) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        OutputStream outputStream=response.getOutputStream();
        pageWrite(outputStream, classHead,false, totalCount, pageQueryService);
     //   outputStream.flush();
    }

    public static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        // 设置表头样式
        Font headFont = new Font();
        // 字体是否加粗
        headFont.setBold(true);
        // 字体大小
        headFont.setFontHeightInPoints((short)12);
        // 字体
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        // 背景色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE);


        // 设置表格主体样式
        Font contentFont = new Font();
        contentFont.setBold(true);
        contentFont.setFontHeightInPoints((short)12);
        contentFont.setFontName("黑体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.GREEN);
        return tableStyle;
    }

    public static WriteTable getTable(){
        WriteTable table=new WriteTable();
        List<List<String>> headList = new ArrayList<>();
        // 第 n 行 的表头
        List<String> headTitle0 = new ArrayList<>();
        List<String> headTitle1 = new ArrayList<>();
        List<String> headTitle2 = new ArrayList<>();
        headTitle0.add("最顶部-1");
        headTitle0.add("标题1");
        headTitle1.add("最顶部-1");
        headTitle1.add("标题2");
        headTitle2.add("最顶部-1");
        headTitle2.add("标题3");

        headList.add(headTitle0);
        headList.add(headTitle1);
        headList.add(headTitle2);
        table.setHead(headList);
        return table;
    }
    public static<T> void exportExcel(List<T> list, String title, String sheetName, Class<T> pojoClass, String fileName, HttpServletResponse response){
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    private static<T> void defaultExport(List<T> list, Class<T> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public static<T> void exportExcel(List<T> list, String title, String sheetName, Class<T> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response){
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response){
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath,Integer titleRows,Integer headerRows, Class<T> pojoClass){
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass){
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }
}
    /*   List<List<String>> headList = new ArrayList<>();
        // 第 n 行 的表头
        List<String> headTitle0 = new ArrayList<String>();
        List<String> headTitle1 = new ArrayList<String>();
        List<String> headTitle2 = new ArrayList<String>();
        headTitle0.add("最顶部-1");
        headTitle0.add("标题1");
        headTitle1.add("最顶部-1");
        headTitle1.add("标题2");
        headTitle2.add("最顶部-1");
        headTitle2.add("标题3");

        headList.add(headTitle0);
        headList.add(headTitle1);
        headList.add(headTitle2);
        table.setHead(headList);*/