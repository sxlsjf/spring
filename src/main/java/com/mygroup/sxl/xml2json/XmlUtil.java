package com.mygroup.sxl.xml2json;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

/**
 * @Author: shenxl
 * @Date: 2019/12/6 13:15
 * @Version 1.0
 * @description：${description}
 */
public class XmlUtil {

  /*  public static JSONObject xml2JSON(byte[] xml) throws JDOMException, IOException {
        JSONObject json = new JSONObject();
        InputStream is = new ByteArrayInputStream(xml);
        SAXBuilder sb = new SAXBuilder();
        org.jdom2.Document doc = sb.build(is);
        Element root = doc.getRootElement();
        json.put(root.getName(), iterateElement(root));
        return json;
    }*/

   /* private static JSONObject iterateElement(Element element) {
        List node = element.getChildren();
        Element et = null;
        JSONObject obj = new JSONObject();
        List list = null;
        for (int i = 0; i < node.size(); i++) {
            list = new LinkedList();
            et = (Element) node.get(i);
            if (et.getTextTrim().equals("")) {
                if (et.getChildren().size() == 0)
                    continue;
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(iterateElement(et));
                obj.put(et.getName(), list);
            } else {
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(et.getTextTrim());
                obj.put(et.getName(), list);
            }
        }
        return obj;
    }
*/

    public static JSONObject xml2jsonString(String xml) throws JSONException, IOException {


        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        return xmlJSONObj;
    }



    public static void main(String[] args) throws JDOMException, IOException {


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
        JSONObject json=xml2jsonString(xml);

     //   System.out.println(json.toString());

        Object s =json.getJSONObject("ListMatchingProductsResponse")
                .getJSONObject("ListMatchingProductsResult")
                .getJSONObject("Products")
                .getJSONObject("Product")
                .getJSONObject("AttributeSets")
                .getJSONObject("ns2:ItemAttributes")
                .get("ns2:NumberOfItems")

               ;
        System.out.println(s.toString());


     //   System.out.println(json.get("ListMatchingProductsResponse"));

    }
}
