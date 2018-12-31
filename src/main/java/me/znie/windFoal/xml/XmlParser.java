package me.znie.windFoal.xml;

import me.znie.windFoal.container.XmlContainer;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * xml解析器
 * @author znie
 */
public class XmlParser {

    public static void getXml(String filePath){
        try{
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(filePath));
            Element root = document.getRootElement();

            Iterator it = root.elementIterator();
            while(it.hasNext()){
                Element element = (Element) it.next();
                //tag 返回 gw trans等
                String tag = element.getName();
                String tagid = element.attributeValue("id");
                String path = tag.concat(":").concat(tagid);
                XmlContainer.getINSTANCE().addElement(path,element);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        XmlParser.getXml("C:\\workspace\\me.znie\\windFoal\\src\\main\\resources\\conf\\trans\\trans.xml");
        XmlParser.getXml("C:\\workspace\\me.znie\\windFoal\\src\\main\\resources\\conf\\gw\\gws.xml");
        System.out.println(XmlContainer.getINSTANCE().getAllKeys());
    }
}
