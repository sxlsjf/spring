package com.mygroup.sxl.xml2json;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: shenxl
 * @Date: 2019/12/6 14:25
 * @Version 1.0
 * @description：${description}
 */
public class Xml2 {



    /**
     * 测试函数
     * @param args
     */
    public static void main(String args[]){
        Xml2 w=new Xml2();
        String xml="<?xml version=\"1.0\"?>\n" +
                "<ListMatchingProductsResponse xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\">\n" +
                "<ListMatchingProductsResult>\n" +
                "  <Products xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\"\n" +
                "            xmlns:ns2=\"http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd\">\n" +
                "    <Product>\n" +
                "      <Identifiers>\n" +
                "        <MarketplaceASIN>\n" +
                "          <MarketplaceId>ATVPDKIKX0DER</MarketplaceId>\n" +
                "          <ASIN>059035342X</ASIN>\n" +
                "        </MarketplaceASIN>\n" +
                "      </Identifiers>\n" +
                "      <AttributeSets>\n" +
                "        <ns2:ItemAttributes xml:lang=\"en-US\">\n" +
                "          <ns2:Author>Rowling, J.K.</ns2:Author>\n" +
                "          <ns2:Binding>Paperback</ns2:Binding>\n" +
                "          <ns2:Brand>Scholastic Press</ns2:Brand>\n" +
                "          <ns2:Creator Role=\"Illustrator\">GrandPré, Mary</ns2:Creator>\n" +
                "          <ns2:Edition>1st</ns2:Edition>\n" +
                "          <ns2:Feature>Recommended Age: 9 years and up</ns2:Feature>\n" +
                "          <ns2:ItemDimensions>\n" +
                "            <ns2:Height Units=\"inches\">0.80</ns2:Height>\n" +
                "            <ns2:Length Units=\"inches\">7.50</ns2:Length>\n" +
                "            <ns2:Width Units=\"inches\">5.20</ns2:Width>\n" +
                "            <ns2:Weight Units=\"pounds\">0.50</ns2:Weight>\n" +
                "          </ns2:ItemDimensions>\n" +
                "          <ns2:IsAutographed>false</ns2:IsAutographed>\n" +
                "          <ns2:IsMemorabilia>false</ns2:IsMemorabilia>\n" +
                "          <ns2:Label>Scholastic Paperbacks</ns2:Label>\n" +
                "          <ns2:Languages>\n" +
                "            <ns2:Language>\n" +
                "              <ns2:Name>english</ns2:Name>\n" +
                "              <ns2:Type>Unknown</ns2:Type>\n" +
                "            </ns2:Language>\n" +
                "            <ns2:Language>\n" +
                "              <ns2:Name>english</ns2:Name>\n" +
                "              <ns2:Type>Original Language</ns2:Type>\n" +
                "            </ns2:Language>\n" +
                "            <ns2:Language>\n" +
                "              <ns2:Name>english</ns2:Name>\n" +
                "              <ns2:Type>Published</ns2:Type>\n" +
                "            </ns2:Language>\n" +
                "          </ns2:Languages>\n" +
                "          <ns2:ListPrice>\n" +
                "            <ns2:Amount>10.99</ns2:Amount>\n" +
                "            <ns2:CurrencyCode>USD</ns2:CurrencyCode>\n" +
                "          </ns2:ListPrice>\n" +
                "          <ns2:Manufacturer>Scholastic Paperbacks</ns2:Manufacturer>\n" +
                "          <ns2:NumberOfItems>1</ns2:NumberOfItems>\n" +
                "          <ns2:NumberOfPages>320</ns2:NumberOfPages>\n" +
                "          <ns2:PackageDimensions>\n" +
                "            <ns2:Height Units=\"inches\">1.00</ns2:Height>\n" +
                "            <ns2:Length Units=\"inches\">7.50</ns2:Length>\n" +
                "            <ns2:Width Units=\"inches\">5.20</ns2:Width>\n" +
                "            <ns2:Weight Units=\"pounds\">0.50</ns2:Weight>\n" +
                "          </ns2:PackageDimensions>\n" +
                "          <ns2:PackageQuantity>1</ns2:PackageQuantity>\n" +
                "          <ns2:PartNumber>9780590353427</ns2:PartNumber>\n" +
                "          <ns2:ProductGroup>Book</ns2:ProductGroup>\n" +
                "          <ns2:ProductTypeName>ABIS_BOOK</ns2:ProductTypeName>\n" +
                "          <ns2:PublicationDate>1999-10-01</ns2:PublicationDate>\n" +
                "          <ns2:Publisher>Scholastic Paperbacks</ns2:Publisher>\n" +
                "          <ns2:ReleaseDate>1999-09-08</ns2:ReleaseDate>\n" +
                "          <ns2:SmallImage>\n" +
                "            <ns2:URL>http://ecx.images-amazon.com/images/I/51MU5VilKpL._SL75_.jpg</ns2:URL>\n" +
                "            <ns2:Height Units=\"pixels\">75</ns2:Height>\n" +
                "            <ns2:Width Units=\"pixels\">51</ns2:Width>\n" +
                "          </ns2:SmallImage>\n" +
                "          <ns2:Studio>Scholastic Paperbacks</ns2:Studio>\n" +
                "          <ns2:Title>Harry Potter and the Sorcerer's Stone (Book 1)</ns2:Title>\n" +
                "        </ns2:ItemAttributes>\n" +
                "      </AttributeSets>\n" +
                "      <Relationships/>\n" +
                "      <SalesRankings>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>book_display_on_website</ProductCategoryId>\n" +
                "          <Rank>401</Rank>\n" +
                "        </SalesRank>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>15356791</ProductCategoryId>\n" +
                "          <Rank>5</Rank>\n" +
                "        </SalesRank>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>3153</ProductCategoryId>\n" +
                "          <Rank>8</Rank>\n" +
                "        </SalesRank>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>17468</ProductCategoryId>\n" +
                "          <Rank>16</Rank>\n" +
                "        </SalesRank>\n" +
                "      </SalesRankings>\n" +
                "    </Product>\n" +
                "  </Products>\n" +
                "</ListMatchingProductsResult>\n" +
                "<ResponseMetadata>\n" +
                "  <RequestId>3b805a12-689a-4367-ba86-EXAMPLE91c0b</RequestId>\n" +
                "</ResponseMetadata>\n" +
                "</ListMatchingProductsResponse>";
        System.out.println(w.getWeather(xml));
    }

    /**
     * 通过dom4j对服务器端返回的XML进行解析
     * @param xml 用户输入的城市名称
     * @return 符串 用,分割
     */
    public static String getWeather(String xml) {
        Document document=null;
        SAXReader reader = new SAXReader();

        Map map=new HashMap();
        map.put("","http://mws.amazonservices.com/schema/Products/2011-10-01");

        map.put("ns2", "http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd");
        reader.getDocumentFactory().setXPathNamespaceURIs(map);


        try {
            InputStream is =  new ByteArrayInputStream(xml.getBytes());
            document=reader.read(is);//将输入流转化为document
            String t=document.asXML();
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Node> nodes = document.selectNodes("//ListMatchingProductsResponse/ListMatchingProductsResult");
        Node node=document.selectSingleNode("//ListMatchingProductsResponse");
        node.selectNodes("");
        System.out.println(node.getName());
        System.out.println(nodes.get(0).getName());
        System.out.println(nodes.size());
      //  nodes.get(0).selectNodes()
       // int size=nodes.get(0).selectNodes("/ListMatchingProductsResult").get(0).selectNodes("/Products").size();

                //selectNodes("/ListMatchingProductsResult").size();//.get(0).selectNodes("/Product").get(0).selectNodes("/AttributeSets").get(0).selectNodes("/ns2:ItemAttributes").get(0).selectNodes("/ns2:Author");
       System.out.println(nodes.size());
   //     System.out.println(nodes.size());


        for (Iterator it = nodes.iterator(); it.hasNext();) {
            Element elm = (Element) it.next();

            String text=elm.getText();
            System.out.println(text);
//            System.out.println(node);
        }
        return "";
    }

    @Test
    public void testXml(){

        String xml="<?xml version=\"1.0\"?>\n" +
                "<ListMatchingProductsResponse xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\">\n" +
                "<ListMatchingProductsResult>\n" +
                "  <Products xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\"\n" +
                "            xmlns:ns2=\"http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd\">\n" +
                "    <Product>\n" +
                "      <Identifiers>\n" +
                "        <MarketplaceASIN>\n" +
                "          <MarketplaceId>ATVPDKIKX0DER</MarketplaceId>\n" +
                "          <ASIN>059035342X</ASIN>\n" +
                "        </MarketplaceASIN>\n" +
                "      </Identifiers>\n" +
                "      <AttributeSets>\n" +
                "        <ns2:ItemAttributes xml:lang=\"en-US\">\n" +
                "          <ns2:Author>Rowling, J.K.</ns2:Author>\n" +
                "          <ns2:Binding>Paperback</ns2:Binding>\n" +
                "          <ns2:Brand>Scholastic Press</ns2:Brand>\n" +
                "          <ns2:Creator Role=\"Illustrator\">GrandPré, Mary</ns2:Creator>\n" +
                "          <ns2:Edition>1st</ns2:Edition>\n" +
                "          <ns2:Feature>Recommended Age: 9 years and up</ns2:Feature>\n" +
                "          <ns2:ItemDimensions>\n" +
                "            <ns2:Height Units=\"inches\">0.80</ns2:Height>\n" +
                "            <ns2:Length Units=\"inches\">7.50</ns2:Length>\n" +
                "            <ns2:Width Units=\"inches\">5.20</ns2:Width>\n" +
                "            <ns2:Weight Units=\"pounds\">0.50</ns2:Weight>\n" +
                "          </ns2:ItemDimensions>\n" +
                "          <ns2:IsAutographed>false</ns2:IsAutographed>\n" +
                "          <ns2:IsMemorabilia>false</ns2:IsMemorabilia>\n" +
                "          <ns2:Label>Scholastic Paperbacks</ns2:Label>\n" +
                "          <ns2:Languages>\n" +
                "            <ns2:Language>\n" +
                "              <ns2:Name>english</ns2:Name>\n" +
                "              <ns2:Type>Unknown</ns2:Type>\n" +
                "            </ns2:Language>\n" +
                "            <ns2:Language>\n" +
                "              <ns2:Name>english</ns2:Name>\n" +
                "              <ns2:Type>Original Language</ns2:Type>\n" +
                "            </ns2:Language>\n" +
                "            <ns2:Language>\n" +
                "              <ns2:Name>english</ns2:Name>\n" +
                "              <ns2:Type>Published</ns2:Type>\n" +
                "            </ns2:Language>\n" +
                "          </ns2:Languages>\n" +
                "          <ns2:ListPrice>\n" +
                "            <ns2:Amount>10.99</ns2:Amount>\n" +
                "            <ns2:CurrencyCode>USD</ns2:CurrencyCode>\n" +
                "          </ns2:ListPrice>\n" +
                "          <ns2:Manufacturer>Scholastic Paperbacks</ns2:Manufacturer>\n" +
                "          <ns2:NumberOfItems>1</ns2:NumberOfItems>\n" +
                "          <ns2:NumberOfPages>320</ns2:NumberOfPages>\n" +
                "          <ns2:PackageDimensions>\n" +
                "            <ns2:Height Units=\"inches\">1.00</ns2:Height>\n" +
                "            <ns2:Length Units=\"inches\">7.50</ns2:Length>\n" +
                "            <ns2:Width Units=\"inches\">5.20</ns2:Width>\n" +
                "            <ns2:Weight Units=\"pounds\">0.50</ns2:Weight>\n" +
                "          </ns2:PackageDimensions>\n" +
                "          <ns2:PackageQuantity>1</ns2:PackageQuantity>\n" +
                "          <ns2:PartNumber>9780590353427</ns2:PartNumber>\n" +
                "          <ns2:ProductGroup>Book</ns2:ProductGroup>\n" +
                "          <ns2:ProductTypeName>ABIS_BOOK</ns2:ProductTypeName>\n" +
                "          <ns2:PublicationDate>1999-10-01</ns2:PublicationDate>\n" +
                "          <ns2:Publisher>Scholastic Paperbacks</ns2:Publisher>\n" +
                "          <ns2:ReleaseDate>1999-09-08</ns2:ReleaseDate>\n" +
                "          <ns2:SmallImage>\n" +
                "            <ns2:URL>http://ecx.images-amazon.com/images/I/51MU5VilKpL._SL75_.jpg</ns2:URL>\n" +
                "            <ns2:Height Units=\"pixels\">75</ns2:Height>\n" +
                "            <ns2:Width Units=\"pixels\">51</ns2:Width>\n" +
                "          </ns2:SmallImage>\n" +
                "          <ns2:Studio>Scholastic Paperbacks</ns2:Studio>\n" +
                "          <ns2:Title>Harry Potter and the Sorcerer's Stone (Book 1)</ns2:Title>\n" +
                "        </ns2:ItemAttributes>\n" +
                "      </AttributeSets>\n" +
                "      <Relationships/>\n" +
                "      <SalesRankings>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>book_display_on_website</ProductCategoryId>\n" +
                "          <Rank>401</Rank>\n" +
                "        </SalesRank>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>15356791</ProductCategoryId>\n" +
                "          <Rank>5</Rank>\n" +
                "        </SalesRank>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>3153</ProductCategoryId>\n" +
                "          <Rank>8</Rank>\n" +
                "        </SalesRank>\n" +
                "        <SalesRank>\n" +
                "          <ProductCategoryId>17468</ProductCategoryId>\n" +
                "          <Rank>16</Rank>\n" +
                "        </SalesRank>\n" +
                "      </SalesRankings>\n" +
                "    </Product>\n" +
                "  </Products>\n" +
                "</ListMatchingProductsResult>\n" +
                "<ResponseMetadata>\n" +
                "  <RequestId>3b805a12-689a-4367-ba86-EXAMPLE91c0b</RequestId>\n" +
                "</ResponseMetadata>\n" +
                "</ListMatchingProductsResponse>";
        JSONObject xmlJSONObj = XML.toJSONObject(xml);

        System.out.println(xmlJSONObj.toString());

    }
}
