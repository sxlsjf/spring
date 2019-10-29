package com.mygroup.sxl.test;
import java.util.Date;
import com.mygroup.sxl.domain.Sender;
import com.mygroup.sxl.domain.Receiver;
import com.mygroup.sxl.domain.AddServiceInfo;
import com.mygroup.sxl.domain.CommodityInfo;
import java.util.ArrayList;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.mygroup.sxl.domain.LabelRequest;

import java.io.FileInputStream;

/**
 * @Author: shenxl
 * @Date: 2019/10/25 16:14
 * @Version 1.0
 * @description：${description}
 */
public class HtmlToPdf {

    private final static String DEST = "C:\\Users\\sxlhy\\Desktop\\123.pdf";	//生成pdf的路径
    private final static String SRC = "C:\\Users\\sxlhy\\Desktop\\myhtml.html";	//html文件路径
    public static final String FONT = "/font/simhei.ttf";	//本地字体路径（百度下载）

    public static void main(String[] args) {
        try {
           /* HtmlToPdf html = new HtmlToPdf();
            html.tomPdf(SRC, DEST);*/
       //     tomPdf(SRC, DEST);

            LabelRequest labelRequest=new LabelRequest();
            labelRequest.setMemberID("");
            labelRequest.setCustomerName("");
            labelRequest.setCustomerPwd("");
            labelRequest.setSendSite("");
            labelRequest.setSendStaff("");
            labelRequest.setMonthCode("");
            labelRequest.setCustomArea("");
            labelRequest.setWareHouseID("");
            labelRequest.setTransType("");
            labelRequest.setShipperCode("");
            labelRequest.setLogisticCode("");
            labelRequest.setThrOrderCode("");
            labelRequest.setOrderCode("");
            labelRequest.setPayType("");
            labelRequest.setExpType("");
            labelRequest.setIsReturnSignBill("");
            labelRequest.setOperateRequire("");
            labelRequest.setCost("");
            labelRequest.setOtherCost("");
            labelRequest.setReceiver(new Receiver());
            labelRequest.setSender(new Sender());
            labelRequest.setIsNotice(0);
            labelRequest.setStartDate(new Date());
            labelRequest.setEndDate(new Date());
            labelRequest.setWeight(0.0D);
            labelRequest.setQuantity(0);
            labelRequest.setVolume(0.0D);
            labelRequest.setRemark("hahah");
            labelRequest.setAddService(new AddServiceInfo());
            labelRequest.setCommodity(new ArrayList<CommodityInfo>());
            labelRequest.setIsReturnPrintTemplate("");
            labelRequest.setIsSendMessage(0);
            labelRequest.setTemplateSize("");
            labelRequest.setPackingType(0);
            labelRequest.setDeliveryMethod(0);


            KdGoldAPIUtils.sendPostToKdGold(labelRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * HTML转换成pdf
     * @param html html文件路径
     * @param DEST 生成pdf的路径
     * @throws Exception
     */
    public static void tomPdf(String html, String DEST) throws Exception {
        ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addFont(FONT);
        props.setFontProvider(defaultFontProvider);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(283.5F, 283.5F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream(html), pdf, props);
        document.close();
        pdf.close();

    }

}
